package view;

import java.util.Random;
import java.util.Scanner;

import controller.*;
import model.Cliente;
import model.Funcionario;
import model.GerenciamentoUsuarios;

public class MenuCadastro {

    static Scanner leitor = new Scanner(System.in);

    public static void menuGeral(){

        int opt;

        do{
            System.out.println("+ -------------------------- +");
            System.out.println("|                            |");
            System.out.println("| ---- Cadastrar usuário ----|");
            System.out.println("| 1 - Cliente                |");
            System.out.println("| 2 - Funcionário            |");
            System.out.println("| 3 - Remover cliente        |");
            System.out.println("| 4 - Remover funcionário    |");
            System.out.println("| 0 - Voltar                 |");
            System.out.println("+ -------------------------- +");
            System.out.print("Opção escolhida: ");

            opt = leitor.nextInt();
            leitor.nextLine();

            ControleMenuCadastro.menuGeral(opt);

        } while(opt != 0);
    }


    public static Cliente menuAdicionaCliente(){

        System.out.println("+ -------------------------- +");
        System.out.println("|                            |");
        System.out.println("| ---- Cadastrar cliente ----|");
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

        Random random = new Random();

        System.out.println("+ -------------------------- +");
        System.out.println("|                            |");
        System.out.println("| ---- Cadastrar cliente ----|");
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
        System.out.println("+ -------------------------- +");

        int matricula = random.nextInt(1000);


        return new Funcionario(nome, email, cpf, idade, matricula, salario);
    }

    public static Cliente menuRemoveCliente(){

      System.out.println("+ -------------------------- +");
      System.out.println("|                            |");
      System.out.println("| CPF: ");
      String cpf = leitor.nextLine();
      
      for(Cliente cliente : GerenciamentoUsuarios.getLiscaClientes()){
        if(cliente.getCpf() == cpf) return cliente; 
      }

      return null;

    }

    public static Funcionario menuRemoveFuncionario(){

      System.out.println("+ -------------------------- +");
      System.out.println("|                            |");
      System.out.println("| CPF: ");
      String cpf = leitor.nextLine();
      
      for(Funcionario funcionario : GerenciamentoUsuarios.getListaFuncionarios()){
        if(funcionario.getCpf() == cpf) return funcionario; 
      }

      return null;

    }

}
