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
                            removerFilme();
                            break;
                        case 4:
                            System.out.println("Voltando ao menu principal...");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                } while (opcao != 4);
            }

    public static void cadastrarFilme() {
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
    public static void listarFilmes() {
        List<Filme> filmes = Catalogo.getFilmes();
        System.out.println("\n---- Filmes Cadastrados -----");

                if (filmes.isEmpty()){
                    System.out.println("Nenhum filme cadastrado.");
                } else {
                    for (int i = 0 ; i < filmes.size(); i++){
                        Filme f = filmes.get(i);
                        System.out.println((i + 1) + " - " + f.getTitulo() + " | Gênero: " + f.getGenero() + " | Duração: " + f.getDuracao() + "min | Classificação: " + f.getClassificacao());
                    }
                }
                System.out.println("----------------------------------");

            }

            private static void removerFilme(){
                listarFilmes();
                
                if(Catalogo.getFilmes().isEmpty()){
                    System.out.println("Não ha filmes para remover");
                }
            
                System.out.println("Digite o ID do filme para remover: ");
                int tituloParaRemover = scanner.nextInt();

                System.out.println("Filme removido com sucesso ... retornando menu filme");

            
            }
        }
    

