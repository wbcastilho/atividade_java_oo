import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    static List<Banco> bancoLista = new ArrayList<>();

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        Scanner scan = new Scanner(System.in);
        int opcao;

        System.out.println("\n-- MENU --");
        System.out.println("1 - Cadastrar Banco");
        System.out.println("2 - Listar Bancos");
        System.out.println("3 - Cadastrar Agência");
        System.out.println("4 - Listar Agências");
        System.out.println("5 - Exibir Agência");
        System.out.println("6 - Cadastrar Conta Corrente");
        System.out.println("7 - Listar Contas");
        opcao = scan.nextInt();

        switch (opcao) {
            case 1 -> cadastrarBanco();
            case 2 -> listarBancos();
            case 3 -> cadastrarAgencia();
            case 4 -> listarAgencias();
            case 5 -> exibirAgencia();
            case 6 -> cadastrarContaCorrente();
            case 7 -> listarContas();
            default -> System.out.println("Opção inválida...");
        }
        menu();
    }

    private static void cadastrarBanco() {
        System.out.println("Informe o nome do banco: ");
        Scanner scan = new Scanner(System.in);
        String nome = scan.next();
        Banco banco = new Banco(nome);
        bancoLista.add(banco);

        System.out.println("\nBanco cadastrado com sucesso!");
    }

    private static void listarBancos() {
        for (Banco banco : bancoLista) {
            System.out.println(banco);
        }
    }

    private static void cadastrarAgencia() {
        System.out.println("Informe a posição do banco: ");
        Scanner scan = new Scanner(System.in);
        int id = scan.nextInt();

        System.out.println("Informe o número da agencia: ");
        scan = new Scanner(System.in);
        int numero = scan.nextInt();

        System.out.println("Informe a rua da agência: ");
        scan = new Scanner(System.in);
        String rua = scan.next();

        System.out.println("Informe o bairro da agência: ");
        scan = new Scanner(System.in);
        String bairro = scan.next();

        System.out.println("Informe a cidade da agência: ");
        scan = new Scanner(System.in);
        String cidade = scan.next();

        System.out.println("Informe o cep da agência: ");
        scan = new Scanner(System.in);
        String cep = scan.next();

        bancoLista.get(id).addAgencia(
                new Agencia(
                    numero,
                    new Endereco(rua, bairro, cidade, cep)
                )
        );

        System.out.println("\nAgência cadastrada com sucesso!");
    }

    private static void listarAgencias() {
        System.out.println("Informe a posição do banco: ");
        Scanner scan = new Scanner(System.in);
        int bancoPosicao = scan.nextInt();

        List<Agencia> agenciaList = bancoLista.get(bancoPosicao).getAgencias();

        for (Agencia agencia : agenciaList) {
            System.out.println(agencia);
        }
    }

    private static void exibirAgencia() {
        System.out.println("Informe a posição do banco: ");
        Scanner scan = new Scanner(System.in);
        int bancoPosicao = scan.nextInt();

        System.out.println("Informe a posicao da agencia: ");
        scan = new Scanner(System.in);
        int agenciaPosicao = scan.nextInt();

        List<Agencia> agenciaList = bancoLista.get(bancoPosicao).getAgencias();
        Agencia agencia = agenciaList.get(agenciaPosicao);

        System.out.println(agencia);
    }

    private static void cadastrarContaCorrente() {
        System.out.println("Informe a posição do banco: ");
        Scanner scan = new Scanner(System.in);
        int bancoPosicao = scan.nextInt();

        System.out.println("Informe o a posição da agencia: ");
        int agenciaPosicao = scan.nextInt();

        System.out.println("Informe o nome do cliente: ");
        String nomeCliente = scan.next();

        System.out.println("Informe o endereço do cliente: ");
        String ruaCliente = scan.next();

        System.out.println("Informe o bairro do cliente: ");
        String bairroCliente = scan.next();

        System.out.println("Informe a cidade do cliente: ");
        String cidadeCliente = scan.next();

        System.out.println("Informe o cep do cliente: ");
        String cepCliente = scan.next();

        Banco banco = bancoLista.get(bancoPosicao);
        List<Agencia> agenciaList = banco.getAgencias();
        Agencia agencia = agenciaList.get(agenciaPosicao);

        Cliente cliente = new Cliente(
                nomeCliente,
                new Endereco(ruaCliente, bairroCliente, cidadeCliente, cepCliente)
        );

        banco.addConta(new ContaCorrente(cliente, agencia));

        System.out.println("\nConta corrente cadastrada com sucesso!");
    }

    private static void listarContas() {
        System.out.println("Informe a posição do banco: ");
        Scanner scan = new Scanner(System.in);
        int bancoPosicao = scan.nextInt();

        Banco banco = bancoLista.get(bancoPosicao);
        List<Conta> contas = banco.getContas();

        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }
}
