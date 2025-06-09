package view;

import controller.ControleIngressos;
import controller.ControleSessao;
import model.Cliente;
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
            System.out.println("o =========================== o");
            System.out.println("|         BILHETERIA          |");
            System.out.println("o =========================== o");
            System.out.println("| 1 - Comprar Ingresso        |");
            System.out.println("| 2 - Ver Sessões Disponíveis |");
            System.out.println("| 0 - Voltar                  |");
            System.out.println("o =========================== o");
            opcao = InputHelper.pegaInt("Opção escolhida: ");

            switch (opcao) {
                case 1:
                    comprarIngresso();
                    break;
                case 2:
                    verSessoes();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
    }

    private void verSessoes() {
        System.out.println("\n*** SESSÕES DISPONÍVEIS ***");
        controleSessao.exibirSessoes(); // método que exibe sessões
    }

    private void comprarIngresso() {
        verSessoes();
        int idSessaoUsuario = InputHelper.pegaInt("Digite o ID da sessão desejada: ");
        int idSessao = idSessaoUsuario - 1;

        if (!controleSessao.verificaSessao(idSessao)) {
            System.out.println("Sessão inválida.");
            return;
        }

        boolean sucesso = controleIngressos.venderIngresso(cliente, idSessao);

        if (sucesso) {
            System.out.println("Ingresso comprado com sucesso!");
        } else {
            System.out.println("Erro ao comprar ingresso.");
        }
    }
}