package com.pxt.SistemaBanco.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

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
@Table(name = "GABRIELPA.TBCOLANCAMENTO")
public class Lancamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LANCAMENTO_SEQ")
	@SequenceGenerator(sequenceName = "GABRIELPA.LANCAMENTO_SEQ", allocationSize = 1, name = "LANCAMENTO_SEQ")
	@Column(name = "CODLAN")
	private Long codigoLancamento;
	@ManyToOne
	@JoinColumn(name = "CODOP", referencedColumnName = "CODOP")
	private Operacao operacao;
	@ManyToOne(targetEntity = Conta.class)
	@JoinColumn(name = "NUMCTA", referencedColumnName = "NUMCTA")
	private Conta conta;
	@Column(name = "DATLAN")
	private LocalDateTime dataLancamento;
	@Column(name = "TIPLAN")
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipoLancamento;
	@Column(name = "VLRLAN")
	private BigDecimal valorLancamento;

	public Long getCodigoLancamento() {
		return codigoLancamento;
	}

	public void setCodigoLancamento(Long codigoLancamento) {
		this.codigoLancamento = codigoLancamento;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public LocalDateTime getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDateTime dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public BigDecimal getValorLancamento() {
		if (valorLancamento == null) {
			valorLancamento.equals(BigDecimal.ZERO);
		}
		return valorLancamento;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public void setValorLancamento(BigDecimal valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigoLancamento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(codigoLancamento, other.codigoLancamento);
	}

}
