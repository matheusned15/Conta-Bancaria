package br.com.cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteDAOImplementacao implements ClienteDAO {
 
	private List<Cliente> listaCliente;

	public ClienteDAOImplementacao() {
		this.listaCliente = new ArrayList<>();
	}

	@Override
	public boolean salvarCliente(Cliente cliente) {
		if (listaCliente.contains(cliente)) {
			IllegalArgumentException erro = new IllegalArgumentException();
			throw erro;

		} else {

			listaCliente.add(cliente);
		}

		return false;
	}

	@Override
	public Cliente consultarCliente(String cpf) {

		for (int i = 0; i < listaCliente.size(); i++) {
			if (cpf != null && listaCliente.get(i).getCpf().equals(cpf)) {
				return listaCliente.get(i);
			}
		}
		return null;

	}

	@Override
	public List<Cliente> listarClientes() {
		return this.listaCliente;

	}

	@Override
	public void excluirCliente(String cpf) {
		for (int i = 0; i < listaCliente.size(); i++) {
			if (listaCliente.get(i).getCpf().equals(cpf)) {
				listaCliente.remove(i);
			}
		}
	}

}
