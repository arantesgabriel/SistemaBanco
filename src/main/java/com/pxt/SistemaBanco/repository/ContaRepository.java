package com.pxt.SistemaBanco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pxt.SistemaBanco.domain.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long>{
	
	@Query("SELECT nvl(MAX(cta.numeroConta),0) + 1 FROM Conta cta")
	public Long buscarNumeroContaDisponivel();

}
