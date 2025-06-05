package controller;
import model.Filme;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
        private static List<Filme> filmes = new ArrayList<>();

        public Catalogo() {
            this.filmes = new ArrayList<>();
        }

        public static void cadastrarFilme(Filme filme) {
            filmes.add(filme);
        }

        public static void removerFilme(Filme filme) {
            filmes.remove(filme);
        }

        public static List<Filme> getFilmes() {
            return  filmes;
        }

}


