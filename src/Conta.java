public abstract class Conta {
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    public Conta(Cliente clienteToSet){
        agencia = AGENCIA_PADRAO;
        numero = SEQUENCIAL++;

        cliente = clienteToSet;
    }


    private int agencia;
    private int numero;
    private double saldo;
    private Cliente cliente;
    protected TipoConta tipo;

    public boolean sacar(double valor){
        if(!(valor > saldo)){
            saldo -= valor;
            return true;
        }else {
            System.out.println("Seu saldo nao e suficiente para a acao, seu saldo atual e de: " + saldo);
            return false;
        }
    }
    public void depositar(double valor){
        saldo += valor;
    }
    public void transferir(Conta contaDestino , double valor){
        if(this.sacar(valor)){
            contaDestino.depositar(valor);
        }
    }


    @Override
    public String toString() {
        return
        "\n" +
        "\n ----- Informacoes da Conta -----" +
        "\nCliente: " + cliente.getNome() +
        "\nTipo: " + tipo +
        "\nAgecia: " + agencia +
        "\nNumero: " + numero +
        "\nSaldo: " + saldo +
        "\n";
    }

    public int getAgencia() {
        return agencia;
    }
    public int getNumero() {
        return numero;
    }
    public double getSaldo() { return saldo; }
    public TipoConta getTipo() {
        return tipo;
    }

}
