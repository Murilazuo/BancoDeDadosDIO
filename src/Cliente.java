import java.util.LinkedList;
import java.util.List;

public class Cliente {
    private static int ID = 1;
    public Cliente(String nome){
        this.nome = nome;
        this.id = ID++;
    }
    private String nome;
    private int id;
    public String getNome() {
        return nome;
    }
    public int getId(){
        return id;
    }

    private List<Conta> contas = new LinkedList<Conta>();
    public void adicionarConta(Conta contaToAdd){
        contas.add(contaToAdd);
    }
    public String imprimirContas(){
        String contasToReturn = "";

        for ( Conta conta : contas ) {
            contasToReturn += conta;
        }

        return contasToReturn;
    }


    @Override
    public String toString() {
        return
        "\n"+
        "\n ----- Informacoes do Cliente -----" +
        "\nNome: " + nome +
        "\nId: " + id +
        "\n ----- Contas -----" +
        imprimirContas() +
        "\n";
    }

}
