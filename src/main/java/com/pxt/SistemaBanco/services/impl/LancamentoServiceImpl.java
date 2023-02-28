package com.pxt.SistemaBanco.services.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxt.SistemaBanco.domain.Lancamento;
import com.pxt.SistemaBanco.domain.TipoLancamento;
import com.pxt.SistemaBanco.domain.dto.LancamentoDTO;
import com.pxt.SistemaBanco.repository.LancamentoRepository;
import com.pxt.SistemaBanco.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {

	@Autowired
	LancamentoRepository lancamentoRepository;

	public List<LancamentoDTO> gerarExtratoFinal(Long numcta) {

		List<LancamentoDTO> lancamentoDTO = new ArrayList<>();
		List<Lancamento> listaLancamentos = lancamentoRepository.gerarExtrato(numcta);

		for (Lancamento lancamento : listaLancamentos) {

			if (lancamento.getOperacao().getContaDestino() == null) {

				Long codlan = lancamento.getCodigoLancamento();
				TipoLancamento tiplan = lancamento.getTipoLancamento();
				Long contaOrigem = lancamento.getOperacao().getContaOrigem().getNumeroConta();
				LocalDateTime datinc = lancamento.getDataLancamento();
				BigDecimal valor = lancamento.getValorLancamento();
				LancamentoDTO novoLancamento = new LancamentoDTO(codlan, tiplan, contaOrigem, null, datinc, valor);
				lancamentoDTO.add(novoLancamento);

			} else {

				Long codlan = lancamento.getCodigoLancamento();
				TipoLancamento tiplan = lancamento.getTipoLancamento();
				Long contaOrigem = lancamento.getOperacao().getContaOrigem().getNumeroConta();
				Long contaDestino = lancamento.getOperacao().getContaDestino().getNumeroConta();
				LocalDateTime datinc = lancamento.getDataLancamento();
				BigDecimal valor = lancamento.getValorLancamento();
				LancamentoDTO novoLancamento = new LancamentoDTO(codlan, tiplan, contaOrigem, contaDestino, datinc, valor);
				lancamentoDTO.add(novoLancamento);
			}
		}

		return lancamentoDTO;

	}
}
