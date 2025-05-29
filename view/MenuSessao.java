package view;

import java.util.Scanner;

public class MenuSessao{
    public static void exibirMenuSessao(){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do{
            System.out.println("\nMenu Sessao Cine Compila");
            System.out.println("1 - Comprar ingresso");
            System.out.println("2 - Escolher sala de cinema");
            System.out.println("3 - Escolher horario");
            System.out.println("4 - Voltar ao menu principa");

            opcao = scanner.nextInt();

        switch (opcao){
            case 1:
                System.out.println("Acessando compra de ingresso...");
                break;
            case 2:
                System.out.println("Acessando sala");
                break;
            case 3:
                System.out.println("Acessando horarios");
                break;
            case 4:
                System.out.println("Voltar menu principal");
                break;
            default:
                System.out.println("Opcao invalida, escolha de 1 a 4...");
             }
        }while (opcao != 4);
        scanner.close();
    }
}

