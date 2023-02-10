package com.pxt.SistemaBanco.repository;

import java.util.List;

import com.pxt.SistemaBanco.domain.Conta;

public interface ContaRepositoryInt {

	public Conta gerarNovaConta(Conta conta);

	public Integer gerarNumeroConta();
	
	public List <Conta> mostrarContas();

}
