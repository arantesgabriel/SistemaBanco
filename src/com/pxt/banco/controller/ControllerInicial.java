package com.pxt.banco.controller;

import java.time.LocalDate;
import java.util.Scanner;

import com.pxt.banco.services.ClienteService;
import com.pxt.banco.services.ClienteServiceImpl;
import com.pxt.banco.domain.Cliente;
import com.pxt.banco.domain.Conta;

public class ControllerInicial implements Controller {

	private Scanner scannerEntrada;

	private ClienteService clienteService = new ClienteServiceImpl();

	Controller controller = null;

	public ControllerInicial(Scanner scannerEntrada) {
		this.scannerEntrada = scannerEntrada;

	}

	public void inicializar() {

		boolean entradaErrada = false;
		Integer opcao = 0;

		do {
			try {
				System.out.println("+-------------------------------+");
				System.out.println("|                               |");
				System.out.println("|  Bem vindo ao Banco Peixoto!  |");
				System.out.println("|                               |");
				System.out.println("|  Selecione a opção desejada:  |");
				System.out.println("|  [1] Fazer login              |");
				System.out.println("|  [2] Criar conta              |");
				System.out.println("|  [0] Sair                     |");
				System.out.println("|                               |");
				System.out.println("+-------------------------------+");

				opcao = Integer.parseInt(scannerEntrada.nextLine());

				switch (opcao) {

				case 1:
					controller = new ControllerConta(scannerEntrada);
					controller.inicializar();
					break;

				case 2:
					controller = new ControllerCliente(scannerEntrada);
					controller.inicializar();
					break;

				case 0:
					System.out.println("Saindo do sistema...");
					System.out.println("Volte sempre!");
					break;

				}

				entradaErrada = false;

			} catch (Exception e) {
				entradaErrada = true;
				System.err.println("Opção inválida, tente novamente.");
				System.out.println("");
			}

		} while (opcao != 0 || entradaErrada);
	}


}