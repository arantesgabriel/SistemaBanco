package com.pxt.SistemaBanco.services;

import java.util.List;

import com.pxt.SistemaBanco.domain.Cliente;

public interface ClienteService {

	public Cliente cadastrarCliente(Cliente cliente);

	Cliente buscarPorNome(String nome);

	List<Cliente> buscar(String nome, String cpfCnpj);

}
