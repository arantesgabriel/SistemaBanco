package com.pxt.SistemaBanco.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "gabrielpa.tbcooperacao")
public class Operacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CODOP_SEQ")
	@SequenceGenerator(sequenceName = "CODOP_SEQ", allocationSize = 1, name = "CODOP_SEQ")
	@Column(name = "CODOP")
	private Long codop;
	@Column(name = "TIPOP")
	@Enumerated(EnumType.STRING)
	private TipoOperacao tipop;
	@ManyToOne(targetEntity = Conta.class)
	@JoinColumn(name = "CTAORIGEM", referencedColumnName = "NUMCTA")
	private Conta contaOrigem;
	@ManyToOne(targetEntity = Conta.class)
	@JoinColumn(name = "CTADESTINO", referencedColumnName = "NUMCTA")
	private Conta contaDestino;

	// TO-DO
	// Colocar localdate

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

	public Conta getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(Conta contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public Conta getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(Conta contaDestino) {
		this.contaDestino = contaDestino;
	}

}
