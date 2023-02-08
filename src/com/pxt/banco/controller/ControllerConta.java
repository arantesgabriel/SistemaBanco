package com.pxt.banco.controller;

import java.util.Scanner;

public class ControllerConta implements Controller {

	private Scanner scannerEntrada;

	public ControllerConta(Scanner scannerEntrada) {
		this.scannerEntrada = scannerEntrada;
	}

	public void inicializar() {

		Integer opcao = 0;

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
	}

	public void mostrarMenuConta() {

		System.out.println("+-----------------------------+");
		System.out.println("|                             |");
		System.out.println("| Selecione a opção desejada: |");
		System.out.println("| [1] Efetuar transações      |");
		System.out.println("| [2] Atualizar dados         |");
		System.out.println("| [3] Excluir conta           |");
		System.out.println("|                             |");
		System.out.println("+-----------------------------+");

	}

}
