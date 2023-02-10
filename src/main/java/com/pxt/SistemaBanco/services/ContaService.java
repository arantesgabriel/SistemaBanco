package com.pxt.SistemaBanco.services;

import java.util.List;

import com.pxt.SistemaBanco.domain.Conta;

public interface ContaService {

	public Conta gerarNovaConta(Conta conta);

	public Integer gerarNumeroConta();
	
	public List <Conta> mostrarContas();

}
