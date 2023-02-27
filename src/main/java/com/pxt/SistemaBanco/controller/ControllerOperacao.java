package com.pxt.SistemaBanco.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pxt.SistemaBanco.domain.Operacao;
import com.pxt.SistemaBanco.domain.dto.OperacaoDTO;
import com.pxt.SistemaBanco.services.OperacaoService;

@RestController
@RequestMapping("/operacao")
public class ControllerOperacao {

	@Autowired
	private OperacaoService operacaoService;

	@PostMapping("efetuar")
	public ResponseEntity<?> salvar(@RequestBody OperacaoDTO operacaoDTO) {
		try {
			return ResponseEntity.ok(operacaoService.efetuarOperacao(operacaoDTO));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao efetuar Operação: " + e.getMessage());
		}
	}

	@GetMapping
	public List<Operacao> buscar(@RequestParam(name = "codop", required = false) Long codop,
								 @RequestParam(name = "dataCadastro", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate dataCadastro) {
		return operacaoService.buscar(codop);
	}

}
