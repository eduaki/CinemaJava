package model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class GerenciamentoPedidos {


    private static List<Produto> cardapio = new ArrayList<>();
    private static List<Pedido> listaPedido = new ArrayList<>();
    private static boolean dadosCarregados = false;

    public GerenciamentoPedidos(){
        cardapio.add(new Produto(60.0f, "Combo"));
        cardapio.add(new Produto(40.0f, "Pipoca(com manteiga)"));
        cardapio.add(new Produto(25.0f, "Bebida 500ml"));
    }

    @SuppressWarnings("unchecked")
    public static void inicializaDados(){
        if(!dadosCarregados){
            try (ObjectInputStream os = new ObjectInputStream(new FileInputStream("src/Pedidos.dat"))){
                List<Pedido> temp = (List<Pedido>) os.readObject();

                listaPedido = temp;

                dadosCarregados = true;
            } catch (Exception e) {
                e.printStackTrace();
                // listaPedido = new ArrayList<>();
            }
        }
    }
    

    public static List<Produto> pegaCardapio(){
        inicializaDados();
        return cardapio;
    }

    public static void fazerPedido(Pedido pedido){
        inicializaDados();
        listaPedido.add(pedido);
    }

    public static List<Pedido> verHistorico(){
        inicializaDados();
        return listaPedido;
    }

    public static boolean cancelarPedido(int numeroPedido){

        inicializaDados();

        for(Pedido p : listaPedido){
            if(p.getNumeroPedido() == numeroPedido){
                p.setCancelado(true);
                return true;
            }else{
                return false;
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
