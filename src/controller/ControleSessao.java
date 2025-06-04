package controller;

import model.Sessao;

import java.util.ArrayList;
import java.util.List;

    public class ControleSessao{
        private List<Sessao> sessoes;

    public ControleSessao(){
        this.sessoes = new ArrayList<>();
    }

    public List<Sessao> listarSessoes() {
        return sessoes;
    }

    public List<Sessao> listarSessoesPorFilme(String nomeFilme) {
        List<Sessao> resultado = new ArrayList<>();
        for (Sessao s : sessoes) {
            if (s.getFilme().getTitulo().equalsIgnoreCase(nomeFilme)) {
                resultado.add(s);
            }
        }
        return resultado;
    }
}

    //metodo para verificar se existe filme disponivel

