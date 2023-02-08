package com.pxt.banco.services;

import com.pxt.banco.domain.Cliente;
import com.pxt.banco.repository.ClienteRepositoryInt;
import com.pxt.banco.repository.ClienteRepositoryImpl;

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