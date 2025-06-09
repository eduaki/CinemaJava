package controller;

import view.*;

public class ControleMenuCadastro {
    
    public static boolean verificaAdmin(int opt){
        switch (opt) {
            case 1: return true;
            case 2 : return false;
            default: return false; 
        }
    }

    public static boolean voltarContinuar(int opt){
        switch(opt){
            case 1: return true;
            case 2: return false;
            default: return false;
        }
    }

    public static void menuGeral(int opt){

        switch (opt) {
            case 1:
                if(!ControleUsuario.adicionarCliente(MenuCadastro.menuAdicionaCliente())) 
                    MenuCadastro.usuarioJaCadastrado();
                else MenuCadastro.usuarioCadastrado();
            break;

            case 2: 
                if(!ControleUsuario.adicionarFuncionario(MenuCadastro.menuAdicionaFuncionario())) 
                    MenuCadastro.usuarioJaCadastrado();
                else MenuCadastro.usuarioCadastrado();
            break;    

            case 3: ControleUsuario.removeCadastroCliente(MenuCadastro.menuRemoveCliente());break;
            case 4:  
                if(ControleUsuario.removeFuncionario(MenuCadastro.menuRemoveFuncionario()))
                    MenuCadastro.removidoSucesso();
                break;
            }

    }

}
