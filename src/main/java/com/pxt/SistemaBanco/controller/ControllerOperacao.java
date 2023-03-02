package com.pxt.SistemaBanco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pxt.SistemaBanco.domain.dto.BuscaOperacaoDTO;
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
			return ResponseEntity.badRequest().body("Erro ao efetuar operação: " + e.getMessage());
		}
	}

	@GetMapping("buscar")
	public List<BuscaOperacaoDTO> buscar(@RequestParam(name = "codop", required = false) Long codigoOperacao) {
		return operacaoService.buscar(codigoOperacao);
	}

}
