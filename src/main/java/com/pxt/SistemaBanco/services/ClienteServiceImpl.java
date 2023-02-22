package com.pxt.SistemaBanco.services;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxt.SistemaBanco.domain.Cliente;
import com.pxt.SistemaBanco.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ContaCorrenteService contaService;

	@Override
	@Transactional
	public Cliente cadastrarCliente(Cliente cliente) {
		validarCpfCliente(cliente);
		cliente.setDataCadastro(LocalDate.now());
		cliente = clienteRepository.save(cliente);
		contaService.criarConta(cliente);
		return cliente;

	}

	public void validarCpfCliente(Cliente cliente) {
		if (cliente == null || cliente.getCpfCnp() == null || cliente.getCpfCnp().trim().isEmpty()) {
			throw new RuntimeException("CPF não informado.");
		}
		if (cliente != null && clienteRepository.existsBycpfCnp(cliente.getCpfCnp())) {
			throw new RuntimeException("CPF já cadastrado.");
		}
	}
	
	@Override
	public Cliente buscarPorNome(String nome) {
		return clienteRepository.buscarClientePorNome(nome);
	}
	
	@Override
	public List<Cliente> buscar(String nome, String cpfCnpj) {
		return clienteRepository.buscar(nome, cpfCnpj);
	}

}