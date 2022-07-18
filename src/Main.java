import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente welber = new Cliente(
                "Welber",
                new Endereco("Mario Morais", "Centro", "Varginha", "37.100-000")
        );

        Banco itau = new Banco("Itaú");

        itau.addAgencia(
            new Agencia(
                    1,
                    new Endereco("Rua Maria Antonieta", "Centro", "Varginha", "37.150.001")
            )
        );
        itau.addConta(new ContaCorrente(welber, itau.getAgencias().get(0)));
        itau.addConta(new ContaPoupanca(welber, itau.getAgencias().get(0)));

        for (Conta conta : itau.getContas()) {
            conta.depositar(100);
            conta.imprimirExtrato();
        }
    }
}
