package br.com.cliente;

import java.util.List;

public interface ClienteServico {
 
	Cliente consultarCliente(String nome, String cpf);

	void inserirCliente(Cliente cliente);

	List<Cliente> listarClientes();

	void excluirClienteServico(String cpf);

}
