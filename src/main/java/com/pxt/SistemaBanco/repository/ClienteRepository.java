package com.pxt.SistemaBanco.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pxt.SistemaBanco.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	boolean existsBycpfCnp(String cpfCnp);
	
	@Query("SELECT cli FROM Cliente cli WHERE cli.nomeCliente = :nome") //HQL
	Cliente buscarClientePorNome(String nome);


	@Query("SELECT cli FROM Cliente cli WHERE (:nome is null or  cli.nomeCliente like %:nome% ) and (:cpfCnpj is null or cli.cpfCnp = :cpfCnpj)") //HQL
	List<Cliente> buscar(String nome, String cpfCnpj);

}
