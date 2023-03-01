package com.pxt.SistemaBanco.domain.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

import com.pxt.SistemaBanco.domain.TipoLancamento;

public class LancamentoDTO {

	private Long codlan;
	private TipoLancamento tipoLancamento;
	private Long contaOrigem;
	private Long contaDestino;
	private LocalDateTime datinc;
	private BigDecimal valor;

	public LancamentoDTO() {
		super();
	}

	public LancamentoDTO(Long codlan, TipoLancamento tipoLancamento, Long contaOrigem, Long contaDestino,
			LocalDateTime datinc, BigDecimal valor) {
		super();
		this.codlan = codlan;
		this.tipoLancamento = tipoLancamento;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.datinc = datinc;
		this.valor = valor;
	}

	public Long getCodlan() {
		return codlan;
	}

	public void setCodlan(Long codlan) {
		this.codlan = codlan;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
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

	public LocalDateTime getDatinc() {
		return datinc;
	}

	public void setDatinc(LocalDateTime datinc) {
		this.datinc = datinc;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codlan);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LancamentoDTO other = (LancamentoDTO) obj;
		return Objects.equals(codlan, other.codlan);
	}

}
