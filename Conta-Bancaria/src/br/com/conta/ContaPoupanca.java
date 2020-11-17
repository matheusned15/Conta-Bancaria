package br.com.conta;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(int saldo, int id) {
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
		saldo = saldo + (valor * 2);
		return false;
	}

	@Override
	public String toString() {
		return super.toString() + " Tipo de conta: Conta Poupan�a)" + '\n';

	}

}
