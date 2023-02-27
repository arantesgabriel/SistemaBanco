package com.pxt.SistemaBanco.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pxt.SistemaBanco.domain.Lancamento;
import com.pxt.SistemaBanco.repository.LancamentoRepository;
import com.pxt.SistemaBanco.services.LancamentoService;

@Service
public class LancamentoServiceImpl implements LancamentoService {
	
	@Autowired
	LancamentoRepository lancamentoRepository;

	public List<Lancamento> gerarExtrato (Long numcta){
		return lancamentoRepository.gerarExtrato(numcta);
	}
	
}
