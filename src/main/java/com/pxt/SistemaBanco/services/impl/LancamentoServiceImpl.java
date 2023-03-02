package com.pxt.SistemaBanco.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.domain.Lancamento;
import com.pxt.SistemaBanco.domain.dto.LancamentoDTO;
import com.pxt.SistemaBanco.repository.LancamentoRepository;
import com.pxt.SistemaBanco.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	LancamentoRepository lancamentoRepository;

	public List<LancamentoDTO> gerarExtratoFinal(Long numcta, LocalDateTime dataInicio, LocalDateTime dataFinal) {

		List<LancamentoDTO> lancamentoDTO = new ArrayList<>();
		List<Lancamento> listaLancamentos = lancamentoRepository.gerarExtrato(numcta, dataInicio, dataFinal);

		for (Lancamento lancamento : listaLancamentos) {

			LancamentoDTO novoLancamentoDTO = new LancamentoDTO();

			novoLancamentoDTO.setCodlan(lancamento.getCodigoLancamento());
			novoLancamentoDTO.setTipoLancamento(lancamento.getTipoLancamento());
			novoLancamentoDTO.setDatinc(lancamento.getDataLancamento());
			novoLancamentoDTO.setValor(lancamento.getValorLancamento());
			novoLancamentoDTO.setContaOrigem(lancamento.getConta().getNumeroConta());

			Conta conta = lancamento.getConta();

			if (conta != null) {
				novoLancamentoDTO.setContaDestino(lancamento.getConta().getNumeroConta());
			}

			lancamentoDTO.add(novoLancamentoDTO);

		}

		return lancamentoDTO;

	}

}
