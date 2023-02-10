package com.pxt.SistemaBanco.repository;

import com.pxt.SistemaBanco.domain.Cliente;

public interface ClienteRepositoryInt {

	public Cliente cadastrarClientes (Cliente cliente);
	public Cliente procurarPorCpf (String cpf);
	public Integer buscarQuantidadeClientes();
	
}
