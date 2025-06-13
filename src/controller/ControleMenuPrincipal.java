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
                MenuSessao.exibirMenuSessao();
                break;
            case 2:
                Cliente cliente = new Cliente("Teste", "teste@email.com", "12345678900", 20);
                ControleSessao controleSessao = ControleSessao.criarComSessoesPadrao();
                ControleIngressos controleIngressos = new ControleIngressos(controleSessao);

                MenuBilheteria menuBilheteria = new MenuBilheteria(cliente, controleIngressos, controleSessao);
                MenuBilheteria.exibirMenu();
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
