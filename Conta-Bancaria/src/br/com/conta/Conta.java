package br.com.conta;

public abstract class Conta implements Gerenciavel {

	protected int saldo = 0;

	protected int id;

	public static Integer contador = 0;

	public Conta(int saldo, int id) {
		super();
		this.saldo = saldo;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getSaldo() {
		return saldo;

	}

	public boolean depositar(int valor) {
		this.saldo = saldo + valor;
		return false;
	}

	public void sacar(int valor) {
		this.saldo = saldo - valor;
	}

	public void transferir(Conta destino, int valor) {

	}

	@Override
	public String toString() {
		return ("(Id: " + getId() + " Saldo: " + getSaldo());
	}
}