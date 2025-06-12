package controller;
import model.Filme;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
        private static List<Filme> filmes = new ArrayList<>();

        static{
            filmes.add(new Filme("Lilo & Stitch","Animacao", 108, 10));
            filmes.add(new Filme("Premonição 6: Laços de sangue","Terror",110, 18));
            filmes.add(new Filme("Minecraft","Comédia",101, 10));
        }

        public static void cadastrarFilme(Filme filme) {
            filmes.add(filme);
        }

        public static void removerFilmePorID(Filme filme) {
            filmes.remove(filme);
        }

        public static List<Filme> getFilmes() {
            return  filmes;
        }

}


