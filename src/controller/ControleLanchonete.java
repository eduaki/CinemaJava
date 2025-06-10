package controller;

import java.util.List;
import java.util.Random;

import model.*;
import view.MenuHistorico;
import view.MenuLanche;


public class ControleLanchonete {
    static GerenciamentoPedidos gerenciamentoPedidos = new GerenciamentoPedidos();

    private static Random random = new Random();

    
    static List<Produto> cardapio = GerenciamentoPedidos.pegaCardapio();
    
    public static boolean fazerPedido(List<Integer> itensPedido){
        
         int numeroPedido = 1000 + random.nextInt(9999);
        float valorTotalPedido = 0;

        for (int item : itensPedido) {

            System.out.println(item);
            float valorProduto = cardapio.get(item-1).getValor();

            valorTotalPedido += valorProduto;
            
        }
        MenuLanche.pedidoFinalizado(itensPedido, cardapio, valorTotalPedido);


        Pedido pedido = new Pedido(itensPedido, valorTotalPedido, numeroPedido);

        for(Pedido p : GerenciamentoPedidos.verHistorico()){
            if(numeroPedido == p.getNumeroPedido()){
                System.out.println("pedido ja existente");
                return false;
            }
        }

        GerenciamentoPedidos.fazerPedido(pedido);   

        return true;
    }


    public static void verHistorico(){
        List<Pedido> historico = GerenciamentoPedidos.verHistorico();

        MenuHistorico.exibirHistorico(historico, cardapio);
      
    }

    public static boolean cancelarPedido(int numeroPedido){
        return GerenciamentoPedidos.cancelarPedido(numeroPedido);
    }

    public static boolean removerPedido(int nPedido){
        List<Pedido> listaPedidos = GerenciamentoPedidos.verHistorico();

        if(listaPedidos.isEmpty()) return false;

        for(Pedido p : listaPedidos){
            if(p.getNumeroPedido() == nPedido){
                GerenciamentoPedidos.removePedido(p);
            }else{
                System.out.println("[Pedido não encontrado!]");
                return false;
            }
        }

        return true;
    }

}
