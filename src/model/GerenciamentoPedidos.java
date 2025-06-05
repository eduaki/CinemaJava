package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoPedidos {


    private static List<Produto> cardapio = new ArrayList<>();
    private static List<Pedido> listaPedido = new ArrayList<>();

    public GerenciamentoPedidos(){
        cardapio.add(new Produto(60.0f, "Combo"));
        cardapio.add(new Produto(40.0f, "Pipoca(com manteiga)"));
        cardapio.add(new Produto(25.0f, "Bebida 500ml"));
    }

    public static List<Produto> pegaCardapio(){
        return cardapio;
    }

    public static void fazerPedido(Pedido pedido){
        listaPedido.add(pedido);

    }

}
