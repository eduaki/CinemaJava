package controller;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import model.*;

public class ControleUsuario {

  /// inicializa o Gerenciamento de usuarios para evitar erros com as listas
  GerenciamentoUsuarios gerenciamentoUsuarios = new GerenciamentoUsuarios();

  public static boolean adicionarCliente(Cliente cliente){

    for(Cliente c : GerenciamentoUsuarios.getListaClientes()){
      if(c.getCpf() == cliente.getCpf()) return false;
      if(c.getEmail() == cliente.getEmail()) return false;
    }

    GerenciamentoUsuarios.adicionarCliente(cliente);
    
    /// atualiza o arquivo
    try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/Clientes.txt"))){
      List<Cliente> listaClientes = GerenciamentoUsuarios.getListaClientes();
      os.writeObject(listaClientes);
    }catch(Exception e){
      e.printStackTrace();
    }

    return true;
  }
  public static boolean removeCadastroCliente(Cliente cliente){
    GerenciamentoUsuarios.removerCliente(cliente);

    if(cliente == null) return false;

    /// atualiza o arquivo
    try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/Clientes.txt"))){
      List<Cliente> listaClientes = GerenciamentoUsuarios.getListaClientes();
      os.writeObject(listaClientes);
    }catch(Exception e){
      e.printStackTrace();
    }

    return true;
  }

  public static boolean adicionarFuncionario(Funcionario funcionario){

    for(Funcionario f : GerenciamentoUsuarios.getListaFuncionarios()){
      if(f.getCpf() == funcionario.getCpf()) return false;
      if(f.getEmail() == funcionario.getEmail()) return false;
    }

    if(funcionario == null){
      return false;
    }

    GerenciamentoUsuarios.adicionarFuncionario(funcionario);

    /// atualiza o arquivo
    try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/Funcionarios.txt"))){
      List<Funcionario> listaFuncionarios = GerenciamentoUsuarios.getListaFuncionarios();
      os.writeObject(listaFuncionarios);
    }catch(Exception e){
      e.printStackTrace();
    }

    return true;

  }
  public static boolean removeFuncionario(Funcionario funcionario){
    GerenciamentoUsuarios.removerFuncionario(funcionario);

    /// atualiza o arquivo
    try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/Funcionarios.txt"))){
    List<Funcionario> listaFuncionarios = GerenciamentoUsuarios.getListaFuncionarios();
      os.writeObject(listaFuncionarios);
    }catch(Exception e){
      e.printStackTrace();
    }

    return true;

  }

  public static boolean verificaAdmin(String mail, String senha){

    for(Funcionario f : GerenciamentoUsuarios.getListaFuncionarios()){
      if(f.getEmail().equals(mail)){
        if(f.isAdmin() == true && f.getSenha() != null && f.getSenha().equals(senha)){
          return true;
        }
      }
    }
    
    return false;
  }

}
