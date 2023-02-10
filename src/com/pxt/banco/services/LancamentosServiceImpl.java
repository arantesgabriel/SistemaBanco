package com.pxt.banco.services;

import java.math.BigDecimal;

import com.pxt.banco.domain.Conta;
import com.pxt.banco.domain.Lancamentos;
import com.pxt.banco.repository.LancamentosRepositoryImpl;
import com.pxt.banco.repository.LancamentosRepositoryInt;

public class LancamentosServiceImpl implements LancamentosService {

	private LancamentosRepositoryInt lancamentosRepository = new LancamentosRepositoryImpl();

	public void efetuarSaque(Conta conta, BigDecimal valorSaque) {
		lancamentosRepository.efetuarSaque(conta, valorSaque);
	}
	
	public Lancamentos registrarLancamento(Lancamentos lancamentos) {
		return lancamentosRepository.registrarLancamento(lancamentos);
	}

}
