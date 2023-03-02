package com.pxt.SistemaBanco.domain;

public enum TipoLancamento {

	C ("CRÉDITO"),
	D ("DÉBITO");

	String descricao;
	
	TipoLancamento(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
