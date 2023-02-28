package com.pxt.SistemaBanco.services;

import java.util.List;

import com.pxt.SistemaBanco.domain.Lancamento;
import com.pxt.SistemaBanco.domain.dto.LancamentoDTO;

public interface LancamentoService {

	public List<LancamentoDTO> gerarExtratoFinal (Long numcta);
	
}
