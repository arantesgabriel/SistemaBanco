package com.pxt.SistemaBanco.services;

import com.pxt.SistemaBanco.domain.Cliente;
import com.pxt.SistemaBanco.domain.Conta;

public interface ContaCorrenteService {

	Conta criarConta(Cliente cliente);

	Conta inativarConta(Long numeroConta);

}
