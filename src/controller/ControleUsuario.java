package controller;

import model.*;

public class ControleUsuario {

  /// inicializa o Gerenciamento de usuarios para evitar erros com as listas
  GerenciamentoUsuarios gerenciamentoUsuarios = new GerenciamentoUsuarios();
  

  public static void adicionarCliente(Cliente cliente){
    /// função que adiciona Cliente
    GerenciamentoUsuarios.adicionarCliente(cliente);
  }
  public static void removeCadastroCliente(Cliente cliente){
    /// função que remove cliente
    GerenciamentoUsuarios.removeCadastroCliente(cliente);
  }

    public static void adicionarFuncionario(Funcionario funcionario){
    /// função que adciona funcionarios
    GerenciamentoUsuarios.adicionarFuncionario(funcionario);
  }
  public static void removeFuncionario(Funcionario funcionario){
    /// função que demite funcionario
    GerenciamentoUsuarios.removeFuncionario(funcionario);
  }

}
