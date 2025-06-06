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

    int numeroPedido = 1000 + random.nextInt(9999);
        List<Produto> cardapio = GerenciamentoPedidos.pegaCardapio();

        for (int item : itensPedido) {

    public static void fazerPedido(int[] itensPedido){
    private static final Random random = new Random();

    static int numeroPedido = 1000 + random.nextInt(9999);
    static float valorTotalPedido = 0;


    public static void fazerPedido(List<Integer> itensPedido){

        List<Produto> cardapio = GerenciamentoPedidos.pegaCardapio();

        //Verificação de estoque antes do pedido
        for (int item : itensPedido) {
            Produto produto = cardapio.get(item - 1);

            if(produto.getQtdEstoque() <= 0) {
                System.out.print("Produto '" + produto.getNome() + "' está fora de estoque!");
                
                return; //cancela o pedido
            }

        //Atualiza estoque e calcula valor
        for (int itemPedido : itensPedido) {
            produto = cardapio.get(itemPedido - 1);
            
            produto.reduzirEstoque(); 
            
            System.out.println(item);
            float valorProduto = cardapio.get(item-1).getValor();
                       

            valorTotalPedido += produto.getValor();
        }
           
            
        }
        System.out.println("+ -------------------------- +");
        System.out.println("|                            |");
        System.out.println("|-----Pedido Finalizado------|");
        System.out.println("+ -------------------------- +");
        System.out.println("| Itens do pedido:           |");
        for (int item : itensPedido) {
            System.out.println("| - " + cardapio.get(item-1).getNome() + "\t|");
        }
        System.out.println("|Valor do pedido R$" + valorTotalPedido + "\t|");
        System.out.println("|                            |");
        System.out.println("+ -------------------------- +");

        System.out.println("\n");
            System.out.println(item);
            float valorProduto = cardapio.get(item-1).getValor();

            valorTotalPedido += valorProduto;
            
        }
        System.out.println("+ -------------------------- +");
        System.out.println("|                            |");
        System.out.println("|-----Pedido Finalizado------|");
        System.out.println("+ -------------------------- +");
        System.out.println("| Itens do pedido:           |");
        for (int item : itensPedido) {
            System.out.println("| - " + cardapio.get(item-1).getNome() + "\t|");
        }
        System.out.println("|Valor do pedido R$" + valorTotalPedido + "\t|");
        System.out.println("|                            |");
        System.out.println("+ -------------------------- +");

        System.out.println("\n");



        Pedido pedido = new Pedido(itensPedido, valorTotalPedido, numeroPedido);
        GerenciamentoPedidos.fazerPedido(pedido);   
        

    }



}
