package model;


public class Pedido {

    private String[] produtos;
    private float valorTotalPedido;
    private int numeroPedido;

    public Pedido(String[] produtos, float valorTotalPedido){
        this.produtos = produtos;
        this.valorTotalPedido = valorTotalPedido;
    }
    
    public String[] getProdutos() {
        return produtos;
    }
    public void setProdutos(String[] produtos) {
        this.produtos = produtos;
    }

    public float getValor() {
        return valorTotalPedido;
    }
    public void setValor(float valorTotalPedido) {
        this.valorTotalPedido = valorTotalPedido;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }
    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

}
