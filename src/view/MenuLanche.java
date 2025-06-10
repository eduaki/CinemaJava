package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import  controller.*;
import model.*;

public class MenuLanche{
    public static void exibirMenuLanche(){

        GerenciamentoPedidos gerenciamentoPedidos = new GerenciamentoPedidos();

        Scanner scanner = new Scanner (System.in);
        int opt;

        do{
            System.out.println("+ -------------------------- +");
            System.out.println("|          LANCHONETE        |");
            System.out.println("| ---------------------------|");
            System.out.println("| 1 - Cardápio               |");
            System.out.println("| 2 - Realizar pedido        |");
            System.out.println("| 3 - Gerenciar pedidos      |");
            System.out.println("| 4 - Controle de estoque    |");
            System.out.println("| 0 - Voltar                 |");
            System.out.println("+ -------------------------- +");
            System.out.print("| > ");
            opt = scanner.nextInt();
            scanner.nextLine();

            switch (opt){
                case 1:
                    verCardapio();
                    break;
                case 2:
                int optPedido;
                List<Integer> temporario = new ArrayList<>();
                    do{
                        verCardapio();
                        System.out.println("| 0 - Voltar                 |");
                        System.out.println("| 4 - Finalizar Pedido       |");
                        System.out.println("+ -------------------------- +");

                        System.out.print("Produto selecionado: ");
                        optPedido = scanner.nextInt();
                        scanner.nextLine();

                        if(optPedido != 4 && optPedido != 0) {
                            temporario.add(optPedido);
                        }

                        System.out.println("+ -------------------------- +");
                        System.out.println("|          Carrinho          |");
                        System.out.println("|----------------------------|");
                        for(int item : temporario){
                            System.out.println("| - "+ GerenciamentoPedidos.pegaCardapio().get(item-1).getNome());
                        }
                        System.out.println("+ -------------------------- +");
                        System.out.println("\n");
                        

                    }while( optPedido != 4);
                    ControleLanchonete.fazerPedido(temporario);
                    temporario = null;
                    break;
                case 3:
                
                MenuHistorico.menuHistorico();
                
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal");;
                    break;
                case 0:
                    MenuPrincipal.exibirMenuPrincipal();
                    break;
                default:
                    System.out.println("Opcao invalida, escolha de 1 a 4...");

            }
        }while(opt != 0);

        scanner.close();
    }

    public static void verCardapio(){
        System.out.println("+ -------------------------- +");
        System.out.println("|           Opções           |");
        System.out.println("|----------------------------|");
        System.out.println("| 1 - Combo:                 |");
        System.out.println("|   . Pipoca + Bebida        |");
        System.out.println("| 2 - Pipoca                 |");
        System.out.println("| 3 - Bebida                 |");
        System.out.println("+ ---------------------------+");

    }

    public static void pedidoFinalizado(List<Integer> itensPedido, List<Produto> cardapio, float valorTotalPedido){

        System.out.println("+ --------------------------- +");
        System.out.println("|     Pedido Finalizado       |");
        System.out.println("+ --------------------------- +");
        System.out.println("| Itens do pedido:            |");
        for (int item : itensPedido) {
            System.out.println("| - " + cardapio.get(item-1).getNome());
        }
        System.out.println("|");
        System.out.println("|Valor do pedido R$" + valorTotalPedido);
        System.out.println("+ --------------------------- +");

        System.out.println("\n");
    }

}

