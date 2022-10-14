package desafio.dio.banco;

public class Main {
    public static void main(String[] args) {
        Cliente pessoa = new Cliente();
        pessoa.setNome("Daniela");

        Conta cc = new ContaCorrente(pessoa);
        cc.depositar(100);

        Conta poupanca = new ContaPoupanca(pessoa);
        cc.transferir(100, poupanca);

        cc.imprimirInfosComuns();
        poupanca.imprimirInfosComuns();

    }
}

