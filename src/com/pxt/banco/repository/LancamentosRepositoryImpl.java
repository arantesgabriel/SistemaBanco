package com.pxt.banco.repository;

import java.util.ArrayList;
import java.util.List;

import com.pxt.banco.domain.Lancamentos;

public class LancamentosRepositoryImpl implements LancamentosRepositoryInt {

	static List<Lancamentos> listaLancamentos = new ArrayList<Lancamentos>();

	public Lancamentos efetuarLancamento(Lancamentos lancamentos) {
		listaLancamentos.add(lancamentos);
		return lancamentos;

	}

}
