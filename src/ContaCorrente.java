public class ContaCorrente extends Conta {

    private static int SEQUENCIAL = -1;

    public ContaCorrente(Cliente cliente, Agencia agencia) {
        super(cliente, agencia);
        this.numero = SEQUENCIAL = SEQUENCIAL + 2;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("\n=== Extrato Conta Corrente ===");
        super.imprimirInfosComuns();
    }
}
