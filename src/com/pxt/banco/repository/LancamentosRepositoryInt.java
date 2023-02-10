package com.pxt.banco.repository;

import java.math.BigDecimal;

import com.pxt.banco.domain.Conta;
import com.pxt.banco.domain.Lancamentos;

public interface LancamentosRepositoryInt {

	public void efetuarSaque(Conta conta, BigDecimal valorSaque);

	public Lancamentos registrarLancamento(Lancamentos lancamentos);

}
