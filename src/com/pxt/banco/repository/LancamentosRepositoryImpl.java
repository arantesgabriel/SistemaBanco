package com.pxt.banco.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.pxt.banco.domain.Conta;
import com.pxt.banco.domain.Lancamentos;

public class LancamentosRepositoryImpl implements LancamentosRepositoryInt {

	static List<Lancamentos> listaLancamentos = new ArrayList<Lancamentos>();

	public void efetuarSaque(Conta conta, BigDecimal valorSaque) {
		conta.setSaldoConta(conta.getSaldoConta().subtract(valorSaque));

	}

	public Lancamentos registrarLancamento(Lancamentos lancamentos) {
		listaLancamentos.add(lancamentos);
		return lancamentos;

	}

}
