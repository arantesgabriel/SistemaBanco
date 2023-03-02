package com.pxt.SistemaBanco.domain.dto;

import java.util.Objects;

import com.pxt.SistemaBanco.domain.TipoOperacao;

public class BuscaOperacaoDTO {

	private Long codop;
	private TipoOperacao tipop;
	private Long contaOrigem;
	private Long contaDestino;

	public BuscaOperacaoDTO() {
		super();
	}

	public BuscaOperacaoDTO(Long codop, TipoOperacao tipop, Long contaOrigem, Long contaDestino) {
		super();
		this.codop = codop;
		this.tipop = tipop;
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
	}

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
		BuscaOperacaoDTO other = (BuscaOperacaoDTO) obj;
		return Objects.equals(codop, other.codop);
	}

}
