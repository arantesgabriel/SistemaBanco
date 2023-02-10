package com.pxt.banco.repository;

import java.util.List;

import com.pxt.banco.domain.Conta;

public interface ContaRepositoryInt {

	public Conta gerarNovaConta(Conta conta);

	public Integer gerarNumeroConta();
	
	public List <Conta> mostrarContas();

}
