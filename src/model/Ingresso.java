package model;

public class Ingresso {
    private Cliente cliente;
    private Sessao sessao;
    private boolean meiaEntrada;
    private String assento;
    private double preco;

    public Ingresso(Cliente cliente, Sessao sessao, boolean meiaEntrada, String assento) {
        this.cliente = cliente;
        this.sessao = sessao;
        this.meiaEntrada = meiaEntrada;
        this.assento = assento; 
        this.preco = meiaEntrada ? sessao.getPrecoMeia() : sessao.getPrecoInteira();
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

    public String getAssento() {
        return assento;
    }

    public double getPreco() {
        return preco;
    }
}
