package com.pxt.SistemaBanco.repository;

import java.util.ArrayList;
import java.util.List;

import com.pxt.SistemaBanco.domain.Cliente;

public class ClienteRepositoryImpl implements ClienteRepositoryInt {

	static List<Cliente> listaClientes = new ArrayList<Cliente>();

	public Cliente cadastrarClientes(Cliente cliente) {
		listaClientes.add(cliente);
		return cliente;
	}

	public Cliente procurarPorCpf(String cpf) {
		for (Cliente cliente : listaClientes) {
			if (cpf.equals(cliente.getCpfCliente())) {
				return cliente;
			}
		}
		return null;
	}

	public Integer buscarQuantidadeClientes() {
		return listaClientes.size();

	}

}
