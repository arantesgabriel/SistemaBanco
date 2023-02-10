package com.pxt.SistemaBanco.services;

import java.math.BigDecimal;

import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.domain.Lancamentos;

public interface LancamentosService {

	public void efetuarSaque(Conta conta, BigDecimal valorSaque);

	public Lancamentos registrarLancamento(Lancamentos lancamentos);

}
