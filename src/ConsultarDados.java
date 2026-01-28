public class ConsultarDados extends DadosBancarios implements ColocarSaldo{

    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public boolean subtrairSaldo(double valor) {
        if (valor > saldo) {
            return false;
        }
        saldo -= valor;
        return true;
    }

    @Override
    public double colocarSaldo(double valor) {
        saldo += valor;
        return saldo;
    }

    @Override
    public String escolherMoeda(String moeda) {
        return moeda.trim().toUpperCase();
    }



    public void dadosPessoais(){

        System.out.println("Nome: " + nome );
        System.out.println("Agencia: 000" );
        System.out.println("CPF: " + getCpf());
        System.out.println("Saldo: " + getSaldo());

    }

}
