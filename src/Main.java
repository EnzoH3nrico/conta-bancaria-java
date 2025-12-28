
import java.util.Scanner;

public class Main{
    public static void main(String[] args){

        //Etapa inicial, onde rodará o valor inserido do usuário.

        Scanner leitura_de_valor = new Scanner(System.in);

        System.out.println("\nOlá! Por favor, digite um valor para começarmos.");

        double valor_do_usuario = leitura_de_valor.nextDouble();

        leitura_de_valor.nextLine();

        //parte da condicional, para averiguar o saldo do usuário, e abordar dois métodos distintos.

        if(valor_do_usuario == 0){

            //Neste processo, o código aplicará um novo saldo ao usuário, para futuras aplicações com o saldo.

            System.out.println("Vejo que não há saldo em sua conta! Por favor, insira um valor.");

            double novo_dado = leitura_de_valor.nextDouble();

            valor_do_usuario = novo_dado;

            System.out.println("Ótimo! Seu novo saldo é " + valor_do_usuario);
        }

        if(valor_do_usuario > 0){

                System.out.println("\nSeja bem vindo novamente! O que deseja consultar?");


                System.out.println("\nSaldo: xxxxxxxx");


                do{
                String opcoes_de_escolha = """
                        
                        1- Consultar dados
                        2- Receber valor
                        3- Transferir valor
                        4- sair
                        
                        Digite a opção desejada
                        """;

                System.out.println(opcoes_de_escolha);

                String escolha_do_usuario = leitura_de_valor.nextLine();

                switch (escolha_do_usuario) {

                    case "1":
                        //Aqui mostratá o saldo do usuário
                        System.out.println("Seu saldo atual é: " + valor_do_usuario);
                        break;
                    case "2":
                        //para caso do usuário receber transfêrencias, aqui seria um validador.
                        System.out.println("Você não recebeu transferência ainda!");
                        break;
                    case "3":

                        // Valida o saldo antes de permitir a transferência
                        System.out.println("Ótimo! Digite o valor desejado.");

                        double transferir_valor = leitura_de_valor.nextDouble();

                        leitura_de_valor.nextLine();

                        valor_do_usuario -= transferir_valor;

                        if (transferir_valor > valor_do_usuario) {
                            System.out.println("Você não pode finalizar esta transferência! Saldo insuficiente.");
                        } else {
                            valor_do_usuario -= transferir_valor;
                            System.out.println("Seu saldo atual é: " + valor_do_usuario);
                        }
                        break;
                    case "4":
                        //Caso o usuário queira sair, isto finalizará o programa,.
                        System.out.println("Encerrando serviços...");
                        valor_do_usuario = 0;
                        break;

                    default:
                        //caso nenhum valor seja selecionado, ele alertará o usuário.
                        System.out.println("Valor indisponível! tente novamente.");
                }
            }
                //Aqui acabará a aplicação, caso o valor do usuário chegue a zero, igual ao "case 4".
            while(valor_do_usuario != 0);
        }
        leitura_de_valor.close();
    }
}