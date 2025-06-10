package model;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable{

    private List<Integer> produtos;
    private float valorTotalPedido;
    private int numeroPedido;
    private boolean cancelado = false;

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
    
    public boolean getCancelado(){
        return cancelado;
    }  
    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }

    @Override
    public String toString() {
        return "Pedido {" +
            "numeroPedido=" + numeroPedido +
            ", produtos=" + produtos +
            ", valorTotalPedido=" + valorTotalPedido +
            ", cancelado=" + cancelado +
            '}';
    }

}
