package com.pxt.SistemaBanco.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pxt.SistemaBanco.domain.Lancamento;


public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	@Query("SELECT lan FROM Lancamento lan WHERE lan.conta.numeroConta = :numcta and (lan.dataLancamento >= :dataInicio and lan.dataLancamento < :dataFinal)")
	public List<Lancamento> gerarExtrato (Long numcta, LocalDateTime dataInicio, LocalDateTime dataFinal);
	
}
