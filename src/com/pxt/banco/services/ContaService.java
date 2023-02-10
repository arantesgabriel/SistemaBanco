package com.pxt.banco.services;

import java.util.List;

import com.pxt.banco.domain.Conta;

public interface ContaService {

	public Conta gerarNovaConta(Conta conta);

	public Integer gerarNumeroConta();
	
	public List <Conta> mostrarContas();

}
