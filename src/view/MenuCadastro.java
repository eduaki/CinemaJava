package view;

import java.util.Random;
import java.util.Scanner;

import controller.*;
import model.*;

public class MenuCadastro {

    static Scanner leitor = new Scanner(System.in);

    public static void menuGeral(){ /// menu principal da pagina

        int opt;

        do{
            System.out.println("+ -------------------------- +");
            System.out.println("|        Gerenciamento       |");
            System.out.println("| ---------------------------|");
            System.out.println("| 1 - Adicionar cliente      |");
            System.out.println("| 2 - Adicionar funcionário  |");
            System.out.println("| 3 - Remover cliente        |");
            System.out.println("| 4 - Remover funcionário    |");
            System.out.println("| 0 - Voltar                 |");
            System.out.println("+ -------------------------- +");
            System.out.print(" > ");

            opt = leitor.nextInt();
            leitor.nextLine();

            ControleMenuCadastro.menuGeral(opt);

        } while(opt != 0);
    }

    public static Cliente menuAdicionaCliente(){

      System.out.println("+ -------------------------- +");
      System.out.println("|      Cadastrar cliente     |");
      System.out.println("+ -------------------------- +");
        System.err.print("| Nome: ");
      String nome = leitor.nextLine();
        System.out.print("| Cpf: ");
      String cpf = leitor.nextLine();
        System.out.print("| Email: ");
      String email = leitor.nextLine();
        System.out.print("| Idade: ");
        int idade = leitor.nextInt();
        leitor.nextLine();
        System.out.println("+ -------------------------- +");

      return new Cliente(nome, email, cpf, idade);

    }

    public static Funcionario menuAdicionaFuncionario(){

      if(verificaAdmMenu()){

        Random random = new Random();
        String senhaAdmin = null;

        System.out.println("+ -------------------------- +");
        System.out.println("|    Cadastrar funcionário   |");
        System.out.println("+ -------------------------- +");
          System.err.print("| Nome: ");
        String nome = leitor.nextLine();
          System.out.print("| Cpf: ");
        String cpf = leitor.nextLine();
          System.out.print("| Email: ");
        String email = leitor.nextLine();
          System.out.print("| Idade: ");
        int idade = leitor.nextInt();
        leitor.nextLine();
          System.out.print("| Salário: ");
        float salario = leitor.nextFloat();
        leitor.nextLine();
        System.out.println("| Adminstrador? [1] sim [2] não");
        System.out.print("| > ");
        int adminOpt = leitor.nextInt();
        leitor.nextLine();
        boolean admin = ControleMenuCadastro.verificaAdmin(adminOpt);
        if(admin){
          System.out.print("| senha de acesso:");
          senhaAdmin = leitor.nextLine();
        }
        System.out.println("+ -------------------------- +");

        int matricula = random.nextInt(1000);

        return new Funcionario(nome, email, cpf, idade, matricula, salario, admin, senhaAdmin);
      }else{
        System.out.println("+ -------------------------- +");
        System.out.println("|   Voce precisa ser admin   |");
        System.out.println("+ -------------------------- +");
        menuGeral();
        return null;
      }

    }

    public static Cliente menuRemoveCliente(){

      if(verificaAdmMenu()){
        System.out.println("+ -------------------------- +");
        System.out.println("| CPF: ");
        String cpf = leitor.nextLine();
        
        for(Cliente cliente : GerenciamentoUsuarios.getListaClientes()){
          if(cliente.getCpf() == cpf) return cliente; 
        }

        
        return null;
      }else{
        System.out.println("+ -------------------------- +");
        System.out.println("|   Voce precisa ser admin   |");
        System.out.println("+ -------------------------- +");
        return null;
      }

    }

    public static Funcionario menuRemoveFuncionario(){
      exibeListaFuncionarios();

      if(menuVoltarContinuar()){
        if(verificaAdmMenu()){

          System.out.println("+ -------------------------- +");
          System.out.println("| Matricula do Funcionário:  |");
          System.out.print("| > ");
          int matricula = leitor.nextInt();
          leitor.nextLine();
          
          for(Funcionario funcionario : GerenciamentoUsuarios.getListaFuncionarios()){
            if(funcionario.getMatricula() == matricula) return funcionario; 
          }
        
          return null;  
        }else{
          System.out.println(" ---------------------------- ");
          System.out.println("|   Você precisa ser admin   |");
          System.out.println(" ---------------------------- ");
          menuGeral();
          return null;
        }
      }else{
        menuGeral();
        return null;
      }

    }

    public static boolean verificaAdmMenu(){ /// menu com login pra verificar se é admin
        System.out.println("+ -------------------------- +");
        System.out.println("|            Login           |");
        System.out.println("+ -------------------------- +");
        System.out.println("| E-mail: ");
        System.out.print("| > ");
        String cpf = leitor.nextLine();
        System.out.println("| Senha de acesso: ");
        System.out.print("| > ");
        String senha = leitor.nextLine();
        System.out.println("+ -------------------------- +");

        return ControleUsuario.verificaAdmin(cpf, senha);
    }

    public static boolean menuVoltarContinuar(){
      System.out.println("+ -------------------------- +");
      System.out.println("|      Deseja continuar?     |");
      System.out.println("|        [1]sim [2]não       |");
      System.out.println("+ -------------------------- +");
      System.out.print("| > ");
      int opt = leitor.nextInt();
      leitor.nextLine();
      return ControleMenuCadastro.voltarContinuar(opt);
  }

    public static void usuarioJaCadastrado(){ /// mensagem para quando o usuário ja está cadastrado
      System.out.println("+ -------------------------- +");
      System.out.println("|    Usuário já cadastrado   |");
      System.out.println("+ -------------------------- +");
    }
    public static void usuarioCadastrado(){ /// mensagem para quando é cadastrado com sucesso
      System.out.println("+ -------------------------- +");
      System.out.println("|   Cadastrado com sucesso!  |");
      System.out.println("+ -------------------------- +");
    }

    public static void removidoSucesso(){
      System.out.println(" ---------------------------- ");
      System.out.println("|    Removido com sucesso!    |");
      System.out.println(" ---------------------------- ");
    }

    public static void exibeListaFuncionarios(){
      System.out.println("+ -------------------------- +");
      System.out.println("|   Lista de Funcionarios:   |");
      System.out.println("+ -------------------------- +");

      if(!GerenciamentoUsuarios.getListaFuncionarios().isEmpty()){
        for(Funcionario f : GerenciamentoUsuarios.getListaFuncionarios()){
          System.out.println("+ -------------------------- +");
          System.out.printf("| %s(%d) - %s\n", f.getNome(), f.getMatricula(), (f.isAdmin()?"Admin" : "Operador"));
          System.out.println("+ -------------------------- +");  
        }
      }else{
        System.out.println("+ -------------------------- +");
        System.out.println("|     Nenhum funcionario!    |");
        System.out.println("+ -------------------------- +");  
      }


    }

}
