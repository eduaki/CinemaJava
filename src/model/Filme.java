package model;

public class Filme {

    private String titulo;
    private int classificacao;
    private String genero;
    private int duracao;

    public Filme(String titulo, String genero, int duracao, int classificacao) {
        this.titulo = titulo;
        this.classificacao = classificacao;
        this.genero = genero;
        this.duracao = duracao;
    }

    //getters e setters
    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getClassificacao() {
        return this.classificacao;
    }
    public void setClassificacao(int classificacao) {
        this.classificacao = classificacao;
    }

    public String getGenero() {
        return this.genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracao() {
        return this.duracao;
    }
    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    @Override
    public String toString() {
        return "Titulo" + this.titulo + "Classificacao" +  this.classificacao + "Genero" + this.genero + "Duracao" + this.duracao;
    }
}

