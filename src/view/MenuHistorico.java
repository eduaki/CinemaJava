package view;

import java.util.List;
import java.util.Scanner;

import controller.ControleMenuHistorico;
import model.GerenciamentoPedidos;
import model.Pedido;
import model.Produto;

public class MenuHistorico {
    static Scanner scanner = new Scanner (System.in);
    public static void menuHistorico(){
        
        int optHistorico;
        do{
            System.out.println("+ -------------------------- +");
            System.out.println("|      Gerenciar Pedidos     |");
            System.out.println("|----------------------------|");
            System.out.println("|                            |");
            System.out.println("| 1 - Histórico de pedidos   |");
            System.out.println("| 2 - Cancelar pedido        |");
            System.out.println("| 3 - Remover pedido         |");
            System.out.println("| 0 - Voltar                 |");
            System.out.println("|                            |");
            System.out.println("+ -------------------------- +");
            System.out.print("| > ");
            optHistorico = scanner.nextInt();
            scanner.nextLine();

            ControleMenuHistorico.opcoes(optHistorico);

        }while (optHistorico != 0);

    }


    public static void exibirHistorico(List<Pedido> historico, List<Produto> cardapio){
        System.out.println("+ -------------------------- +");
        System.out.println("|     Pedidos Realizados     |");
        System.out.println("+ -------------------------- +");
        
        if(historico.isEmpty()){
            System.out.println("| Nenhum pedido registrado!  |");
            System.out.println("+ -------------------------- +");
        }
        else{
            for(int i = 0; i < historico.size(); i++){
                System.out.println("| Número do pedido: " + historico.get(i).getNumeroPedido());
                System.out.println("| Produtos: ");
                for(int IDproduto : historico.get(i).getProdutos()){
                    System.out.println("| . " + cardapio.get(IDproduto - 1).getNome());
                }
                    
                System.out.println("|Valor total: " + historico.get(i).getValor());
                System.out.println("+ -------------------------- +");

            }
        }
    }

    public static void exibeListaPedidos(){
        System.out.println("+ -------------------------- +");
        System.out.println("|     Pedidos Registrados    |");
        System.out.println("+ -------------------------- +");

        if(GerenciamentoPedidos.verHistorico().isEmpty()){
            System.out.println("|  Nenhum pedido registrado! |");
            System.out.println("+ -------------------------- +");
        }
        else{
            for(Pedido p : GerenciamentoPedidos.verHistorico()){
                System.out.printf("| %d - %s\n", p.getNumeroPedido(), (p.getCancelado() ? "Cancelado" : "Aprovado"));
            }
        }

    }

    public static int menuCancelaPedido(){

        exibeListaPedidos();
        if(MenuCadastro.menuVoltarContinuar()){
            if(MenuCadastro.verificaAdmMenu()){
                System.out.println("cancelamento pedido");
                System.out.println("Nº do pedido: ");
                System.out.print(" > ");
                int nPedido = scanner.nextInt();
                scanner.nextLine();
                
                return nPedido;
            }
        }else{
            menuHistorico();
            return 0;
        }
        return 0;
        
    }


    public static int menuRemoverPedido(){

        exibeListaPedidos();

        if(MenuCadastro.menuVoltarContinuar()){
            if(MenuCadastro.verificaAdmMenu()){
                System.out.println("Remover pedido");
                System.out.println("Nº do pedido: ");
                System.out.print(" > ");
                int nPedido = scanner.nextInt();
                scanner.nextLine();
        
                return nPedido;
            }
        }else{
            menuHistorico();
            return 0;
        }

        return 0;
    }

}
