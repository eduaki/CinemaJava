package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GerenciamentoUsuarios {

    private static List<Funcionario> listaFuncionarios = new ArrayList<>();
    private static List<Cliente> listaClientes = new ArrayList<>();
    private static boolean dadosCarregados = false;

    private static void verificaInicializacao() {
        if (!dadosCarregados) {
            inicializaDados();
        }

        boolean adminExiste = false;
        for (Funcionario f : listaFuncionarios) {
            if ("admin".equals(f.getCpf())) {
                adminExiste = true;
                break;
            }
        }

        if (!adminExiste) {
            Funcionario admintemp = new Funcionario(
                "Eduardo",
                "admin@admin.com",
                "admin",
                21,
                0,
                0,
                true,
                "senhaAdmin"
            );
            listaFuncionarios.add(admintemp);
            salvarFuncionarios();
        }
    }

    @SuppressWarnings("unchecked")
    public static void inicializaDados() {
        try (ObjectInputStream oisClientes = new ObjectInputStream(new FileInputStream("src/Clientes.dat"))) {
            listaClientes = (List<Cliente>) oisClientes.readObject();
        } catch (Exception e) {
            listaClientes = new ArrayList<>();
        }

        try (ObjectInputStream oisFuncionarios = new ObjectInputStream(new FileInputStream("src/Funcionarios.dat"))) {
            listaFuncionarios = (List<Funcionario>) oisFuncionarios.readObject();
        } catch (Exception e) {
            listaFuncionarios = new ArrayList<>();
        }

        dadosCarregados = true;
    }

    public static void salvarFuncionarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Funcionarios.dat"))) {
            oos.writeObject(listaFuncionarios);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void salvarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Clientes.dat"))) {
            oos.writeObject(listaClientes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Cliente> getListaClientes() {
        verificaInicializacao();
        return listaClientes;
    }

    public static void adicionarCliente(Cliente cliente) {
        verificaInicializacao();
        listaClientes.add(cliente);
        salvarClientes();
    }

    public static void removerCliente(Cliente cliente) {
        verificaInicializacao();
        listaClientes.remove(cliente);
        salvarClientes();
    }

    public static List<Funcionario> getListaFuncionarios() {
        verificaInicializacao();
        return new ArrayList<>(listaFuncionarios); // evitar ConcurrentModificationException
    }

    public static void adicionarFuncionario(Funcionario funcionario) {
        verificaInicializacao();
        listaFuncionarios.add(funcionario);
        salvarFuncionarios();
    }

    public static void removerFuncionario(Funcionario funcionario) {
        verificaInicializacao();
        listaFuncionarios.remove(funcionario);
        salvarFuncionarios();
    }

    public static boolean verificaAdmin(int id) {
        verificaInicializacao();
        return listaFuncionarios.get(id).isAdmin();
    }
}
