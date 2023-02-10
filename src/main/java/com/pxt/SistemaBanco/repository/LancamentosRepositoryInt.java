package com.pxt.SistemaBanco.repository;

import java.math.BigDecimal;

import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.domain.Lancamentos;

public interface LancamentosRepositoryInt {

	public void efetuarSaque(Conta conta, BigDecimal valorSaque);

	public Lancamentos registrarLancamento(Lancamentos lancamentos);

}
