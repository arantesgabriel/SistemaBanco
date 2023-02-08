package com.pxt.banco.services;

import com.pxt.banco.domain.Conta;
import com.pxt.banco.repository.ContaRepositoryImpl;
import com.pxt.banco.repository.ContaRepositoryInt;

public class ContaServiceImpl implements ContaService {

	private ContaRepositoryInt contaRepository = new ContaRepositoryImpl();

	public Conta gerarNovaConta(Conta conta) {
		return contaRepository.gerarNovaConta(conta);
	}

	public Integer gerarNumeroConta() {
		return contaRepository.gerarNumeroConta();
	}

}
