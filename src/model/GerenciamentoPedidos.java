package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoPedidos {


    private List<Produto> cardapio = new ArrayList<>();
    private List<Pedido> listaPedido = new ArrayList<>();

    GerenciamentoPedidos(){
        cardapio.add(new Produto(60.0f, "Combo"));
        cardapio.add(new Produto(40.0f, "Pipoca(com manteiga)"));
        cardapio.add(new Produto(25.0f, "Bebida 500ml"));
    }

    public List<Produto> pegaProdutos(){
        return cardapio;
    }

    // public float fazerPedido(Pedido pedido){
    //     listaPedido.add(pedido);

    //     return pedido.getValorTotalPedido();

    // }

}
