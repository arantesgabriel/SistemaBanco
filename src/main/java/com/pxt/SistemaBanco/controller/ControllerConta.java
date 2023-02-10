package com.pxt.SistemaBanco.controller;

import java.util.Scanner;

import com.pxt.SistemaBanco.services.ClienteService;
import com.pxt.SistemaBanco.services.ClienteServiceImpl;

public class ControllerConta implements Controller {

	private Scanner scannerEntrada;

	ClienteService clienteService = new ClienteServiceImpl();

	public ControllerConta(Scanner scannerEntrada) {
		this.scannerEntrada = scannerEntrada;
	}

	public void inicializar() {

		Integer opcao = 0;

		String cpfCliente = null;

		System.out.println("+-----------------------------------------+");
		System.out.println("| Digite o seu CPF para realizar o login: |");
		System.out.println("+-----------------------------------------+");
		cpfCliente = scannerEntrada.nextLine().trim().toUpperCase();

		if (clienteService.procurarPorCpf(cpfCliente) != null) {

			do {

				mostrarMenuConta();
				opcao = Integer.parseInt(scannerEntrada.nextLine());

				switch (opcao) {

				case 1:
					
					break;
				case 2:
					System.out.println("Em desenvolvimento.");
					break;
				case 3:
					System.out.println("Em desenvolvimento.");
				}

			} while (opcao != 0);
		} else
			System.out.println("O CPF digitado n�o possui cadastro.");
		System.out.println("Efetue o cadastro e tente novamente");
		System.out.println("");
	}

	public void mostrarMenuConta() {

		System.out.println("+-----------------------------+");
		System.out.println("|                             |");
		System.out.println("| Selecione a op��o desejada: |");
		System.out.println("| [1] Efetuar transa��es      |");
		System.out.println("| [2] Atualizar dados         |");
		System.out.println("| [3] Excluir conta           |");
		System.out.println("|                             |");
		System.out.println("+-----------------------------+");

	}

}
