package view;

import controller.ControleIngressos;
import controller.ControleSessao;
import model.Cliente;
import model.Sessao;
import utilidades.InputHelper;

public class MenuBilheteria {

    private ControleIngressos controleIngressos;
    private ControleSessao controleSessao;
    private Cliente cliente;

    public MenuBilheteria(Cliente cliente, ControleIngressos controleIngressos, ControleSessao controleSessao) {
        this.cliente = cliente;
        this.controleIngressos = controleIngressos;
        this.controleSessao = controleSessao;
    }

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("o =============================== o");
            System.out.println("|           BILHETERIA            |");
            System.out.println("o =============================== o");
            System.out.println("| 1 - Comprar Ingresso            |");
            System.out.println("| 2 - Ver Sessões Disponíveis     |");
            System.out.println("| 3 - Cancelar compra de ingresso |");
            System.out.println("| 0 - Voltar                      |");
            System.out.println("o =============================== o");
            opcao = InputHelper.pegaInt("Escolha uma opção: ");

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
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("\n\u001B[31mOpção inválida!\u001B[0m\n");
            }
        } while (opcao != 0);
    }

    private void verSessoes() {
        System.out.println("\n*** SESSÕES DISPONÍVEIS ***\n");
        controleSessao.exibirSessoes(); // método que exibe sessões
    }

    private void comprarIngresso() {
        verSessoes();
        int idSessaoUsuario = InputHelper.pegaInt("\nDigite o ID da sessão desejada: ");
        int idSessao = idSessaoUsuario - 1;

        if (!controleSessao.verificaSessao(idSessao)) {
            System.out.println("\n\u001B[31mSessão inválida.\u001B[0m\n");
            return;
        }

        Sessao sessao = controleSessao.getSessaoPorId(idSessao);

        System.out.println("\nPreço dos ingressos:");
        System.out.println("Inteira: R$ " + sessao.getPrecoInteira());
        System.out.println("Meia entrada: R$ " + sessao.getPrecoMeia());

        int quantidade = InputHelper.pegaInt("Quantos ingressos deseja comprar?: ");
        System.out.println("Escolha o tipo de ingresso: ");
        System.out.println("\n1 >> INTEIRA");
        System.out.println("2 >> MEIA ENTRADA");
        int tipoIngresso = InputHelper.pegaInt("Opção escolhida: ");

        boolean meiaEntrada = (tipoIngresso == 2);

        boolean sucesso = controleIngressos.venderIngresso(cliente, idSessao, quantidade, meiaEntrada);

        if (sucesso) {
            double precoFinal = meiaEntrada ? sessao.getPrecoMeia() * quantidade : sessao.getPrecoInteira() * quantidade;
            System.out.println("\n\u001B[32m" + " COMPRA EFETUADA COM SUCESSO!\u001B[0m\n");
            System.out.println("\t\u001B[32mBOM FILME!\u001B[0m\n");

        } else {
            System.out.println("\n\u001B[31mErro ao comprar ingresso. Talvez não haja mais lugares!\u001B[0m\n");
        }
    }

    private void cancelarIngresso(){
        verSessoes();

        int idSessaoUsuario = InputHelper.pegaInt("\nDigite o ID da sessão para cancelamento: ");
        int idSessao = idSessaoUsuario - 1;
        if (!controleSessao.verificaSessao(idSessao)){

            System.out.println("\n\u001B[31mSessao inválida.\u001B[0m\n");
            return;
        }

        boolean sucesso = controleIngressos.cancelarIngresso(cliente, idSessao);

        if(sucesso){

            System.out.println("\n\u001B[32mCancelamento efetuado com sucesso.\u001B[0m\n");
        } else {
            System.out.println("\n\u001B[31mErro ao cancelar ingresso.\u001B[0m\n");
        }

    }
}