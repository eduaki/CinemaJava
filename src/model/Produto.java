package model;

public class Produto{
    private float valor;
    private String nome;
    private int qtdEstoque;

    public Produto(float valor, String nome, int qtdEstoque){
        this.nome = nome;
        this.valor = valor;
        this.qtdEstoque = qtdEstoque;
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

    public int getQtdEstoque() {
        return qtdEstoque;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }

    public boolean reduzirEstoque(int quantidade) {
        if (quantidade > 0 && this.qtdEstoque >= quantidade) {
            this.qtdEstoque -= quantidade;
            return true;
        }
        else {
            return false;
        }
       
    }

}