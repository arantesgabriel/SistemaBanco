package com.pxt.SistemaBanco.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.domain.Lancamento;
import com.pxt.SistemaBanco.domain.Operacao;
import com.pxt.SistemaBanco.domain.TipoLancamento;
import com.pxt.SistemaBanco.domain.TipoOperacao;
import com.pxt.SistemaBanco.domain.dto.OperacaoDTO;
import com.pxt.SistemaBanco.repository.ContaCorrenteRepository;
import com.pxt.SistemaBanco.repository.LancamentoRepository;
import com.pxt.SistemaBanco.repository.OperacaoRepository;
import com.pxt.SistemaBanco.services.OperacaoService;

@Service
public class OperacaoServiceImpl implements OperacaoService {

	@Autowired
	private LancamentoRepository lancamentoRepository;

	@Autowired
	private OperacaoRepository operacaoRepository;

	@Autowired
	private ContaCorrenteRepository contaCorrenteRepository;

	@Override
	public OperacaoDTO efetuarOperacao(OperacaoDTO operacaoDTO) {
		if (TipoOperacao.SQ.equals(operacaoDTO.getTipop())) {

			Conta contaOrigem = contaCorrenteRepository.findById(operacaoDTO.getContaOrigem()).get();

			contaOrigem.subtrairSaldo(operacaoDTO.getValor());

			Operacao operacaoSaque = new Operacao();
			operacaoSaque.setContaOrigem(contaOrigem);
			operacaoSaque.setTipop(TipoOperacao.SQ);
			operacaoSaque = operacaoRepository.save(operacaoSaque);

			Lancamento lancamentoSaque = new Lancamento();
			lancamentoSaque.setConta(contaOrigem);
			lancamentoSaque.setTipoLancamento(TipoLancamento.D);
			lancamentoSaque.setDataLancamento(LocalDateTime.now());
			lancamentoSaque.setValorLancamento(operacaoDTO.getValor());
			lancamentoSaque.setOperacao(operacaoSaque);
			lancamentoRepository.save(lancamentoSaque);

			operacaoDTO.setCodop(operacaoSaque.getCodop());
			operacaoDTO.setDatinc(LocalDateTime.now());
			operacaoDTO.setTipop(operacaoSaque.getTipop());

		}

		if (TipoOperacao.DP.equals(operacaoDTO.getTipop())) {

			Conta contaOrigem = contaCorrenteRepository.findById(operacaoDTO.getContaOrigem()).get();

			contaOrigem.addSaldo(operacaoDTO.getValor());

			Operacao operacaoDeposito = new Operacao();
			operacaoDeposito.setTipop(TipoOperacao.DP);
			operacaoDeposito.setContaOrigem(contaOrigem);
			operacaoDeposito = operacaoRepository.save(operacaoDeposito);

			Lancamento lancamentoDeposito = new Lancamento();
			lancamentoDeposito.setConta(contaOrigem);
			lancamentoDeposito.setTipoLancamento(TipoLancamento.C);
			lancamentoDeposito.setDataLancamento(LocalDateTime.now());
			lancamentoDeposito.setValorLancamento(operacaoDTO.getValor());
			lancamentoDeposito.setOperacao(operacaoDeposito);
			lancamentoRepository.save(lancamentoDeposito);

			operacaoDTO.setCodop(operacaoDeposito.getCodop());
			operacaoDTO.setDatinc(LocalDateTime.now());
			operacaoDTO.setTipop(operacaoDeposito.getTipop());

		}

		if (TipoOperacao.TF.equals(operacaoDTO.getTipop())) {

			// Instanciação dos atributos conta origem e destino do objeto Conta.
			Conta contaOrigem = contaCorrenteRepository.findById(operacaoDTO.getContaOrigem()).get();
			Conta contaDestino = contaCorrenteRepository.findById(operacaoDTO.getContaDestino()).get();

			// Execução dos métodos de subtração do valor da conta origem e adição do valor
			// transferido à conta destino.
			contaOrigem.subtrairSaldo(operacaoDTO.getValor());
			contaDestino.addSaldo(operacaoDTO.getValor());

			// Instanciação do objeto Operação
			Operacao operacaoTransferencia = new Operacao();

			operacaoTransferencia.setTipop(TipoOperacao.TF);
			operacaoTransferencia.setContaOrigem(contaOrigem);
			operacaoTransferencia.setContaDestino(contaDestino);
			operacaoTransferencia = operacaoRepository.save(operacaoTransferencia);

			Lancamento lancamentoTFDebito = new Lancamento();

			lancamentoTFDebito.setConta(contaOrigem);
			lancamentoTFDebito.setTipoLancamento(TipoLancamento.D);
			lancamentoTFDebito.setDataLancamento(LocalDateTime.now());
			lancamentoTFDebito.setValorLancamento(operacaoDTO.getValor());
			lancamentoTFDebito.setOperacao(operacaoTransferencia);
			lancamentoRepository.save(lancamentoTFDebito);

			Lancamento lancamentoTFCredito = new Lancamento();

			lancamentoTFCredito.setConta(contaDestino);
			lancamentoTFCredito.setTipoLancamento(TipoLancamento.C);
			lancamentoTFCredito.setDataLancamento(LocalDateTime.now());
			lancamentoTFCredito.setValorLancamento(operacaoDTO.getValor());
			lancamentoTFCredito.setOperacao(operacaoTransferencia);
			lancamentoRepository.save(lancamentoTFCredito);

		}

		return operacaoDTO;
	}

	public List<Operacao> buscar(Long codop) {
		return operacaoRepository.buscar(codop);

	}

}
