package view;

import java.util.Scanner;

public class MenuLanche{
    public void exibirMenuLanche(){

        Scanner scanner = new Scanner (System.in);
        int opcao;

        do{
            System.out.println("\n Menu Lanchonete");
            System.out.println("1 - Ver opcoes");
            System.out.println("2 - Comprar");
            System.out.println("3 - Historico de compras");
            System.out.println("4 - Voltar ao menu principal");

            opcao = scanner.nextInt();

            switch (opcao){
                case 1:
                    System.out.println("Acessando opcoes");
                    break;
                case 2:
                    System.out.println("Acessando compra");
                    break;
                case 3:
                    System.out.println("Acessando historico de compras");
                    break;
                case 4:
                    System.out.println("Voltando ao menu principal");;
                    break;
                default:
                    System.out.println("Opcao invalida, escolha de 1 a 4...");

            }
        }while(opcao != 4);
        scanner.close();
    }
}

