package com.pxt.SistemaBanco.services;

import java.time.LocalDateTime;
import java.util.List;

import com.pxt.SistemaBanco.domain.dto.LancamentoDTO;

public interface LancamentoService {

	public List<LancamentoDTO> gerarExtratoFinal (Long numcta, LocalDateTime dataInicio, LocalDateTime dataFinal);
	
}
