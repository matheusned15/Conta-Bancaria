package br.com.conta;

import java.util.ArrayList;
import java.util.List;

public class ContaDAOImplementacao implements ContaDAO {

	private List<Conta> listaConta;

	public ContaDAOImplementacao() {
		this.listaConta = new ArrayList<>();
	}

	@Override
	public boolean criarConta(Conta conta) {
		return listaConta.add(conta);

	}

}
