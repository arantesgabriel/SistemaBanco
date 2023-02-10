package com.pxt.SistemaBanco.utils;

import java.time.LocalDate;

import com.pxt.SistemaBanco.domain.Cliente;
import com.pxt.SistemaBanco.services.ClienteService;
import com.pxt.SistemaBanco.services.ClienteServiceImpl;

public class ClienteUtils {

	public void cadastrarClientesIniciais () {
		
		LocalDate data = LocalDate.now();
		
		ClienteService clienteService = new ClienteServiceImpl();
		clienteService.cadastrarCliente(new Cliente (1, "JOS�", "14578923655", data));
		clienteService.cadastrarCliente(new Cliente (2, "MARIA", "58745965899", data));
		clienteService.cadastrarCliente(new Cliente (3, "GABRIEL", "68452145800", data));
	}
	
}
