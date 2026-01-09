public class ConsultarDados extends DadosBancarios implements ColocarSaldo{

    @Override
    public double colocarSaldo(double valor) {
        return this.saldo += valor;
    }



    public void dadosPessoais(){

        System.out.println("Nome: " + nome );
        System.out.println("Agencia: " + agencia);
        System.out.println("CPF: " + getCpf());
        System.out.println("Saldo: " + getSaldo());

    }

}
