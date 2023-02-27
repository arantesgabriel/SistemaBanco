package com.pxt.SistemaBanco.services;

import java.util.List;

import com.pxt.SistemaBanco.domain.Lancamento;

public interface LancamentoService {

	public List<Lancamento> gerarExtrato(Long numcta);

}
