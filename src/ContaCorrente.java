public class ContaCorrente extends Conta{
    public ContaCorrente(Cliente cliente){
        super(cliente);
        this.tipo = TipoConta.Corrente;
    }
}
