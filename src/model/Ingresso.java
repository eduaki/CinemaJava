package model;

public class Ingresso {
    private Cliente cliente;
    private Sessao sessao;
    private boolean meiaEntrada;
    private double preco; // Adicionando preço do ingresso

    public Ingresso(Cliente cliente, Sessao sessao, boolean meiaEntrada) {
        this.cliente = cliente;
        this.sessao = sessao;
        this.meiaEntrada = meiaEntrada;
        this.preco = meiaEntrada ? sessao.getPrecoMeia() : sessao.getPrecoInteira(); // Define o preço conforme o tipo
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public boolean isMeiaEntrada() {
        return meiaEntrada;
    }

    public double getPreco() {
        return preco;
    }
}
