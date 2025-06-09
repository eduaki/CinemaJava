package view;
import controller.Catalogo;
import model.Filme;

import java.util.List;
import java.util.Scanner;

public class MenuControleFilme {
    static Scanner scanner = new Scanner(System.in);

    public static void exibirMenuFilme() {
        int opcao;

            do {
                System.out.println("\n----- Menu Controle de Filmes -----");
                System.out.println("1 - Cadastrar Filme");
                System.out.println("2 - Listar Filmes");
                System.out.println("3 - Remover Filme");
                System.out.println("4 - Voltar");
                System.out.print("Escolha uma opção: ");
                    opcao = scanner.nextInt();
                    scanner.nextLine();

                    switch (opcao) {
                        case 1:
                            cadastrarFilme();
                            break;
                        case 2:
                            listarFilmes();
                            break;
                        case 3:
//                            removerFilme();
                            break;
                        case 4:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcao != 4);
            }

            private static void cadastrarFilme() {
                System.out.print("Digite o nome do filme: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o gênero: ");
                String genero = scanner.nextLine();
                System.out.print("Digite a duração (em minutos): ");
                int duracao = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Classificação indicativa(idade): ");
                int classificacao = scanner.nextInt();
                scanner.nextLine();

                Filme filme = new Filme(nome, genero, duracao, classificacao);
                Catalogo.cadastrarFilme(filme);
                System.out.println("Filme cadastrado com sucesso!");
            }



            //metodo para listar filme
            private static void listarFilmes() {
                List<Filme> filmes = Catalogo.getFilmes();
                System.out.println("\n---- Filmes Cadastrados -----");
                System.out.println("Filme 1" );
                System.out.println(new Filme("Lilo e Stitch", "Animacao", 200, 10 ));
                System.out.println("Filme 2");
                System.out.println(new Filme("Premonicao 6", "Terror", 220, 18));
                System.out.println("Filme 3");
                System.out.println(new Filme("Manicreft", "Aventura", 200, 10));
                System.out.println("----------------------------------");

            }
        }


