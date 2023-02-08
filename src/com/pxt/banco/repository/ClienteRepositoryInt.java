package com.pxt.banco.repository;

import com.pxt.banco.domain.Cliente;

public interface ClienteRepositoryInt {

	public Cliente cadastrarClientes (Cliente cliente);
	public Cliente procurarPorCpf (String cpf);
	public Integer buscarQuantidadeClientes();
	
}
