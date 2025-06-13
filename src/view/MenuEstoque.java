package view;

import java.util.Scanner;

import controller.ControleEstoque;

public class MenuEstoque {
    static Scanner leitor = new Scanner(System.in);
    public static void exibirMenu(){

        int opt;

        do{
            System.out.print("""
                             + -------------------------- +
                             |     Controle de estoque    |
                             + -------------------------- +
                             """);
            System.out.println("| 1 - Ver estoque            |");
            System.out.println("| 2 - Aumentar estoque       |");
            System.out.println("| 3 - Reduzir estoque        |");
            System.out.println("| 0 - voltar                 |");
            System.out.println("+ -------------------------- +");
            System.out.print("| > ");
            opt = leitor.nextInt();
            leitor.nextLine();

            switch (opt) {
                case 1:
                    ControleEstoque.verEstoque();
                    break;
                case 2: 
                ControleEstoque.aumentaEstoque();
                break;
                case 3:
                ControleEstoque.reduzEstoque();
                break;
                case 0: break; // so pra não dar erro
                default:
                    break;
            }
            
        } while(opt != 0);
    }
}
