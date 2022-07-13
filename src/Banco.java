import java.awt.desktop.SystemEventListener;
import java.util.*;

public class Banco {
    private String nome;
    public String getNome(){
        return nome;

    }

    private LinkedList<Conta> contas = new LinkedList<Conta>();
    public Conta getConta(int numeroDaConta){
        Conta contaToReturn = null;

        for (Conta conta : contas) {
            if(conta.getNumero() == numeroDaConta){
                contaToReturn = conta;
            }
        }
        return contaToReturn;
    }
    private List<Cliente> clientes = new ArrayList<Cliente>();
    public Cliente getCliente(int id){
        Cliente clienteToReturn = null;

        for (Cliente cliente : clientes) {
            if(cliente.getId() == id){
                clienteToReturn = cliente;
            }
        }
        return clienteToReturn;
    }

    public Banco(String nomeDoBanco){
        nome = nomeDoBanco;
    }

    public void criarCliente(String nomeDoCliente){
        clientes.add(new Cliente(nomeDoCliente));
    }

    public void criarConta(int idCliente, TipoConta tipoConta){
        Cliente clienteToCreate = getCliente(idCliente);
        Conta contaToAdd = null;
       switch (tipoConta) {
           case Polpanca:
               contaToAdd = new ContaPolpanca(clienteToCreate);
               break;
           case Corrente:
               contaToAdd = new ContaCorrente(clienteToCreate);
               break;
       }
       contas.add(contaToAdd);
       clienteToCreate.adicionarConta(contaToAdd);
    }

    public void imprimirContas(){
        for (Conta conta:
             contas) {
            System.out.println(conta);
        }
    }
    public void imprimirCliente(){
        if(clientes.size() > 0){
            for (Cliente cliente :
                    clientes) {
                System.out.println(cliente);
            }
        }else {
            System.out.println("Nunhum Cliente encontrado");
        }
    }

}
