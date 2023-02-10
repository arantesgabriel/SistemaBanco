package com.pxt.SistemaBanco.services;

import com.pxt.SistemaBanco.domain.Cliente;
import com.pxt.SistemaBanco.repository.ClienteRepositoryInt;
import com.pxt.SistemaBanco.repository.ClienteRepositoryImpl;

public class ClienteServiceImpl implements ClienteService {

	private ClienteRepositoryInt clienteRepository = new ClienteRepositoryImpl();

	public Cliente cadastrarCliente(Cliente cliente) {
		return clienteRepository.cadastrarClientes(cliente);
	}

	public Cliente procurarPorCpf (String cpf) {
		return clienteRepository.procurarPorCpf(cpf);
	}
	
	public Integer buscarQuantidadeClientes () {
		return clienteRepository.buscarQuantidadeClientes();
	}
	
}