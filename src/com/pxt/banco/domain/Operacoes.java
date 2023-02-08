package com.pxt.banco.domain;

import java.math.BigDecimal;

public class Operacoes {

	private BigDecimal valorSaque;
	private BigDecimal valorDeposito;

	public Operacoes(BigDecimal valorSaque, BigDecimal valorDeposito) {
		super();
		this.valorSaque = valorSaque;
		this.valorDeposito = valorDeposito;
	}

	public BigDecimal getValorSaque() {
		if (valorSaque == null) {
			valorSaque.equals(BigDecimal.ZERO);
		}
		return valorSaque;
	}

	public void setValorSaque(BigDecimal valorSaque) {
		this.valorSaque = valorSaque;
	}

	public BigDecimal getValorDeposito() {
		if (valorDeposito == null) {
			valorDeposito.equals(BigDecimal.ZERO);
		}
		return valorDeposito;
	}

	public void setValorDeposito(BigDecimal valorDeposito) {
		this.valorDeposito = valorDeposito;
	}

	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorSaque = valorLancamento;
	}

}
