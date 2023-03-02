package com.pxt.SistemaBanco.services.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxt.SistemaBanco.domain.Cliente;
import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.repository.ContaRepository;
import com.pxt.SistemaBanco.services.ContaService;

@Service
public class ContaServiceImpl implements ContaService {

	@Autowired
	private ContaRepository contaCorrenteRepository;

	@Override
	public Conta criarConta(Cliente cliente) {
		Conta conta = new Conta();
		conta.setNumeroConta(contaCorrenteRepository.buscarNumeroContaDisponivel());
		conta.setNumeroDigito(1);
		conta.setNumeroAgencia(1);
		conta.setCliente(cliente);
		conta.setCreditoEspecial(BigDecimal.valueOf(500));
		conta.setSaldoConta(BigDecimal.ZERO);
		conta.setIndicadorAtivo(true);
		return contaCorrenteRepository.save(conta);
	}

	@Override
	public Conta inativarConta(Long numeroConta) {

		Conta conta = contaCorrenteRepository.findById(numeroConta).orElse(null);

		if (conta != null) {

			if (conta.getIndicadorAtivo() != false) {

				conta.setIndicadorAtivo(false);
				return contaCorrenteRepository.save(conta);
			} else
				throw new RuntimeException("A conta digitada já está inativa.");
		} else 
			throw new RuntimeException("Conta digitada é nula, digite uma conta válida.");

	}

}
