package controller;

import java.util.List;
import java.util.Random;

import model.*;


public class ControleLanchonete {
    static GerenciamentoPedidos gerenciamentoPedidos = new GerenciamentoPedidos();

    private static Random random = new Random();

    static int numeroPedido = 1000 + random.nextInt(9999);
    static float valorTotalPedido = 0;


    public static void fazerPedido(List<Integer> itensPedido){

        List<Produto> cardapio = GerenciamentoPedidos.pegaCardapio();

        for (int item : itensPedido) {

            System.out.println(item);
            float valorProduto = cardapio.get(item-1).getValor();

            valorTotalPedido += valorProduto;

        }



        Pedido pedido = new Pedido(itensPedido, valorTotalPedido, numeroPedido);
        GerenciamentoPedidos.fazerPedido(pedido);   
        
    

    }



}
