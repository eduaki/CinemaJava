package controller;

import model.Cliente;
import model.Sessao;


public class ControleIngressos {

  private ControleSessao controleSessao;

    public ControleIngressos(ControleSessao controleSessao){
    this.controleSessao = controleSessao;
  
  }

    public boolean venderIngresso(Cliente cliente, int idSessao) {
    if (!controleSessao.verificaSessao(idSessao)) {
      return false;
      
    }

    Sessao sessao = controleSessao.listarSessoes().get(idSessao);

    if (sessao.getIngressoDisponivel() <= 0){
     return false;
  }

    sessao.setIngressoDisponivel(sessao.get.getIngressoDisponivel() - 1);


    
  return true;
  
}


 

  }


