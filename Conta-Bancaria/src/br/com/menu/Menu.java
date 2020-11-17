package br.com.menu;

import java.util.Scanner;

import br.com.cliente.Cliente;
import br.com.cliente.ClienteServico;
import br.com.cliente.ClienteServicoImplementacao;
import br.com.conta.Conta;
import br.com.conta.ContaCorrente;
import br.com.conta.ContaPoupanca;
import br.com.conta.ContaServico;

public class Menu {

	private Scanner sc = new Scanner(System.in);
	private ClienteServico clienteServico;
	private ContaServico contaServico;

	public Menu() {
		this.clienteServico = new ClienteServicoImplementacao();
		this.contaServico = new br.com.conta.ContaServicoImplementacao();
	}

	public void cadastrarCliente() {
		String nome;
		String cpf;

		System.out.println("Qual seu nome?");
		nome = sc.next();

		System.out.println("Qual seu cpf?");
		cpf = sc.next();

		Cliente cliente = new Cliente(nome, cpf);
		try {
			if (cliente.getCpf().equals(cpf)) {
				clienteServico.inserirCliente(cliente);
				System.out.println("Salvando a pessoa: " + cliente.getNome());
			} else {

				System.out.println("Erro ao salvar o cliente");
			}
		} catch (IllegalArgumentException e) {
			System.out.println("Cpf: " + cliente.getCpf() + " já cadastrado");
		}

	}

	public void transferir() {
		try {
			System.out.println("Qual seu cpf?");
			String cpf = sc.next();

			Cliente cliente = clienteServico.consultarCliente(null, cpf);
			System.out.println(cliente);

			System.out.println("Deseja transferir para quem?");
			String cpfDestino = sc.next();

			Cliente cliente2 = clienteServico.consultarCliente(null, cpfDestino);

			if (cliente2 == null) {
				System.out.println("Erro ao transferir " + cpfDestino + " não existe");

			}

			System.out.println("Qual valor deseja transferir?");
			int valor = sc.nextInt();
			if (cliente.getCpf() != cliente2.getCpf() && cliente2.getConta() != null && cliente.getConta() != null
					&& valor <= cliente.getConta().getSaldo()) {

				contaServico.transferirValor(cliente.getConta(), cliente2.getConta(), valor);

				System.out.println("Transferencia realizada com sucesso!");

			} else {
				System.out.println("Erro na transferencia");
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

	public void sacar() {
		try {

			System.out.println("Qual seu cpf?");
			String cpf = sc.next();

			Cliente cliente = clienteServico.consultarCliente(null, cpf);
			System.out.println(cliente);
			if (cliente.getConta() != null) {

				System.out.println("Qual valor deseja sacar?");
				int valor = sc.nextInt();

				contaServico.sacar(valor, cliente);

				System.out.println(cliente.getConta().getSaldo());
			} else {
				System.out.println("Erro ao sacar: Conta Inexistente");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

	}

	public void depositar() {
		try {
			System.out.println("Qual seu cpf?");
			String cpf = sc.next();

			Cliente cliente = clienteServico.consultarCliente(null, cpf);
			System.out.println(cliente);
			if (cliente.getConta() != null) {

				System.out.println("Qual valor deseja depositar?");
				int valor = sc.nextInt();

				contaServico.depositar(valor, cliente);

				System.out.println("Deposito realizado!");

				System.out.println(cliente.getConta().getSaldo());
			} else {
				System.out.println("Erro ao depositar: Conta Inexistente");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void atualizar() {

		String cpf;

		System.out.println("Qual seu cpf?");
		cpf = sc.next();

		System.out.println(clienteServico.consultarCliente(null, cpf));

		Cliente cliente = clienteServico.consultarCliente(null, cpf);

		System.out.println("Deseja alterar para qual nome?");
		cliente.setNome(sc.next());

		System.out.println("Deseja alterar o cpf para qual?");
		cliente.setCpf(sc.next());

		System.out.println("Usuario atualizado!");
		System.out.println(clienteServico.listarClientes());

	}

	public void cadastarConta() {

		System.out.println("Qual seu cpf?");
		String cpf = sc.next();

		Cliente cliente = clienteServico.consultarCliente(null, cpf);

		System.out.println("Gostaria de criar uma conta Corrente ou conta poupança?");
		String resp = sc.next();

		if (resp.toLowerCase().contains("corrente")) {
			ContaCorrente contaCorrente = new ContaCorrente(0, 0);

			contaServico.cadastrarConta(contaCorrente);
			Conta.contador++;
			cliente.setConta(contaCorrente);
			System.out.println("Conta corrente criada!");
			contaCorrente.setId(Conta.contador);
			System.out.println(contaCorrente.getId());
		} else {

			ContaPoupanca contaPoupanca = new ContaPoupanca(0, 0);
			contaServico.cadastrarConta(contaPoupanca);

			Conta.contador++;
			cliente.setConta(contaPoupanca);

			System.out.println("Conta poupança criada!");
			System.out.println(Conta.contador);
			contaPoupanca.setId(Conta.contador);

		}

	}

	public void listarTodos() {

		System.out.println(clienteServico.listarClientes());
	}

	public void excluir() {

		String cpf;
		System.out.println("Qual cpf deseja excluir?");
		cpf = sc.next();
		clienteServico.excluirClienteServico(cpf);
		System.out.println("Usuario removido!");
	}

	public void consultar() {
		String cpf;

		System.out.println("Qual seu cpf?");
		cpf = sc.next();

		System.out.println(clienteServico.consultarCliente(null, cpf));
	}

	public void iniciarAplicacao() {
		int opcao = 0;
		do {

			System.out.println("\n            ================================");
			System.out.println("             |     1 - Cadastrar             |");
			System.out.println("             |     2 - Alterar               |");
			System.out.println("             |     3 - Remover               |");
			System.out.println("             |     4 - Consultar             |");
			System.out.println("             |     5 - Listar Todos          |");
			System.out.println("             |     6 - Cadastrar conta       |");
			System.out.println("             |     7 - Depositar valor       |");
			System.out.println("             |     8 - Sacar valor           |");
			System.out.println("             |     9 - Transferir valor      |");
			System.out.println("             |     0 - Sair                  |");
			System.out.println("              ==============================\n");
			System.out.println("--------------------------------------");

			opcao = sc.nextInt();
			System.out.print("\n");
			switch (opcao) {
			case 1:
				cadastrarCliente();
				break;
			case 2:
				atualizar();
				break;
			case 3:
				excluir();
				break;

			case 4:
				consultar();
				break;

			case 5:
				listarTodos();
				break;
			case 6:
				cadastarConta();
				break;

			case 7:
				depositar();
				break;
			case 8:
				sacar();
				break;
			case 9:
				transferir();
				break;

			case 0:
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
		} while (opcao != 0);
		System.out.println("Saindo");
		sc.close();
	}

}
