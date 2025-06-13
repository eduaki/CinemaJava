package model;

import java.util.HashMap;
import java.util.Map;

public class Sala {

    private int numero;
    private int capacidade;
    private static Map<String, Boolean> assentos;

    public Sala(int numero) {
        this.numero = numero;
        this.capacidade = 30;
        Sala.assentos = new HashMap<>();

        char[] fileiras = {'A', 'B', 'C', 'D', 'E'};
        int assentosPorFileira = 6;

        for (char fileira : fileiras) {
            for (int i = 1; i <= assentosPorFileira; i++){
            assentos.put(fileira + String.valueOf(i), true);
            }
            
        }
    }

    public boolean assentoExiste(String assento) {
        return assentos.containsKey(assento);
    }

    public static Map<String, Boolean> getAssentos() {
      return assentos;
    }

    public boolean verificarDisponibilidade(String assento) {
        return assentoExiste(assento) && assentos.get(assento);
    }

    public boolean reservarAssento(String assento) {
        if (assentoExiste(assento) && assentos.get(assento)) {
            assentos.put(assento, false);
            return true;
        } else {
            System.out.println("\n\u001B[31mErro: Assento já está ocupado ou não existe!\u001B[0m");
            return false;
        }
    }

    public void liberarAssento(String assento) {
        assentos.put(assento, true);
    }

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

