package com.pxt.banco.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Scanner;

import com.pxt.banco.domain.Cliente;
import com.pxt.banco.domain.Conta;
import com.pxt.banco.services.ClienteService;
import com.pxt.banco.services.ClienteServiceImpl;
import com.pxt.banco.services.ContaService;
import com.pxt.banco.services.ContaServiceImpl;

public class ControllerCliente implements Controller {

	private Scanner scannerEntrada;
	private ClienteService clienteService = new ClienteServiceImpl();
	private ContaService contaService = new ContaServiceImpl();

	public ControllerCliente(Scanner scannerEntrada) {
		this.scannerEntrada = scannerEntrada;
	}

	public void inicializar() {

		Integer opcao = 0;

		do {

			mostrarMenuCliente();

			opcao = Integer.parseInt(scannerEntrada.nextLine());

			switch (opcao) {

			case 1:
				cadastrarCliente(scannerEntrada);
				break;

			case 2:
				System.out.println("Função em desenvolvimento.");
				break;
			}

		} while (opcao != 0);

	}

	public void mostrarMenuCliente() {

		System.out.println("+-----------------------------+");
		System.out.println("|  Criação de Conta-Corrente  |");
		System.out.println("+-----------------------------+");
		System.out.println("+-----------------------------+");
		System.out.println("|                             |");
		System.out.println("| Selecione o tipo da conta   |");
		System.out.println("| [1] Conta Corrente          |");
		System.out.println("| [2] Conta Poupança          |");
		System.out.println("|                             |");
		System.out.println("+-----------------------------+");

	}

	public void cadastrarCliente(Scanner scanerEntrada) {

		String nomeCliente = null;
		String cpfCliente = null;
		LocalDate data = LocalDate.now();

		System.out.println("Digite seu nome completo:");
		nomeCliente = scannerEntrada.nextLine().trim().toUpperCase();

		System.out.println("Digite seu CPF:");
		cpfCliente = scannerEntrada.nextLine().trim().toUpperCase();

		// Consulta CPF informado para verificar se existe
		if (clienteService.procurarPorCpf(cpfCliente) == null) {

			Integer codigoCliente = clienteService.buscarQuantidadeClientes() + 1;

			Cliente cliente = new Cliente(codigoCliente, nomeCliente, cpfCliente, data);
			clienteService.cadastrarCliente(cliente);

			Integer numeroConta = contaService.gerarNumeroConta() + 1;

			Conta conta = new Conta(cliente, numeroConta, BigDecimal.ZERO);
			contaService.gerarNovaConta(conta);

			System.out.println("");
			System.out.println("+---------------------------+");
			System.out.println("| Conta criada com sucesso! |");
			System.out.println("+---------------------------+");
			System.out.println("");
		} else
			System.out.println("O CPF digitado já está cadastrado. Efetue o login.");
			System.out.println("");
			
			Controller controller = null;
			
			controller = new ControllerInicial(scannerEntrada);
			controller.inicializar();

	}

}
