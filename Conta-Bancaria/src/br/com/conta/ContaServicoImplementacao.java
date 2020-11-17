package br.com.conta;

import br.com.cliente.Cliente;

public class ContaServicoImplementacao implements ContaServico {

	private ContaDAO daoConta;

	public ContaServicoImplementacao() {
		this.daoConta = new ContaDAOImplementacao();
	}

	@Override
	public boolean transferirValor(Conta origem, Conta destino, int valor) {
		if (valor <= origem.saldo) {
			origem.sacar(valor);
			destino.depositar(valor);
			return true;
		} else {

			return false;
		}
	}

	@Override
	public void cadastrarConta(Conta conta) {
		daoConta.criarConta(conta);
	}

	@Override
	public boolean sacar(int valor, Cliente cpf) {
		cpf.getConta().sacar(valor);
		return false;
	}

	@Override
	public boolean depositar(int valor, Cliente cpf) {
		return cpf.getConta().depositar(valor);

	}

}
