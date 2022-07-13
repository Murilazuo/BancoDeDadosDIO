import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do banco a ser criado?");
        Banco banco = new Banco(scanner.next());

        boolean continuar = true;
        while (continuar){
            System.out.println("Qual menu deseja acessar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cliente");
            System.out.println("2 - Conta");


            switch (scanner.nextInt()){
                case 0:
                    continuar = false;
                    break;
                case 1:
                    menuCliente(scanner, banco);
                    break;
                case 2:
                    menuConta(scanner, banco);
                    break;
                default:
                    System.out.println("Comando nao encontrado.");
                    break;
            }
        }
    }

    static void menuCliente(Scanner scan, Banco banco){
        boolean continuar = true;
        do {
            System.out.println("Qual Acao deseja fazer?");
            System.out.println("0 - Sair");
            System.out.println("1 - Ver Clientes");
            System.out.println("2 - Criar Cliente");


            switch (scan.nextInt()) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    banco.imprimirCliente();
                    break;
                case 2:
                    System.out.println("Digite o nome do cliente para ser criado?");
                    banco.criarCliente(scan.next());
                    break;

                default:
                    System.out.println("\nComando nao encontrado.\n");
                    break;
            }
        }while (continuar);
    }

    static void menuConta(Scanner scan, Banco banco){
        boolean continuar = true;
        do {
            System.out.println("Qual Acao deseja fazer?");
            System.out.println("0 - Sair");
            System.out.println("1 - Ver Contas");
            System.out.println("2 - Criar Conta");
            System.out.println("3 - Fazer transacao entre contas");
            System.out.println("4 - Sacar");
            System.out.println("5 - Depositar");

            switch (scan.nextInt()) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    banco.imprimirContas();
                    break;
                case 2:
                    System.out.println("Digite o id do cliente ao qual a conta de ser criada.");
                    int idCliente = scan.nextInt();

                    if(banco.getCliente(idCliente) != null) {
                        System.out.println(banco.getCliente(idCliente));

                        System.out.println("Digite o tipo de conta que deve ser criada (polpanca = 0, corrente = 1)");
                        switch (scan.nextInt()) {
                            case 0:
                                banco.criarConta(idCliente, TipoConta.Polpanca);
                                break;
                            case 1:
                                banco.criarConta(idCliente, TipoConta.Corrente);
                                break;
                            default:
                                System.out.println("Tipo de conta nao encontrado.");
                                break;
                        }
                    }else {
                        System.out.println("\nId do cliente nao encontrado.\n");
                    }
                    break;
                case 3:
                    Conta conta1,conta2;

                    System.out.println("Digite o numero da conta para fazer a transferencia");
                    conta1 = banco.getConta(scan.nextInt());

                    System.out.println("Digite o numero do conta que ira receber a transferencia");
                    conta2 = banco.getConta(scan.nextInt());

                    System.out.println("Digite valor da tranferencia");
                    conta1.transferir(conta2, scan.nextDouble());
                    break;
                case 4:
                    Conta contaParaSacar;

                    System.out.println("Digite o numero da conta para sacar");

                    try{
                        contaParaSacar = banco.getConta(scan.nextInt());
                    }catch (NullPointerException e){
                        System.out.println("Conta nao encontrada");
                        break;
                    }

                    System.out.println("Digite valor para sacar");
                    try{
                    contaParaSacar.sacar(scan.nextDouble());
                    }catch (NullPointerException e){
                        System.out.println("Valor invalido");
                        break;
                    }
                    break;
                case 5:
                    Conta contaParaDepositar;

                    System.out.println("Digite o numero da conta para depositar");
                    try{
                        contaParaDepositar = banco.getConta(scan.nextInt());
                    }catch (NullPointerException e){
                        System.out.println("Conta nao encontrada");
                        break;
                    }

                    System.out.println("Digite valor para depositar");
                    try{
                        contaParaDepositar.depositar(scan.nextDouble());
                    }catch (NullPointerException e){
                        System.out.println("Valor invalido");
                        break;
                    }
                    catch (InputMismatchException e){
                        System.out.println("Valor invalido");
                        break;
                    }
                    break;
                default:
                    System.out.println("\nComando nao encontrado.\n");
                    break;
            }
        }while (continuar);
    }
}