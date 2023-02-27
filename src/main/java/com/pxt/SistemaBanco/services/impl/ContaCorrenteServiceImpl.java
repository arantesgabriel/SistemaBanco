package com.pxt.SistemaBanco.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxt.SistemaBanco.domain.Cliente;
import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.repository.ContaCorrenteRepository;
import com.pxt.SistemaBanco.services.ContaCorrenteService;

@Service
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	@Override
	public Conta criarConta(Cliente cliente) {
		Conta conta = new Conta();
		conta.setNumeroConta(contaCorrenteRepository.buscarNumeroContaDisponivel());
		conta.setNumeroDigito(1);
		conta.setNumeroAgencia(1);
		conta.setCliente(cliente);
		conta.setCreditoEspecial(BigDecimal.valueOf(500));
		conta.setSaldoConta(BigDecimal.ZERO);
		return contaCorrenteRepository.save(conta);
	}

}
