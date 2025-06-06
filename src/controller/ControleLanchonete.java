package controller;

import java.util.List;
import java.util.Random;

import model.*;
import view.MenuHistorico;
import view.MenuLanche;


public class ControleLanchonete {
    static GerenciamentoPedidos gerenciamentoPedidos = new GerenciamentoPedidos();

    private static Random random = new Random();

    static int numeroPedido = 1000 + random.nextInt(9999);
    static float valorTotalPedido = 0;

    static List<Produto> cardapio = GerenciamentoPedidos.pegaCardapio();

    public static void fazerPedido(List<Integer> itensPedido){


        for (int item : itensPedido) {

            System.out.println(item);
            float valorProduto = cardapio.get(item-1).getValor();

            valorTotalPedido += valorProduto;
            
        }
        MenuLanche.pedidoFinalizado(itensPedido, cardapio, valorTotalPedido);


        Pedido pedido = new Pedido(itensPedido, valorTotalPedido, numeroPedido);
        GerenciamentoPedidos.fazerPedido(pedido);   
        

    }


    public static void verHistorico(){
        List<Pedido> historico = GerenciamentoPedidos.verHistorico();

        MenuHistorico.exibirHistorico(historico, cardapio);

      
    }



}
