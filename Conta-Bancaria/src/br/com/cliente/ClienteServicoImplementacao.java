package br.com.cliente;

import java.util.List;

public class ClienteServicoImplementacao implements ClienteServico {
 
	private ClienteDAO daoCliente;

	public ClienteServicoImplementacao() {
		this.daoCliente = new ClienteDAOImplementacao();
	}

	@Override
	public void inserirCliente(Cliente cliente) {
		daoCliente.salvarCliente(cliente);
	}

	@Override
	public List<Cliente> listarClientes() {
		return daoCliente.listarClientes();
	}

	@Override
	public void excluirClienteServico(String cpf) {
		daoCliente.excluirCliente(cpf);
	}

	@Override
	public Cliente consultarCliente(String nome, String cpf) {
		return daoCliente.consultarCliente(cpf);
	}

}
