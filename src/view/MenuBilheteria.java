package view;

import java.util.Map;

import controller.ControleIngressos;
import controller.ControleSessao;
import model.Cliente;
import model.Sala;
import model.Sessao;
import utilidades.InputHelper;

public class MenuBilheteria {

    private static ControleIngressos controleIngressos;
    private static ControleSessao controleSessao;
    private static Cliente cliente;

    final static String VERDE = "\u001B[32m";
    final static String VERMELHO = "\u001B[31m";
    final static String RESET = "\u001B[0m";

    public MenuBilheteria(Cliente cliente, ControleIngressos controleIngressos, ControleSessao controleSessao) {
        MenuBilheteria.cliente = cliente;
        MenuBilheteria.controleIngressos = controleIngressos;
        MenuBilheteria.controleSessao = controleSessao;
    }

    public static void exibirMenu() {
        int opcao;

        do {
            System.out.println("+ -------------------------- +");
            System.out.println("|         Bilheteria         |");
            System.out.println("+ -------------------------- +");
            System.out.println("| 1 - Comprar Ingresso       |");
            System.out.println("| 2 - Sessões Disponíveis    |");
            System.out.println("| 3 - Cancelar ingresso      |");
            System.out.println("| 0 - Voltar                 |");
            System.out.println("+ -------------------------- +");
            opcao = InputHelper.pegaInt("| > ");

            switch (opcao) {
                case 1:
                    comprarIngresso();
                    break;
                case 2:
                    verSessoes();
                    break;
                case 3:
                    cancelarIngresso();
                    break;
                case 0: 
                /// só pra não dar erro
                break;
                default:
                
                    System.out.println(" ---------------------------- ");
                    System.out.println("| \u001B[31mOpção inválida!\u001B[0m            |");
                    System.out.println(" ---------------------------- ");
                break;

            }
        } while (opcao != 0);
    }

    private static void verSessoes() {
        System.out.println("+ -------------------------- +");
        System.out.println("|    Sessões disponíveis:    |");
        System.out.println("+ -------------------------- +");
        controleSessao.exibirSessoes();
    }

    public static void comprarIngresso() {
        verSessoes();
        int idSessaoUsuario = InputHelper.pegaInt("| Sessão desejada > ");
        int idSessao = idSessaoUsuario - 1;

        if (!controleSessao.verificaSessao(idSessao)) {
            System.out.println(" ---------------------------- ");
            System.out.println("| \u001B[31mSessão inválida!\u001B[0m           |");
            System.out.println(" ---------------------------- ");
            return;
        }
        
        Sessao sessao = controleSessao.getSessaoPorId(idSessao);
        Sala sala = sessao.getSala();
        
        System.out.println(  """
            + -------------------------- +
            |          Ingressos         |
            + -------------------------- +""");
            System.out.printf("| Inteira: R$%.2f           |\n", sessao.getPrecoInteira());
            System.out.printf("| Meia entrada: R$%.2f      |\n", sessao.getPrecoMeia());
            System.out.println(    "+ -------------------------- +");
        if(MenuCadastro.menuVoltarContinuar()){
            int quantidade = InputHelper.pegaInt("| Quantidade > ");
            System.out.println(    "+ -------------------------- +");
    
            double totalCompra = 0.0;
                for (int i = 0; i < quantidade; i++) {
    
                int tipoIngresso;
                do {
                    System.out.println(  """
                                            + -------------------------- +
                                            |      Tipo do Ingresso      |
                                            + -------------------------- +""");
                    System.out.println(  "| 1 - Inteira                |");
                    System.out.println(  "| 2 - Meia Entrada           |");
                    System.out.println(  "+ -------------------------- +");
                    tipoIngresso = InputHelper.pegaInt("| > ");
                    System.out.println(  "+ -------------------------- +");
    
                    if (tipoIngresso != 1 && tipoIngresso != 2) {
                        System.out.println("\u001B[31mErro: Escolha inválida! Digite 1 para Inteira ou 2 para Meia Entrada.\u001B[0m");
                        System.out.println("-------------------------------------\n");
                    }
                } while (tipoIngresso != 1 && tipoIngresso != 2);
                
    
                boolean meiaEntrada = (tipoIngresso == 2);
    
                Map<String, Boolean> assentos = Sala.getAssentos();
    
                    char[] fileiras = {'A', 'B', 'C', 'D', 'E'};
                    int colunas = 6;
    
                    System.out.println("\njAssentos disponíveis:\n");
    
                    for (char fileira : fileiras) {
                        for (int numero = 1; numero <= colunas; numero++) {
                            String codigo = String.format("%s%d", fileira, numero) ;
                            Boolean status = assentos.get(codigo);
    
                            if (status != null && status) {
                                // Livre
                                System.out.print(VERDE + codigo + RESET + " ");
                            } else {
                                // Ocupado
                                System.out.print(VERMELHO + codigo + RESET + " ");
                            }
                        }
                        System.out.println();
                    }
    
                System.out.println("\nEscolha um assento: ");
                String assentoEscolhido = InputHelper.pegaString("(Ex: A1) > ");
    
                boolean sucesso = controleIngressos.venderIngresso(cliente, idSessao, meiaEntrada, assentoEscolhido);
                if (!sucesso) {
                    i--;
                }
            }
            System.out.println("\n\u001B[32mCOMPRA EFETUADA COM SUCESSO!\u001B[0m");
            System.out.println("\t\u001B[32mBOM FILME!\u001B[0m\n");
        }
    }

    private static void cancelarIngresso() {
        verSessoes();
        int idSessaoUsuario = InputHelper.pegaInt("\nDigite o ID da sessão para cancelamento: ");
        int idSessao = idSessaoUsuario - 1;

        if (!controleSessao.verificaSessao(idSessao)) {
            System.out.println("\n\u001B[31mSessão inválida.\u001B[0m\n");
            return;
        }

        boolean sucesso = controleIngressos.cancelarIngresso(cliente, idSessao);
        if (sucesso) {
            System.out.println("\n\u001B[32mCancelamento efetuado com sucesso.\u001B[0m\n");
        }
    }
}
