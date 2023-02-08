package com.pxt.banco.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Lancamentos {

	private Conta conta;
	private LocalDate dataLancamento;
	private String descricaoLancamento;
	private BigDecimal valorLancamento;
	private TipoLancamento tipoLancamento;

	public Lancamentos(LocalDate dataLancamento, BigDecimal valorLancamento, String descricaoLancamento) {
		super();
		this.dataLancamento = dataLancamento;
		this.valorLancamento = valorLancamento;
		this.descricaoLancamento = descricaoLancamento;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public BigDecimal getValorLancamento() {
		if (valorLancamento == null) {
			valorLancamento.equals(BigDecimal.ZERO);
		}
		return valorLancamento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public String getDescricaoLancamento() {
		return descricaoLancamento;
	}

	public void setDescricaoLancamento(String descricaoLancamento) {
		this.descricaoLancamento = descricaoLancamento;
	}

}
