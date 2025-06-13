package controller;

import java.util.List;
import java.util.Scanner;

import model.GerenciamentoPedidos;
import model.Produto;

public class ControleEstoque {
    static Scanner leitor = new Scanner(System.in);
    GerenciamentoPedidos gerenciamentoPedidos = new GerenciamentoPedidos();
    static List<Produto> catalogo = GerenciamentoPedidos.pegaCardapio();
    public static void verEstoque(){
        System.out.println("+ -------------------------- +");
        for(int i = 0; i < catalogo.size(); i++){
            System.out.printf("| %d - %s (%d unidades)\n", (i + 1), catalogo.get(i).getNome(), catalogo.get(i).getQtdEstoque());
        }
    }
    public static void aumentaEstoque(){
        verEstoque();
        System.out.println("+ -------------------------- +");
        System.out.println("| Selecione um produto:      |");
        System.out.println("+ -------------------------- +");
        System.out.print("| > ");
        int idProduto = leitor.nextInt();
        leitor.nextLine();
        
        for(int i = 0; i< catalogo.size(); i++){
            Produto produto = catalogo.get(i);
            int qtdEstoque = produto.getQtdEstoque();;

            if(i == (idProduto - 1)){
                System.out.println("+ -------------------------- +");
                System.out.println("| Quantidade para adicionar: |");
                System.out.println("+ -------------------------- +");
                System.out.print("| > ");
                int novaQtdEstoque = leitor.nextInt();
                leitor.nextLine();

                produto.setQtdEstoque(qtdEstoque + novaQtdEstoque);
                
            }

        }
    }
    public static void reduzEstoque(){
        verEstoque();
        System.out.println("+ -------------------------- +");
        System.out.println("| Selecione um produto:      |");
        System.out.println("+ -------------------------- +");
        System.out.print("| > ");
        int idProduto = leitor.nextInt();
        leitor.nextLine();
        
        for(int i = 0; i< catalogo.size(); i++){
            Produto produto = catalogo.get(i);
            int qtdEstoque = produto.getQtdEstoque();;
    
            if(i == (idProduto - 1)){
                System.out.println("+ -------------------------- +");
                System.out.println("| Quantidade para reduzir:   |");
                System.out.println("+ -------------------------- +");
                System.out.print("| > ");
                int novaQtdEstoque = leitor.nextInt();
                leitor.nextLine();
    
                produto.setQtdEstoque(qtdEstoque - novaQtdEstoque);

                if(produto.getQtdEstoque() < 0){
                    produto.setQtdEstoque(0);
                }
                
            }
    
        }

    }
}
