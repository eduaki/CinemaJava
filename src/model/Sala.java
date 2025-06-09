package model;

public class Sala{
//    int assentoDisponivel;
    private int numero;
    private int capacidade;

  public Sala(int numero, int capacidade) {
      this.numero = numero;
       this.capacidade = capacidade;
  }

//getters e set
  public int getNumero() {
      return this.numero;
  }
    public void setNumero(int numero) {
      this.numero = numero;
  }

    public int getCapacidade() {
      return this.capacidade;
  }
    public void setCapacidade(int capacidade) {
      this.capacidade = capacidade;
  }

    @Override
    public String toString() {
      return this.numero + " - " + this.capacidade;
    }
}

