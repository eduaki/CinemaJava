package model;

public class Funcionario extends Pessoa{

    protected  int matricula;
    protected  double salario;    

    public Funcionario(String nome, String email, String cpf, int idade, int matricula, double salario) {
        super(nome, email, cpf, idade);
        this.matricula = matricula;
        this.salario = salario;
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

    
    public void adicionaFilme(){

    }
    public void cadastraFilme(){

    }
    public void removeFilme(){

    }

}
