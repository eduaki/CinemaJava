package controller;
import model.Filme;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
        private List<Filme> filmes = new ArrayList<>();

        public Catalogo() {
            this.filmes = new ArrayList<>();
        }

        public void cadastrarFilme(Filme filme) {
            filmes.add(filme);
        }

        public void removerFilme(Filme filme) {
            filmes.remove(filme);
        }

        public List<Filme> getFilmes() {
            return  filmes;
        }

}


