package model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoPedidos {


    private static List<Produto> cardapio = new ArrayList<>();
    private static List<Pedido> listaPedido = new ArrayList<>();
    private static boolean dadosCarregados = false;

    public GerenciamentoPedidos(){
        cardapio.add(new Produto(60.0f, "Combo", 30));
        cardapio.add(new Produto(40.0f, "Pipoca(com manteiga)", 40));
        cardapio.add(new Produto(25.0f, "Bebida 500ml", 1));
    }

    @SuppressWarnings("unchecked")
    public static void inicializaDados(){
        if(!dadosCarregados){
            try (ObjectInputStream os = new ObjectInputStream(new FileInputStream("src/Pedidos.txt"))){
                listaPedido = (List<Pedido>) os.readObject();
            } catch (Exception e) {
                listaPedido = new ArrayList<>();
            }
        }
        dadosCarregados = true;
    }
    

    public static List<Produto> pegaCardapio(){
        return cardapio;
    }

    public static void fazerPedido(Pedido pedido){
        listaPedido.add(pedido);
    }

    public static List<Pedido> verHistorico(){
        inicializaDados();
        return listaPedido;
    }

    public static boolean cancelarPedido(int numeroPedido){
        for(Pedido p : listaPedido){
            if(p.getNumeroPedido() == numeroPedido){
                p.setCancelado(true);
                return true;
            }
        }
        return false;
    }

    public static List<Pedido> removePedido(Pedido pedido){

        inicializaDados();

        listaPedido.remove(pedido);        

        return listaPedido;
    }

}
