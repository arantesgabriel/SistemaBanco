package com.pxt.SistemaBanco.services;

import java.util.List;

import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.repository.ContaRepositoryImpl;
import com.pxt.SistemaBanco.repository.ContaRepositoryInt;

public class ContaServiceImpl implements ContaService {

	private ContaRepositoryInt contaRepository = new ContaRepositoryImpl();

	public Conta gerarNovaConta(Conta conta) {
		return contaRepository.gerarNovaConta(conta);
	}

	public Integer gerarNumeroConta() {
		return contaRepository.gerarNumeroConta();
	}
	
	public List <Conta> mostrarContas(){
		return contaRepository.mostrarContas();
	}

}
