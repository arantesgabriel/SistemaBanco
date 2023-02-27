package com.pxt.SistemaBanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pxt.SistemaBanco.domain.Lancamento;


public interface LancamentoRepository extends JpaRepository<Lancamento, Long> {

	
}
