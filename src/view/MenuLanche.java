package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.ControleLanchonete;

public class MenuLanche{
    public static void exibirMenuLanche(){

        Scanner scanner = new Scanner (System.in);
        int opt;

        do{
            System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _  ");
            System.out.println("|                            |");
            System.out.println("| --------LANCHONETE---------|");
            System.out.println("| 1 - Cardápio               |");
            System.out.println("| 2 - Realizar pedido        |");
            System.out.println("| 3 - Histórico de pedidos   |");
            System.out.println("| 4 - Controle de estoque    |");
            System.out.println("| 0 - Voltar                 |");
            System.out.println("|_ _ _ _ _ _ _ _ _ _ _ _ _ _ |");
            System.out.print("Opção escolhida: ");
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
                        System.out.println("| 0 - Voltar             |");
                        System.out.println("| 4 - Finalizar Pedido   |");
                        System.out.println("Produto selecionado:");
                        optPedido = scanner.nextInt();
                        scanner.nextLine();

                        if(optPedido != 4 && optPedido != 0) {
                            temporario.add(optPedido);
                        }

                        

                    }while( optPedido != 4);
                    if(temporario != null){
                        ControleLanchonete.fazerPedido(temporario);
                        break;
                    }else{
                        break;
                    }
                case 3:
                    System.out.println("Acessando historico de compras");
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
        System.out.println("  _ _ _ _ _ _ _ _ _ _ _ _ _  ");
        System.out.println("|                           |");
        System.out.println("|----------Opções-----------|");
        System.out.println("| 1 - Combo:                |");
        System.out.println("|   . Pipoca + Bebida       |");
        System.out.println("| 2 - Pipoca                |");
        System.out.println("| 3 - Bebida                |");
        System.out.println("|                           |");
        System.out.println("  _ _ _ _ _ _ _ _ _ _ _ _ _  ");

    }
}

