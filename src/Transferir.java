public class Transferir extends DadosBancarios implements ColocarSaldo{
    protected double valorTranferido;


    @Override
    public double colocarSaldo(double valor) {
        return saldo -= valorTranferido;
    }
}
