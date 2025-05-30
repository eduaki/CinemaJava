package view;

import java.util.Scanner;

public class MenuPrincipal {
    public static void exibirMenuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu Principal Cine Compila");
            System.out.println("1 - Catalogo de filmes");
            System.out.println("2 - Bilheteria");
            System.out.println("3 - Lanchonete");
            System.out.println("4 - Gerencia");
            System.out.println("0 - Sair");
            System.out.print("Digite sua opcao desejada: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Acessando o catalogo...");
                    break;
                case 2:
                    System.out.println("Acessando bilheteria...");
                    break;
                case 3:
                    MenuLanche.exibirMenuLanche();
                    break;
                case 4:
                    System.out.println("Acessando gerencia...");
                    break;
                case 0:
                    System.out.println("Saindo... Obrigada e volte sempre");
                    break;
                default:
                    System.out.println("Opcao invalida, escolha de 1 a 4...");
                    break;
            }
        } while(opcao != 0);
        
        scanner.close();
    }
}

