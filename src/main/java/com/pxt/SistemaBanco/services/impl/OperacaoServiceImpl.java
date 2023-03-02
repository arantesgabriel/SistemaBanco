package com.pxt.SistemaBanco.services.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.domain.Lancamento;
import com.pxt.SistemaBanco.domain.Operacao;
import com.pxt.SistemaBanco.domain.TipoLancamento;
import com.pxt.SistemaBanco.domain.TipoOperacao;
import com.pxt.SistemaBanco.domain.dto.BuscaOperacaoDTO;
import com.pxt.SistemaBanco.domain.dto.OperacaoDTO;
import com.pxt.SistemaBanco.exceptions.ContaException;
import com.pxt.SistemaBanco.repository.ContaRepository;
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
	private ContaRepository contaCorrenteRepository;

	@Override
	public OperacaoDTO efetuarOperacao(OperacaoDTO operacaoDTO) throws ContaException {

		Conta contaOrigem = contaCorrenteRepository.findById(operacaoDTO.getContaOrigem()).orElse(null);

		if (contaOrigem.getIndicadorAtivo() == true) {

			if (TipoOperacao.SQ.equals(operacaoDTO.getTipop())) {
				efetuarSaque(operacaoDTO);
			}

			else if (TipoOperacao.DP.equals(operacaoDTO.getTipop())) {
				efetuarDeposito(operacaoDTO);
			}

			else if (TipoOperacao.TF.equals(operacaoDTO.getTipop())) {
				efetuarTransferencia(operacaoDTO);
			}
		} else {
			throw new ContaException("A conta informada está inativa.");
		}

		return operacaoDTO;
	}

	public OperacaoDTO efetuarSaque(OperacaoDTO operacaoDTO) throws ContaException {

		// Instanciação dos atributos conta origem do objeto Conta.
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

		return operacaoDTO;

	}

	public OperacaoDTO efetuarDeposito(OperacaoDTO operacaoDTO) throws ContaException {

		// Instanciação do atributo conta origem do objeto Conta.
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

		return operacaoDTO;

	}

	public OperacaoDTO efetuarTransferencia(OperacaoDTO operacaoDTO) throws ContaException {

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

		operacaoDTO.setCodop(operacaoTransferencia.getCodop());
		operacaoDTO.setDatinc(LocalDateTime.now());
		operacaoDTO.setTipop(operacaoTransferencia.getTipop());

		return operacaoDTO;

	}

	public List<BuscaOperacaoDTO> buscar(Long codigoOperacao) {

		List<BuscaOperacaoDTO> buscaOperacaoDTO = new ArrayList<>();
		List<Operacao> listaOperacoes = operacaoRepository.buscar(codigoOperacao);

		for (Operacao operacao : listaOperacoes) {

			Long codop = operacao.getCodop();
			TipoOperacao tipop = operacao.getTipop();
			Long contaOrigem = operacao.getContaOrigem().getNumeroConta();
			Long contaDestino = operacao.getContaDestino().getNumeroConta();

			BuscaOperacaoDTO novaOperacao = new BuscaOperacaoDTO(codop, tipop, contaOrigem, contaDestino);
			buscaOperacaoDTO.add(novaOperacao);

		}

		return buscaOperacaoDTO;

	}

}
