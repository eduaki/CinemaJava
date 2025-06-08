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

    public static void menuGeral(int opt){


        switch (opt) {
            case 1 -> ControleUsuario.adicionarCliente(MenuCadastro.menuAdicionaCliente());
            case 2 -> ControleUsuario.adicionarFuncionario(MenuCadastro.menuAdicionaFuncionario());    
            case 3 -> ControleUsuario.removeCadastroCliente(MenuCadastro.menuRemoveCliente());
            case 4 -> ControleUsuario.removeFuncionario(MenuCadastro.menuRemoveFuncionario());
        }

    }

}
