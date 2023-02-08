package com.pxt.banco.services;

import com.pxt.banco.domain.Lancamentos;
import com.pxt.banco.repository.LancamentosRepositoryImpl;
import com.pxt.banco.repository.LancamentosRepositoryInt;

public class LancamentosServiceImpl implements LancamentosService {
	
	private LancamentosRepositoryInt lancamentosRepository = new LancamentosRepositoryImpl();
	
	public Lancamentos efetuarLancamento (Lancamentos lancamentos) {
		return lancamentosRepository.efetuarLancamento(lancamentos);
	}

}
