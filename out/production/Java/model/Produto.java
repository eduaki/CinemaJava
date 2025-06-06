package model;

public class Produto{
    private float valor;
    private String nome;

    public Produto(float valor, String nome){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValor() {
        return valor;
    }
    public void setValor(float valor) {
        this.valor = valor;
    }
}