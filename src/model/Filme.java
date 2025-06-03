package model;

public class Filme {

    private String titulo;
    private int classificacao;
    private String genero;
    private int duracao;

    public Filme(String titulo, String genero, int duracao) {
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
        return this.titulo + " - " + this.classificacao + " - " + this.genero + " - " + this.duracao;
    }

    public void exibirInformacoes() {
        System.out.println("Título: " + titulo);
        System.out.println("Gênero: " + genero);
        System.out.println("Duração: " + duracao + " minutos");
        System.out.println("Classificação: " + classificacao);
        System.out.println("------------------------------");
    }
}

