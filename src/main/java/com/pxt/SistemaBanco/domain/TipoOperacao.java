package com.pxt.SistemaBanco.domain;

public enum TipoOperacao {
	
	SQ ("SAQUE"),
	DP ("DEPÓSITO"),
	TF ("TRANSFERÊNCIA");
	
	String descricao;
	
	TipoOperacao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
