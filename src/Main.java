import java.util.Scanner;


public class Main{
    public static void main(String[] args) {
        //Etapa inicial, onde rodará o valor inserido do usuário.
        Scanner scan = new Scanner(System.in);
        ConsultarDados consultarDados = new ConsultarDados();
        Transferir transferir = new Transferir(consultarDados);


        //coloquei esses booleans, para quebrar alguns loops
        boolean registrado = false;
        boolean registroCPF = false;
        boolean encerrar = false;
        boolean continuarPrograma = true;
        double meuValor;

        //decidi colocar um loop, para que o código continue funcionando
        do{
            System.out.println("""
                    \nOlá! Você tem algum dado salvo em nosso sistema?
                    [1]Sim
                    [2]Não
                    \n""");

            String valor1 = scan.nextLine();


            //esta parte, irá cadastrar todos os dados do usuário, e armazena-los
            if (valor1.equalsIgnoreCase("Não") || valor1.equals("2") && !registrado) {
                System.out.println("Vejo que você não possui dados aqui, então vamos começar! Para começarmos, digite seu nome");
                String novoNome = scan.nextLine();

                consultarDados.nome = novoNome;

                //coloquei um loop aqui, para evitar que o cpf seja armazenado, mesmo com strings ou hashs
                do {
                    System.out.print("Digite o CPF (11 números): ");
                    String novoCpf = scan.nextLine();

                    if (novoCpf.length() != 11) {
                        System.out.println("Isso não é permitido! Tente novamente\n");
                    } else {
                        System.out.println("CPF registrado com sucesso!\n");
                        registroCPF = true;
                        consultarDados.setCpf(novoCpf);
                    }

                } while (!registroCPF);

                //parte da senha, somente uma String
                System.out.println("Digite uma senha");

                String novaSenha = scan.nextLine();

                System.out.println("Senha registrada com Sucesso, você está registrado\n");

                consultarDados.setSenha(novaSenha);

                System.out.println("Estamos em beta. Por favor, digite um valor de saldo para trabalharmos com ele.");

                double novoValor = scan.nextDouble();

                consultarDados.colocarSaldo(novoValor);

                System.out.println("\nFinalizamos tudo! Pode continuar.");


                registrado = true;


            } else if (valor1.equalsIgnoreCase("Sim") || valor1.equals("1")) {

                //mesmo esquema de deixar em loop, para evitar erros
                do {
                    System.out.println("""
                            Sejá bem-vindo de volta! O que deseja consultar?
                            [1] Consultar dados
                            [2] Transferir valor
                            [3] Consultar transferências
                            [4] sair
                            
                            \n""");

                    String valor2 = scan.nextLine();

                    //aqui eu consulto os dados, através de uma classe, para evitar dados sensíveis
                    if (valor2.equalsIgnoreCase("consultar dados") || valor2.equals("1")) {
                        consultarDados.dadosPessoais();

                    } else if (valor2.equalsIgnoreCase("transferir valor") || valor2.equals("2")) {

                        System.out.println("\n Quanto deseja transferir?");

                        double valor3 = scan.nextDouble();

                        scan.nextLine();

                        //condicional, para evitar saldo negativo de transferência
                        if (valor3 > consultarDados.getSaldo()) {
                            System.out.println("Você não possuí saldo suficiente!");
                        } else {
                            transferir.transferir(valor3);
                        }


                    }else if(valor2.equalsIgnoreCase("Consultar transferências") || valor2.equals("3")){
                        System.out.println("---Valores transferidos---");
                        for (Double valoresTransferido : transferir.getValoresTransferidos()) {
                            System.out.println(valoresTransferido);
                        }
                    }

                    else if (valor2.equalsIgnoreCase("sair") || valor2.equals("4")) {
                        System.out.println("Encerrando...");
                        encerrar = true;
                        continuarPrograma = false;
                    } else {
                        System.out.println("Este valor não existe! Tente novamente");
                    }
                }while(!continuarPrograma);
            }
        }while (!encerrar) ;
    }
}

