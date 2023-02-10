package com.pxt.banco.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import com.pxt.banco.domain.Conta;
import com.pxt.banco.services.ContaService;
import com.pxt.banco.services.ContaServiceImpl;
import com.pxt.banco.services.LancamentosService;
import com.pxt.banco.services.LancamentosServiceImpl;

public class ControllerLancamentos implements Controller {

	private Scanner scannerEntrada;
	
	private LancamentosService lancamentosService = new LancamentosServiceImpl();
	private ContaService contaService = new ContaServiceImpl();

	public ControllerLancamentos(Scanner scannerEntrada) {
		this.scannerEntrada = scannerEntrada;
	}

	public void inicializar() {

		Integer opcao = 0;

		do {

			mostrarMenu();
			opcao = Integer.parseInt(scannerEntrada.nextLine());

			switch (opcao) {

			case 1:
				efetuarSaque(scannerEntrada);
				break;

			case 2:
				efetuarDeposito(scannerEntrada);
				break;

			}

		} while (opcao != 0);
	}

	public void mostrarMenu() {

		System.out.println("+-----------------------------+");
		System.out.println("|                             |");
		System.out.println("| Selecione a opção desejada: |");
		System.out.println("| [1] Efetuar saque           |");
		System.out.println("| [2] Efetuar depósito        |");
		System.out.println("|                             |");
		System.out.println("+-----------------------------+");

	}

	public void efetuarSaque(Scanner scannerEntrada) {
		
		System.out.println("Informe o valor do saque:");
		BigDecimal valorSaque = new BigDecimal (scannerEntrada.nextLine());

		List<Conta> listaRetornadaDoRepository = contaService.mostrarContas();
		lancamentosService.efetuarSaque(null, valorSaque);
		
	}

	public void efetuarDeposito(Scanner scannerEntrada) {

		System.out.println("Informe o valor do saque:");
	}
}
