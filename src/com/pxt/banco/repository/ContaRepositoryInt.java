package com.pxt.banco.repository;

import com.pxt.banco.domain.Conta;

public interface ContaRepositoryInt {

	public Conta gerarNovaConta(Conta conta);

	public Integer gerarNumeroConta();

}
