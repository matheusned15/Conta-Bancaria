package br.com.conta;

public class ContaCorrente extends Conta {

	public ContaCorrente(int saldo, int id) {
		super(saldo, id);
	}

	@Override
	public int getSaldo() {
		return saldo;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void sacar(int valor) {
		this.saldo = saldo - valor;
	}

	@Override
	public boolean depositar(int valor) {
		this.saldo = saldo + valor;
		return false;

	}

	@Override
	public String toString() {
		return super.toString() + " Tipo de conta: Conta Corrente)" + '\n';

	}

}