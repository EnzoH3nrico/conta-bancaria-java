import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


public class Transferir {
    private ConsultarDados conta;

    public List<Double> getValoresTransferidos() {
        return valoresTransferidos;
    }

    public void setValoresTransferidos(List<Double> valoresTransferidos) {
        this.valoresTransferidos = valoresTransferidos;
    }

    private List<Double> valoresTransferidos = new ArrayList<Double>();

    public Transferir(ConsultarDados conta) {
        this.conta = conta;
    }


    public void transferir(double valor) {
        if (conta.subtrairSaldo(valor)) {
            valoresTransferidos.add(valor);
            Collections.sort(valoresTransferidos);

            System.out.println("Transferência realizada com sucesso!");
        } else {
            System.out.println("Você não possui saldo suficiente!");
        }
    }

    public int compareTo(Transferir outroValorTransferido){

        return Integer.compare(this.valoresTransferidos.size(), outroValorTransferido.valoresTransferidos.size());
    }
}