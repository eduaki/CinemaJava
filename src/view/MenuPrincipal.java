package view;

import controller.*;
import model.Cliente;

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
                    MenuSessao.exibirMenuSessao();
                    break;
                case 2:
                    // Simulando login de cliente (substituir depois com tela de login)
                    Cliente cliente = new Cliente("Alex", "alex@email.com", "12345678900", 25);

                    // Criar controladores
                    ControleIngressos controleIngressos = new ControleIngressos();
                    ControleSessao controleSessao = new ControleSessao();

                    // Criar MenuBilheteria e exibir
                    MenuBilheteria menuBilheteria = new MenuBilheteria(cliente, controleIngressos, controleSessao);
                    menuBilheteria.exibirMenu();
                    break;
                case 3:
                    MenuLanche.exibirMenuLanche();
                    break;
                case 4:
                    MenuCadastro.menuGeral();
                    break;
                case 0:
                    System.out.println("Saindo... Obrigado e volte sempre!");
                    break;
                default:
                    System.out.println("Opção inválida, escolha de 0 a 4...");
                    break;
            }
        } while (opcao != 0);

        scanner.close();
    }
}

