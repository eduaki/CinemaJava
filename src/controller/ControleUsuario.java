package controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.*;

public class ControleUsuario {

  /// inicializa o Gerenciamento de usuarios para evitar erros com as listas
  GerenciamentoUsuarios gerenciamentoUsuarios = new GerenciamentoUsuarios();
  

  public static void adicionarCliente(Cliente cliente){
    GerenciamentoUsuarios.adicionarCliente(cliente);
    
    try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/Clientes.dat"))){
      List<Cliente> listaClientes = GerenciamentoUsuarios.listaClientes;

      for(Cliente c : listaClientes){
        os.writeObject(c);
      }

    }catch(Exception e){
      e.printStackTrace();
    }

  }
  public static void removeCadastroCliente(Cliente cliente){
    /// função que remove cliente
    GerenciamentoUsuarios.removeCadastroCliente(cliente);
  }

    public static void adicionarFuncionario(Funcionario funcionario){
    GerenciamentoUsuarios.adicionarFuncionario(funcionario);

    try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/Funcionarios.dat"))){
      List<Funcionario> listaFuncionarios = GerenciamentoUsuarios.listaFuncionarios;

      for(Funcionario f : listaFuncionarios){
        os.writeObject(f);
      }

    }catch(Exception e){
      e.printStackTrace();
    }

  }
  public static void removeFuncionario(Funcionario funcionario){
    /// função que demite funcionario
    GerenciamentoUsuarios.removeFuncionario(funcionario);
  }

  public static boolean verificaAdmin(String mail, String senha){

    for(Funcionario f : GerenciamentoUsuarios.listaFuncionarios){
      if(f.getEmail().equals(mail)){
        if(f.isAdmin() == true && f.getSenha() != null && f.getSenha().equals(senha)){
          return true;
        }
      }
    }
    
    return false;
  }

}
