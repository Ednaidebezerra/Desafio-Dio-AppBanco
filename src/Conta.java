public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valorSaque) {
        saldo -= valorSaque;
    }

    @Override
    public void depositar(double valorDeposito) {
        saldo += valorDeposito;
    }

    @Override
    public void transferir(double valorTranferencia, IConta contaDestino) {
        this.sacar(valorTranferencia);
        contaDestino.depositar(valorTranferencia);
    }

    @Override
    public void pagar(double valorPagamento) {
        saldo -= valorPagamento;
    }

    @Override
    public void receber(double valorRecebido) {
        saldo += valorRecebido;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }


}