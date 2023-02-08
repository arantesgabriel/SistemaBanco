package com.pxt.banco.services;

import com.pxt.banco.domain.Conta;

public interface ContaService {

	public Conta gerarNovaConta (Conta conta);
	public Integer gerarNumeroConta();

}
