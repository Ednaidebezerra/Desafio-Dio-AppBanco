public interface IConta {

    void sacar(double valorSaque);

    void depositar(double valorDeposito);

    void transferir(double valorTransferencia, IConta contaDestino);

    void imprimirExtrato();

    void pagar( double valorPagamento );

    void receber(double valorRecebido);


}
