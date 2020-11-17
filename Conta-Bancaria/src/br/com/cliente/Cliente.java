package br.com.cliente;

import br.com.conta.Conta;
 
public class Cliente { 
 
	private String nome;
	private String cpf;
	private Conta conta;

	public Cliente(String nome, String cpf) {
		super();
		this.cpf = cpf;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String string) {
		this.cpf = string;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	@Override
	public String toString() {
		return ("Nome: " + getNome() + ", Cpf: " + getCpf() + " Conta: " + getConta());
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Cliente) {
			Cliente outro = (Cliente) obj;
			if (this.getCpf().equals(outro.getCpf())) {
				return true;
			}
		}
		return false;
	}

}
