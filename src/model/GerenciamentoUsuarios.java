package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
                "Admin",
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
        try (ObjectInputStream oisClientes = new ObjectInputStream(new FileInputStream("src/Clientes.txt"))) {
            listaClientes = (List<Cliente>) oisClientes.readObject();
        } catch (Exception e) {
            listaClientes = new ArrayList<>();
            System.err.println("Erro ao ler arquivo de Clientes: " + e.getMessage());
            salvarClientes();
        }

        try (ObjectInputStream oisFuncionarios = new ObjectInputStream(new FileInputStream("src/Funcionarios.txt"))) {
            listaFuncionarios = (List<Funcionario>) oisFuncionarios.readObject();
        } catch (Exception e) {
            System.err.println("Erro ao ler arquivo de Funcionarios: " + e.getMessage());
            listaFuncionarios = new ArrayList<>();
            salvarFuncionarios();
        }

        dadosCarregados = true;
    }

    public static void salvarFuncionarios() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Funcionarios.txt"))) {
            oos.writeObject(listaFuncionarios);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void salvarClientes() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Clientes.txt"))) {
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
        return new ArrayList<>(listaFuncionarios);
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
