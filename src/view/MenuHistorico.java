package view;

import java.util.List;
import java.util.Scanner;

import controller.ControleLanchonete;
import model.Pedido;
import model.Produto;

public class MenuHistorico {
        public static void menuHistorico(){
            Scanner scanner = new Scanner (System.in);
            
            int optHistorico;
            do{
                System.out.println("+ -------------------------- +");
                System.out.println("|                            |");
                System.out.println("|-----Histórico Pedidos------|");
                System.out.println("|                            |");
                System.out.println("| 1 - Histórico de pedidos   |");
                System.out.println("| 2 - Cancelar pedido        |");
                System.out.println("| 3 - Remover pedido         |");
                System.out.println("| 0 - Voltar                 |");
                System.out.println("|                            |");
                System.out.println("+ -------------------------- +");
                System.out.println("Opção escolhida: ");
                optHistorico = scanner.nextInt();
                scanner.nextLine();

                switch (optHistorico) {
                    case 1:
                        ControleLanchonete.verHistorico();
                        break;
                    case 2:
                        System.out.println("cancelando pedido");
                        break;
                    case 3:
                        System.out.println("removendo pedido");
                        break;
                    case 0:
                        MenuLanche.exibirMenuLanche();
                        break;
                    default:
                        System.out.println("Opcao invalida, escolha de 1 a 3...");
                        break;
                        
                }

            }while (optHistorico != 0);

            scanner.close();
        }


        public static void exibirHistorico(List<Pedido> historico, List<Produto> cardapio){
            System.out.println("Pedidos Realizados");
            for(int i = 0; i < historico.size(); i++){
                System.out.println("Número do pedido: " + historico.get(i).getNumeroPedido());
                System.out.println("Produtos: ");
                for(int IDproduto : historico.get(i).getProdutos()){
                    System.out.println(". " + cardapio.get(IDproduto - 1).getNome());
                }
                    
                System.out.println("Valor total: " + historico.get(i).getValor());
            }
        }


}
