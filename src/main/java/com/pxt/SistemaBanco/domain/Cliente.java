package com.pxt.SistemaBanco.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "gabrielpa.tbcocliente")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    @SequenceGenerator(sequenceName = "CODCLI_SEQ", allocationSize = 1, name = "CLIENTE_SEQ")
	@Column(name = "codcli")
	private Integer codigoCliente;
	@Column(name = "nomcli")
	private String nomeCliente;
	@Column(name = "cpfcnp")
	private String cpfCnp;
	@Column(name = "datcad")
	private LocalDate dataCadastro;

	public Cliente() {
		super();
	}

	public Cliente(Integer codigoCliente, String nomeCliente, String cpfCnp) {
		super();
		this.codigoCliente = codigoCliente;
		this.nomeCliente = nomeCliente;
		this.cpfCnp = cpfCnp;
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

	public String getCpfCnp() {
		return cpfCnp;
	}

	public void setCpfCnp(String cpfCnp) {
		this.cpfCnp = cpfCnp;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}
