package controller;

import view.MenuHistorico;
import view.MenuLanche;

public class ControleMenuHistorico {
    public static void opcoes(int opt){

        switch (opt) {
            case 1:
                ControleLanchonete.verHistorico();
                break;
            case 2:
                if(ControleLanchonete.cancelarPedido(MenuHistorico.menuCancelaPedido())) 
                System.out.println("pedido cancelado!");
                else System.out.println("pedido não encontrado!");
                break;
            case 3:
                if(!ControleLanchonete.removerPedido(MenuHistorico.menuRemoverPedido())){
                    System.out.println("Erro ao apagar pedido!");
                }
                else System.out.println("Pedido removido com sucesso!");
                break;
            case 0:
                MenuLanche.exibirMenuLanche();
                break;
            default:
                System.out.println("Opcao invalida, escolha de 1 a 3...");
                break;
                
        }

    }
}
