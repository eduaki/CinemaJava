package model;

public class Cliente extends Pessoa{

    public Cliente(String nome, String email, String cpf, int idade) {
        super(nome, email, cpf, idade);
    }


    @Override
    public String toString() {
        String objeto = String.format("Cliente{nome = %s, email = %s, cpf = %s, idade = %d}", nome, email, cpf, idade);
        return objeto;
    }

}
