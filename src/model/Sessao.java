package model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;


public class Sessao{

    private static final double PRECO_INTEIRA = 30.0;
    private static final double PRECO_MEIA = 15.0;


    private Filme filme;
    private Sala sala;
    private LocalTime hora;
    private int ingressoDisponivel;
    private List<Ingresso> ingressosVendidos = new ArrayList<>();
    private List<Cliente> listaDeClientesComIngresso = new ArrayList<>();
    
   public Sessao(Filme filme, Sala sala, LocalTime hora) {
       this.filme = filme;
        this.sala = sala;
        this.hora = hora;
        this.ingressoDisponivel = sala.getCapacidade();
        this.listaDeClientesComIngresso = new ArrayList<>();

   }

    public double getPrecoInteira(){
    return PRECO_INTEIRA;
   }

   public double getPrecoMeia(){
    return PRECO_MEIA;
   }

    public Filme getFilme() {
       return this.filme;
   }
    public void setFilme(Filme filme) {
       this.filme = filme;
   }

    public Sala getSala() {
       return this.sala;
   }
    public void setSala(Sala sala) {
       this.sala = sala;
   }

    public LocalTime getHora() {
       return this.hora;
   }
    public void setHora(LocalTime hora) {
       this.hora = hora;
   }
   public List<Cliente> getListaDeClientesComIngresso() {
    return listaDeClientesComIngresso;
}

   public void adicionarIngresso(Ingresso ingresso){
    ingressosVendidos.add(ingresso);

   }

   public void diminuirIngressosDisponiveis(int quantidade){
    ingressoDisponivel -= quantidade;

   }

    public int getIngressoDisponivel() {
       return this.ingressoDisponivel;
   }
    public void setIngressoDisponivel(int ingressoDisponivel) {
       this.ingressoDisponivel = ingressoDisponivel;
   }

   public boolean venderIngresso(Cliente cliente, int quantidade, boolean meiaEntrada){
    if (ingressoDisponivel >= quantidade){
        ingressoDisponivel -= quantidade;

        for(int i = 0; i < quantidade; i++){
            Ingresso ingresso = new Ingresso(cliente, this, meiaEntrada);
            ingressosVendidos.add(ingresso);
            listaDeClientesComIngresso.add(cliente);
        }
      System.out.println("\nIngresso(s) vendido(s) como " + (meiaEntrada ? "meia entrada!" : "inteira!"));
        return true;
    } else {
        System.out.println("\nNão há ingressos suficientes disponíveis.");
        return false;
    }
   }

   public void devolverIngresso(Cliente cliente){
    if(listaDeClientesComIngresso.contains(cliente)){
        ingressoDisponivel++;
        listaDeClientesComIngresso.remove(cliente);
    } else {
         System.out.println("\u001B[31mErro: Cliente não encontrado na lista de ingressos!\u001B[0m");
    }

   }

   public boolean clientePossuiIngresso(Cliente cliente){
    return listaDeClientesComIngresso.contains(cliente);
   }
}

