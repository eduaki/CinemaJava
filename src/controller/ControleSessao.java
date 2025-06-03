package control;

import model.Sala;
import model.Sessao;
import model.Filme;

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

    //metodo para comprar ingresso

    //metodo para verificar se existe ingresso disponivel
    //metodo para verificar se existe sala disponivel
    //metodo para verificar se existe horario disponivel
    //metodo para verificar se existe filme disponivel

