package com.pxt.banco;

import java.util.Scanner;

import com.pxt.banco.controller.Controller;
import com.pxt.banco.controller.ControllerInicial;
import com.pxt.banco.utils.ClienteUtils;

public class ContaCorrente {

	public static void main(String[] args) {

		Scanner scannerEntrada = new Scanner(System.in);
		
		Controller controllerPrincipal = new ControllerInicial (scannerEntrada);
		
		ClienteUtils clienteUtils = new ClienteUtils();
		clienteUtils.cadastrarClientesIniciais();
		
		Boolean entradaErrada = false;
		
		do {
			try {
				controllerPrincipal.inicializar();
			} catch (Exception e) {
				entradaErrada = true;
				System.out.println("Opção inválida, tente novamente.");
				System.out.println("");
			}

		} while (entradaErrada == true);
		
	}
}
