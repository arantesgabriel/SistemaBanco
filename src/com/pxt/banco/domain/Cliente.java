package com.pxt.banco.domain;

import java.time.LocalDate;

public class Cliente {

	private Integer codigoCliente;
	private String nomeCliente;
	private String cpfCliente;
	private LocalDate dataCadastro;
	//teste github
	
	public Cliente(Integer codigoCliente, String nomeCliente, String cpfCliente, LocalDate dataCadastro) {
		super();
		this.codigoCliente = codigoCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.dataCadastro = dataCadastro;
	}

	public Integer getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Integer codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
