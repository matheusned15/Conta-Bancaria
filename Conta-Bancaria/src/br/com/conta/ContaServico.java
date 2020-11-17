package br.com.conta;

import br.com.cliente.Cliente;

public interface ContaServico {

	public boolean transferirValor(Conta origem, Conta destino, int valor);

	public void cadastrarConta(Conta conta);

	public boolean sacar(int valor, Cliente cpf);

	boolean depositar(int valor, Cliente cpf);

}
