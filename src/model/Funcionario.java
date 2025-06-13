package model;

import controller.*;

public class Funcionario extends Pessoa{

    protected int matricula;
    protected double salario;    
    protected boolean admin;
    protected String senha;


    public Funcionario(String nome, String email, String cpf, int idade, int matricula, double salario, boolean admin, String senha) {
        super(nome, email, cpf, idade);
        this.matricula = matricula;
        this.salario = salario;
        this.admin = admin;
        this.senha = senha;
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

    public boolean isAdmin(){
        return admin;
    }
    public void setAdmin(boolean admin){
        this.admin = admin;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void adicionaFilme(Filme filme){
        
    }
    public void cadastraFilme(Filme filme){
        Catalogo.cadastrarFilme(filme);
    }

    public void removeFilme(Filme filme){
        Catalogo.removerFilmePorID(filme);
    }  

    @Override
    public String toString() {
        String objeto = String.format("""
                    Funcionario{
                    nome = %s, 
                    email = %s, 
                    cpf = %s, 
                    idade = %d,
                    matricula = %d,
                    salario = %f,
                    admin = %b,
                    senha = %s
                    }
                """, nome, email, cpf, idade, matricula, salario, admin, senha);
        return objeto;
    }

}
