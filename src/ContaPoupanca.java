public class ContaPoupanca extends Conta{

    private static int SEQUENCIAL = 0;

    public ContaPoupanca(Cliente cliente, Agencia agencia) {
        super(cliente, agencia);
        this.numero = SEQUENCIAL = SEQUENCIAL + 2;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato Conta Poupança ===");
        super.imprimirInfosComuns();
    }
}
