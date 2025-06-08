package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoUsuarios {

    public static List<Funcionario> listaFuncionarios = new ArrayList<>();
    public static List<Cliente> listaClientes = new ArrayList<>();

    static {
      listaFuncionarios.add(  /// usuário admin padrão
        new Funcionario("Eduardo", "teste@teste.com", "148.210.734-12", 21, 0000000, 0, true, "senhaAdmin")
      );

      try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("src/Clientes.dat"))) { /// salva os dados do arquivo existente dentro da lista local
      List<Cliente> listatemp = new ArrayList<>();
      while (true) {
        try{
          Cliente c = (Cliente) os.readObject();
          listatemp.add(c);
        }catch(EOFException | ClassNotFoundException e){
          break;
        }
      }

      for(Cliente C : listatemp){
        listaClientes.add(C);
      }


    } catch (IOException e) {
      e.printStackTrace();
    }

      try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("src/Funcionarios.dat"))) { /// salva os dados do arquivo existente dentro da lista local
        List<Funcionario> listatemp = new ArrayList<>();
        while (true) {
          try{
            Funcionario f = (Funcionario) os.readObject();
            listatemp.add(f);
          }catch(EOFException e){
            break;
          } catch (ClassNotFoundException e) {
            e.printStackTrace();
          }
        }

        for(Funcionario F : listatemp){
          listaFuncionarios.add(F);
        }

      } catch (FileNotFoundException e) {
        System.out.println("[NENHUM FUNCIONÁRIO PRE-CADASTRADO]");
      } catch(IOException e){
        e.printStackTrace();
      }

    }

    /// funções de gerenciamento dos clientes
    public static List<Cliente> getLiscaClientes() {
      return listaClientes;
    }
    public static List<Cliente> adicionarCliente(Cliente cliente){
      listaClientes.add(cliente);
      return listaClientes;
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

    public static boolean verificaAdmin(int id){
      return listaFuncionarios.get(id).admin;
    }
  
}
