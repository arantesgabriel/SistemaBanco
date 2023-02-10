package com.pxt.SistemaBanco.domain;

import java.math.BigDecimal;

public class Conta {

	private Cliente cliente;
	private Integer numeroAgencia;
	private Integer numeroConta;
	private BigDecimal saldoConta;

	public Conta(Cliente cliente, Integer numeroConta, BigDecimal saldoConta) {
		super();
		this.cliente = cliente;
		this.numeroAgencia = 1;
		this.numeroConta = numeroConta;
		this.saldoConta = saldoConta;

	}

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public Integer getNumeroConta() {
		return numeroConta;
	}

	public void setSaldoConta(BigDecimal saldoConta) {
		this.saldoConta = saldoConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public void setNumeroConta(Integer numeroConta) {
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSaldoConta() {
		if (saldoConta == null) {
			saldoConta.equals(BigDecimal.ZERO);
		}
		return saldoConta;
	}

}
