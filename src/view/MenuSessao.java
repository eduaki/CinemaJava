package view;
import java.util.Scanner;

public class MenuSessao {
    private static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuSessao() {
        int opcao;

        do {
            System.out.println("\nMenu Sessao Cine Compila");
            System.out.println("1 - Filmes em cartaz");
            System.out.println("2 - Comprar ingresso");
            System.out.println("3 - Escolher sala de cinema");
            System.out.println("4 - Escolher horario");
            System.out.println("5 - Voltar ao menu principal");
            System.out.print("Digite sua opcao desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    MenuControleFilme.listarFilmes();;
                    break;
                case 2:
                    MenuBilheteria.comprarIngresso();
                    break;
                case 3:
                    System.out.println("Acessando sala");
                    break;
                case 4:
                    System.out.println("Acessando horarios");
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

