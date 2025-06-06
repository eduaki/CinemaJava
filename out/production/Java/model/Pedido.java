package model;

import java.util.List;

public class Pedido {

    private List<Integer> produtos;
    private float valorTotalPedido;
    private int numeroPedido;

    public Pedido(List<Integer> itensPedido, float valorTotalPedido, int numeroPedido){
        this.produtos = itensPedido;
        this.valorTotalPedido = valorTotalPedido;
        this.numeroPedido = numeroPedido;
    }
    
    public List<Integer> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Integer> produtos) {
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
