package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sessao {

    private static final double PRECO_INTEIRA = 30.0;
    private static final double PRECO_MEIA = 15.0;

    private Filme filme;
    private Sala sala;
    private LocalTime hora;
    private int ingressoDisponivel;
    private List<Ingresso> ingressosVendidos;

    public Sessao(Filme filme, Sala sala, LocalTime hora) {
        this.filme = filme;
        this.sala = sala;
        this.hora = hora;
        this.ingressoDisponivel = sala.getCapacidade();
        this.ingressosVendidos = new ArrayList<>();
    }

    public double getPrecoInteira() {
        return PRECO_INTEIRA;
    }

    public double getPrecoMeia() {
        return PRECO_MEIA;
    }

    public Filme getFilme() {
        return filme;
    }

    public Sala getSala() {
        return sala;
    }

    public LocalTime getHora() {
        return hora;
    }

    public List<Ingresso> getIngressosVendidos() {
        return ingressosVendidos;
    }

    public int getIngressoDisponivel() {
        return ingressoDisponivel;
    }

    public void diminuirIngressosDisponiveis() {
        ingressoDisponivel--;
    }

    public void aumentarIngressosDisponiveis() {
        ingressoDisponivel++;
    }

    public void adicionarIngresso(Ingresso ingresso) {
        ingressosVendidos.add(ingresso);
    }

    public boolean clientePossuiIngresso(Cliente cliente) {
        return ingressosVendidos.stream().anyMatch(i -> i.getCliente().equals(cliente));
    }

    public void devolverIngresso(Cliente cliente) {
        Ingresso ingressoParaRemover = ingressosVendidos.stream()
            .filter(i -> i.getCliente().equals(cliente))
            .findFirst()
            .orElse(null);

        if (ingressoParaRemover != null) {
            ingressosVendidos.remove(ingressoParaRemover);
            aumentarIngressosDisponiveis();
        } else {
            System.out.println("\u001B[31mErro: Cliente não encontrado na lista de ingressos!\u001B[0m");
        }
    }
}
