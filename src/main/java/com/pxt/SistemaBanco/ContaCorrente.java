package com.pxt.SistemaBanco;

import java.util.Scanner;

import com.pxt.SistemaBanco.controller.Controller;
import com.pxt.SistemaBanco.controller.ControllerInicial;
import com.pxt.SistemaBanco.utils.ClienteUtils;

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
				System.out.println("Op��o inv�lida, tente novamente.");
				System.out.println("");
			}

		} while (entradaErrada == true);
		
	}
}
