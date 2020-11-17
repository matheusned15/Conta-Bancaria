package br.com.cliente;

import java.util.List;

public interface ClienteDAO {

	boolean salvarCliente(Cliente cliente);

	Cliente consultarCliente(String cpf);

	List<Cliente> listarClientes();

	void excluirCliente(String cpf);
 
}
