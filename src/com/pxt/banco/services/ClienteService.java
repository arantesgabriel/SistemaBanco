package com.pxt.banco.services;

import com.pxt.banco.domain.Cliente;

public interface ClienteService {

	public Cliente cadastrarCliente (Cliente cliente);
	public Cliente procurarPorCpf (String cpf);
	public Integer buscarQuantidadeClientes();
	
}
