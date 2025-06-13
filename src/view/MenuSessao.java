package view;
import java.util.Scanner;

public class MenuSessao {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuSessao() {
        int opcao;

        do {
            System.out.print(   """
                                  + -------------------------- +
                                  |          Catálogo:         |
                                  | ---------------------------|
                                  """);
            System.out.println("| 1 - Filmes em cartaz       |");
            System.out.println("| 2 - Comprar ingresso       |");
            System.out.println("| 0 - Voltar                 |");
            System.out.println("+ -------------------------- +");
            System.out.print("| > ");
            opcao = scanner.nextInt();
            System.out.println("+ -------------------------- +");

            switch (opcao) {
                case 1:
                    MenuControleFilme.listarFilmes();;
                    break;
                case 2:
                    MenuBilheteria.exibirMenu();
                    
                    break;
                case 0:
                    MenuPrincipal.exibirMenuPrincipal();
                    break;
                default:
                    System.out.println("Opcao invalida, escolha de 0 a 4...");
                    break;
            }
        } while (opcao != 0);
    }
}

