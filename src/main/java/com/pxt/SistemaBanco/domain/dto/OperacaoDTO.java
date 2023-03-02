package com.pxt.SistemaBanco.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.pxt.SistemaBanco.domain.TipoOperacao;

public class OperacaoDTO {

	private Long codop;
	private TipoOperacao tipop;
	private LocalDateTime datinc;
	private Long contaOrigem;
	private Long contaDestino;
	private BigDecimal valor;

	public Long getCodop() {
		return codop;
	}

	public void setCodop(Long codop) {
		this.codop = codop;
	}

	public TipoOperacao getTipop() {
		return tipop;
	}

	public void setTipop(TipoOperacao tipop) {
		this.tipop = tipop;
	}

	public LocalDateTime getDatinc() {
		return datinc;
	}

	public void setDatinc(LocalDateTime datinc) {
		this.datinc = datinc;
	}

	public Long getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Long contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Long getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Long contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OperacaoDTO other = (OperacaoDTO) obj;
		return Objects.equals(codop, other.codop);
	}

}