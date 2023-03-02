package com.pxt.SistemaBanco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pxt.SistemaBanco.domain.Operacao;

public interface OperacaoRepository extends JpaRepository<Operacao, Long> {
	
	@Query("SELECT op FROM Operacao op WHERE op.codop = :codop")
	List <Operacao> buscar (Long codop);

}
