package controller;

import model.Cliente;
import model.Ingresso;
import model.Sessao;


public class ControleIngressos {

  private ControleSessao controleSessao;

    public ControleIngressos(ControleSessao controleSessao){
    this.controleSessao = controleSessao;
  
  }

    public boolean venderIngresso(Cliente cliente, int idSessao, int quantidade, boolean meiaEntrada) {
    Sessao sessao = controleSessao.getSessaoPorId(idSessao);

    if (sessao != null && sessao.getIngressoDisponivel() >= quantidade) {
        double valorTotal = 0; 

        for (int i = 0; i < quantidade; i++) {
            Ingresso ingresso = new Ingresso(cliente, sessao, meiaEntrada);
            sessao.adicionarIngresso(ingresso);
            sessao.getListaDeClientesComIngresso().add(cliente);

            valorTotal += ingresso.getPreco(); 
        }

        sessao.diminuirIngressosDisponiveis(quantidade);

        System.out.println("\n\u001B[32m" + quantidade + " ingresso(s) comprado(s) com sucesso!\u001B[0m");
        System.out.println("\u001B[32mValor total: R$ " + valorTotal + "\u001B[0m");

        return true;
    } else {
        System.out.println("\n\u001B[31mErro ao comprar ingresso. Talvez não haja mais lugares!\u001B[0m");
        return false;
    }
}

  public boolean cancelarIngresso(Cliente cliente, int idSessao){

    Sessao sessao = controleSessao.getSessaoPorId(idSessao);

    if(sessao != null){
      if(sessao.clientePossuiIngresso(cliente)){
        sessao.devolverIngresso(cliente);
        System.out.println("Ingresso cancelado e devolvido para a sessão.");
        return true;
      }else {
        System.out.println("Erro: Cliente não possui ingresso na sessão.");
        return false;
      }
    } else {
      System.out.println("Sessão não encontrada.");
      return false;
    }

    }

    public boolean clienteTemIngresso(Cliente cliente, int idSessao){
      Sessao sessao = controleSessao.getSessaoPorId(idSessao);

      if(sessao != null){
        return sessao.clientePossuiIngresso(cliente);
      } else {
        System.out.println("Sessão não encontrada.");
        return false;
      }

    }

  }


  



 



