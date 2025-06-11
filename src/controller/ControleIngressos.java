package controller;

import model.Cliente;
import model.Ingresso;
import model.Sala;
import model.Sessao;

public class ControleIngressos {

    private ControleSessao controleSessao;

    public ControleIngressos(ControleSessao controleSessao) {
        this.controleSessao = controleSessao;
    }

    public boolean venderIngresso(Cliente cliente, int idSessao, boolean meiaEntrada, String assento) {
        Sessao sessao = controleSessao.getSessaoPorId(idSessao);
        if (sessao == null) {
            System.out.println("\n\u001B[31mSessão não encontrada!\u001B[0m");
            return false;
        }

        Sala sala = sessao.getSala();

        if (!sala.assentoExiste(assento)) {
            System.out.println("\n\u001B[31mErro: Assento não existe!\u001B[0m");
            return false;
        }

        if (!sala.verificarDisponibilidade(assento)) {
            System.out.println("\n\u001B[31mAssento já ocupado!\u001B[0m");
            return false;
        }

        sala.reservarAssento(assento);
        Ingresso ingresso = new Ingresso(cliente, sessao, meiaEntrada, assento);
        sessao.adicionarIngresso(ingresso);
        sessao.diminuirIngressosDisponiveis();
        System.out.println("\n\u001B[32mASSENTO RESERVADO: " + assento + "\u001B[0m");
        return true;
    }

    public boolean cancelarIngresso(Cliente cliente, int idSessao) {
        Sessao sessao = controleSessao.getSessaoPorId(idSessao);

        if (sessao != null) {
            if (sessao.clientePossuiIngresso(cliente)) {
                sessao.devolverIngresso(cliente);
                System.out.println("\nIngresso cancelado e devolvido para a sessão.");
                return true;
            } else {
                System.out.println("\n-------------------------------------");
                System.out.println("\u001B[31mErro: Cliente não possui ingresso na sessão.\u001B[0m");
                System.out.println("-------------------------------------\n");
                return false;
            }
        } else {
            System.out.println("\n\u001B[31mSessão não encontrada.\u001B[0m");
            return false;
        }
    }

    public boolean clienteTemIngresso(Cliente cliente, int idSessao) {
        Sessao sessao = controleSessao.getSessaoPorId(idSessao);

        if (sessao != null) {
            return sessao.clientePossuiIngresso(cliente);
        } else {
            System.out.println("\n\u001B[31mSessão não encontrada.\u001B[0m");
            return false;
        }
    }
}




  



 



