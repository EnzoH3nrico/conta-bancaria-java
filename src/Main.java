import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        //Etapa inicial, onde rodará o valor inserido do usuário.
        Scanner scan = new Scanner(System.in);
        ConsultarDados consultarDados = new ConsultarDados();

        //coloquei esses booleans, para quebrar alguns loops
        boolean registrado = false;
        boolean registroCPF = false;
        boolean encerrar = false;
        boolean continuarPrograma = true;


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
                System.out.println("Para finalizarmos, digite uma senha");

                String novaSenha = scan.nextLine();

                System.out.println("Senha registrada com Sucesso, você está registrado");

                consultarDados.setSenha(novaSenha);

                registrado = true;


            } else if (valor1.equalsIgnoreCase("Sim") || valor1.equals("1")) {

                //mesmo esquema de deixar em loop, para evitar erros
                do {
                    System.out.println("""
                            Sejá bem-vindo de volta! O que deseja consultar?
                            [1] Consultar dados
                            [2] Transferir valor
                            [3] sair
                            
                            \n""");

                    String valor2 = scan.nextLine();

                    //aqui eu consulto os dados, através de uma classe, para evitar dados sensíveis
                    if (valor2.equalsIgnoreCase("consultar dados") || valor2.equals("1")) {
                        consultarDados.dadosPessoais();

                    } else if (valor2.equalsIgnoreCase("transferir valor") || valor2.equals("2")) {
                        Transferir transferir = new Transferir();

                        System.out.println("\n Quanto deseja transferir?");

                        double valor3 = scan.nextDouble();

                        scan.nextLine();

                        //condicional, para evitar saldo negativo de transferência
                        if(valor3 > consultarDados.getSaldo()){
                            System.out.println("Você não possuí saldo suficiente!");
                        } else {
                            transferir.colocarSaldo(valor3);
                        }

                        //aqui o código se encerrará
                    } else if (valor2.equalsIgnoreCase("sair") || valor2.equals("3")) {
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

