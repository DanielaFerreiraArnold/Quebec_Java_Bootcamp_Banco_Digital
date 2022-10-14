package desafio.dio.banco;

public abstract class Conta implements IConta { // abstract garange que a conta não poderá ser instanciada
    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1; // gerar um número sequencialmente
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;


    public Conta(Cliente cliente) {
        this.agencia = Conta.AGENCIA_PADRAO; // super para acessar as informações da classe principal
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;

    }

    @Override
    public void sacar(double valor) {
        saldo -= valor; // para o saque, o saldo é igual a ele mesmo menos o valor
    }

    @Override
    public void depositar(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(double valor, Conta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
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

        System.out.printf("Titular: %s%n ", this.cliente.getNome());
        System.out.printf("Agencia: %d%n", this.agencia);
        System.out.printf("Numero: %d%n", this.numero);
        System.out.printf("Saldo: %.2f", this.saldo); //%.2f é para imprimir o valor com duas casas decimais
    }


}
