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
                    System.out.println("Acessando filmes em cartaz...");
                    //metodo para listar filmes
                    MenuControleFilme.exibirMenuFilme();
                    break;
                case 2:
                    System.out.println("Acessando compra de ingresso...");
                    break;
                case 3:
                    System.out.println("Acessando sala");
                    break;
                case 4:
                    System.out.println("Acessando horarios");
                    break;
                case 5:
                    System.out.println("Voltar menu principal");
                    break;
                default:
                    System.out.println("Opcao invalida, escolha de 1 a 5...");
            }
        } while (opcao !=5);
    }
}

