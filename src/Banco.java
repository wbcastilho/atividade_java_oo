import java.util.ArrayList;
import java.util.List;

public class Banco implements IBanco{

    private String nome;
    private List<Conta> contas;
    private List<Agencia> agencias;

    public Banco(String nome) {
        this.nome = nome;
        contas = new ArrayList<>();
        agencias = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

    public List<Agencia> getAgencias() {
        return agencias;
    }

    public void setAgencias(List<Agencia> agencias) {
        this.agencias = agencias;
    }

    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    public void addAgencia(Agencia agencia) {
        this.agencias.add(agencia);
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", contas=" + contas +
                ", agencias=" + agencias +
                '}';
    }
}
