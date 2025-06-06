package model;

import controller.*;

public class Funcionario extends Pessoa{

    protected int matricula;
    protected double salario;    
    protected boolean admin;


    public Funcionario(String nome, String email, String cpf, int idade, int matricula, double salario) {
        super(nome, email, cpf, idade);
        this.matricula = matricula;
        this.salario = salario;
        this.admin = false; /// vai ser usada para verificar se o usuário é um administrador
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public double getSalario() {
        return salario;
    }
    public void setSalario(double salario) {
        this.salario = salario;
    }


    /// Funções relacionadas ao gerenciamento de filmes/catalogo
    public void adicionaFilme(Filme filme){
        //// faz parte da bilheteria
    }
    public void cadastraFilme(Filme filme){
        Catalogo.cadastrarFilme(filme);
    }
    public void removeFilme(Filme filme){
        Catalogo.removerFilme(filme);
    }  

}
