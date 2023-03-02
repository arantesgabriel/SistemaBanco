package com.pxt.SistemaBanco.services;

import java.util.List;

import com.pxt.SistemaBanco.domain.dto.BuscaOperacaoDTO;
import com.pxt.SistemaBanco.domain.dto.OperacaoDTO;
import com.pxt.SistemaBanco.exceptions.ContaException;

public interface OperacaoService {

//	public OperacaoDTO efetuarOperacao(OperacaoDTO operacaoDTO);

	public List<BuscaOperacaoDTO> buscar(Long codop);

	OperacaoDTO efetuarOperacao(OperacaoDTO operacaoDTO) throws Exception;

}
