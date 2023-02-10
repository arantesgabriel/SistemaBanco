package com.pxt.banco.services;

import java.math.BigDecimal;

import com.pxt.banco.domain.Conta;
import com.pxt.banco.domain.Lancamentos;

public interface LancamentosService {

	public void efetuarSaque(Conta conta, BigDecimal valorSaque);

	public Lancamentos registrarLancamento(Lancamentos lancamentos);

}
