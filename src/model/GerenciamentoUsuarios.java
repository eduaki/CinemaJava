package model;

import java.util.ArrayList;
import java.util.List;

public class GerenciamentoUsuarios {

    public static List<Funcionario> listaFuncionarios = new ArrayList<>();
    public static List<Cliente> listaClientes = new ArrayList<>();

    /// funções de gerenciamento dos clientes
    public static List<Cliente> getLiscaClientes() {
      return listaClientes;
    }
    public static void adicionarCliente(Cliente cliente){
      listaClientes.add(cliente);
    }
    public static void removeCadastroCliente(Cliente cliente){
      listaClientes.remove(cliente);
    }


    //// funções de gerenciamento dos funcionarios
    public static List<Funcionario> getListaFuncionarios() {
      return listaFuncionarios;
    }
    public static void adicionarFuncionario(Funcionario funcionario){
      listaFuncionarios.add(funcionario);
    }
    public static void removeFuncionario(Funcionario funcionario){
      listaFuncionarios.remove(funcionario);
    }
  
}
