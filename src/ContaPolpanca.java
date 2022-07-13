public class ContaPolpanca extends Conta {
    public ContaPolpanca(Cliente cliente){
        super(cliente);
        this.tipo = TipoConta.Polpanca;
    }
}
