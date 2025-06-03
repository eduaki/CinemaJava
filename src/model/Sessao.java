package model;
import java.time.LocalTime;

public class Sessao{

    private Filme filme;
    private Sala sala;
    private LocalTime hora;
    private int ingressoDisponivel;

   public Sessao(Filme filme, Sala sala, LocalTime hora) {
       this.filme = filme;
        this.sala = sala;
        this.hora = hora;
        this.ingressoDisponivel = sala.getCapacidade();
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

    public int getIngressoDisponivel() {
       return this.ingressoDisponivel;
   }
    public void setIngressoDisponivel(int ingressoDisponivel) {
       this.ingressoDisponivel = ingressoDisponivel;
   }

    @Override
    public String toString(){
       return "Sessao " + this.filme.getTitulo() + " - " + this.sala.getNumero() + " - " + this.hora;
    }

}

