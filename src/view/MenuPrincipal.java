package view;

import controller.*;

import java.util.Scanner;

public class MenuPrincipal {
    public static void exibirMenuPrincipal(){
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("+ -------------------------- +");
            System.out.println("|        Bem-vindo(a)!       |");
            System.out.println("| ---------------------------|");
            System.out.println("| 1 - Catalogo de filmes     |");
            System.out.println("| 2 - Bilheteria             |");
            System.out.println("| 3 - Lanchonete             |");
            System.out.println("| 4 - Gerencia               |");
            System.out.println("| 0 - Sair                   |");
            System.out.println("+ -------------------------- +");
            System.out.print("| > ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            ControleMenuPrincipal.opcoes(opcao); /// leva para o controler para melhorar organização

        } while (opcao != 0);

        scanner.close();
    }
}

