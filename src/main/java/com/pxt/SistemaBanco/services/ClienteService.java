package com.pxt.SistemaBanco.services;

import com.pxt.SistemaBanco.domain.Cliente;

public interface ClienteService {

	public Cliente cadastrarCliente (Cliente cliente);
	public Cliente procurarPorCpf (String cpf);
	public Integer buscarQuantidadeClientes();
	
}
