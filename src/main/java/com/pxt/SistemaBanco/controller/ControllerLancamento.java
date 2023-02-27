package com.pxt.SistemaBanco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pxt.SistemaBanco.domain.Lancamento;
import com.pxt.SistemaBanco.services.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class ControllerLancamento {

	@Autowired
	private LancamentoService lancamentoService;

	@GetMapping
	public List<Lancamento> gerarExtrato(@RequestParam("numcta") Long numcta) {
		return lancamentoService.gerarExtrato(numcta);
	}

}
