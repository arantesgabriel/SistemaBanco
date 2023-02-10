package com.pxt.SistemaBanco.services;

import java.math.BigDecimal;

import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.domain.Lancamentos;
import com.pxt.SistemaBanco.repository.LancamentosRepositoryImpl;
import com.pxt.SistemaBanco.repository.LancamentosRepositoryInt;

public class LancamentosServiceImpl implements LancamentosService {

	private LancamentosRepositoryInt lancamentosRepository = new LancamentosRepositoryImpl();

	public void efetuarSaque(Conta conta, BigDecimal valorSaque) {
		lancamentosRepository.efetuarSaque(conta, valorSaque);
	}
	
	public Lancamentos registrarLancamento(Lancamentos lancamentos) {
		return lancamentosRepository.registrarLancamento(lancamentos);
	}

}
