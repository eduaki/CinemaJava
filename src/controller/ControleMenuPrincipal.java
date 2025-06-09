package controller;

import model.Cliente;
import view.MenuBilheteria;
import view.MenuCadastro;
import view.MenuLanche;
import view.MenuSessao;

public class ControleMenuPrincipal {
  
  public static void opcoes(int opt){

    switch (opt) {
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

  }

}
