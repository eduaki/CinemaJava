package controller;

import model.Sessao;
import model.Filme;
import model.Sala;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;

    public class ControleSessao{
        private List<Sessao> sessoes;

    public ControleSessao(){
        this.sessoes = new ArrayList<>();
    }

    public static ControleSessao criarComSessoesPadrao(){
        ControleSessao controle  = new ControleSessao();

        Sala sala1 = new Sala (1, 10);
        Sala sala2 = new Sala (2, 10);

        List<Filme> filmes = Catalogo.getFilmes();

        if(!filmes.isEmpty()){
            controle.adicionarSessao(new Sessao (filmes.get(0), sala1, LocalTime.of(18, 30)));
            if(filmes.size() > 1){
                controle.adicionarSessao(new Sessao(filmes.get(1), sala2, LocalTime.of(20, 0)));
            }
            if (filmes.size() > 2) {
                controle.adicionarSessao(new Sessao(filmes.get(2), sala1, LocalTime.of(22, 15)));
        }
    }

        return controle;

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

        public void exibirSessoes() {
            if(sessoes.isEmpty()) {
                System.out.println("Nenhuma sessão disponível.");
                return;
            }
            for (int i = 0 ; i < sessoes.size(); i++){
                Sessao sessao = sessoes.get(i);
                System.out.println((i + 1) + " - Filme: " + sessao.getFilme().getTitulo() + 
                           "\n Sala: " + sessao.getSala().getNumero() + 
                           " - Hora: " + sessao.getHora() +
                           "\n Ingressos disponíveis: " + sessao.getIngressoDisponivel() +
                           "\n--------------------------------"); 
            }
        }

        public boolean verificaSessao(int idSessao) {
            return idSessao >= 0 && idSessao < sessoes.size();
        }

        public void adicionarSessao(Sessao sessao){
            sessoes.add(sessao);
        }

        public Sessao getSessaoPorId(int id){
            if (id >= 0 && id < sessoes.size()){
                return sessoes.get(id);

            }
            return null;

        }
    }

