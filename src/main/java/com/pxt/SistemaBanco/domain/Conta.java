package com.pxt.SistemaBanco.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "gabrielpa.tbcoconta")
public class Conta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTA_SEQ")
    @SequenceGenerator(sequenceName = "NUMCTA_SEQ", allocationSize = 1, name = "CONTA_SEQ")
	@Column(name = "NUMCTA")
	private Long numeroConta;
	@Column(name = "NUMDIG")
	private Integer numeroDigito;
	@Column(name = "NUMAGE")
	private Integer numeroAgencia;
	@Column(name = "VLRSLD")
	private BigDecimal saldoConta;
	@Column(name = "VLRCREESP")
	private BigDecimal creditoEspecial;

//	Forma errada
//	@Column(name = "CPFCNP")
//	private Cliente cliente;

	@ManyToOne(targetEntity = Cliente.class)
	@JoinColumn(name = "CODCLI", referencedColumnName = "CODCLI")
	private Cliente cliente;

	public Integer getNumeroAgencia() {
		return numeroAgencia;
	}

	public void setNumeroAgencia(Integer numeroAgencia) {
		this.numeroAgencia = numeroAgencia;
	}

	public Long getNumeroConta() {
		return numeroConta;
	}

	public Integer getNumeroDigito() {
		return numeroDigito;
	}

	public void setNumeroDigito(Integer numeroDigito) {
		this.numeroDigito = numeroDigito;
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

	public void setNumeroConta(Long numeroConta) {
		this.numeroConta = numeroConta;
	}

	public BigDecimal getSaldoConta() {
		if (saldoConta == null) {
			saldoConta.equals(BigDecimal.ZERO);
		}
		return saldoConta;
	}

	public BigDecimal getCreditoEspecial() {
		return creditoEspecial;
	}

	public void setCreditoEspecial(BigDecimal creditoEspecial) {
		this.creditoEspecial = creditoEspecial;
	}

	public void addSaldo(BigDecimal valor) {
		if (getSaldoConta().add(valor).compareTo(getCreditoEspecial().multiply(BigDecimal.valueOf(-1))) < 0) {
			throw new RuntimeException(
					"O valor desejado deixará seu saldo de Crédito Especial negativo, tente outro valor.");
		}
		getSaldoConta().add(valor);
	}

}
