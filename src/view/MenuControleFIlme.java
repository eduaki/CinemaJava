package view;
import controller.Catalogo;
import model.Filme;
import java.util.Scanner;

public class MenuControleFilme {
        private Catalogo catalogo;
        private Scanner scanner;

        public MenuControleFilme(Catalogo catalogo, Scanner scanner) {
            this.catalogo = catalogo;
            this.scanner = scanner;
        }

        public void exibirMenu() {
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

            private void cadastrarFilme() {
                System.out.print("Digite o nome do filme: ");
                String nome = scanner.nextLine();
                System.out.print("Digite o gênero: ");
                String genero = scanner.nextLine();
                System.out.print("Digite a duração (em minutos): ");
                int duracao = scanner.nextInt();
                scanner.nextLine();

                Filme filme = new Filme(nome, genero, duracao);
                catalogo.cadastrarFilme(filme);
                System.out.println("Filme cadastrado com sucesso!");
            }

            private void listarFilmes() {
                System.out.println("\n---- Filmes Cadastrados -----");
                if (catalogo.getFilmes().isEmpty()) {
                    System.out.println("Nenhum filme cadastrado.");
                } else {
                    catalogo.getFilmes().forEach(System.out::println);
                }
            }
        }


