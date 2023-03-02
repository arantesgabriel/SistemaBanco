package com.pxt.SistemaBanco.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pxt.SistemaBanco.domain.dto.ConsultaExtratoDTO;
import com.pxt.SistemaBanco.services.LancamentoService;

@RestController
@RequestMapping("/lancamentos")
public class ControllerLancamento {

	@Autowired
	private LancamentoService lancamentoService;

	@PostMapping("/gerarExtratoFinal")
	public ResponseEntity<?> salvar(@RequestBody ConsultaExtratoDTO entrada) {

		try {

			Long numcta = entrada.getNumeroConta();
			LocalDateTime dataInicio = LocalDateTime.parse(entrada.getDataInicio());
			LocalDateTime dataFinal = LocalDateTime.parse(entrada.getDataFinal());

			dataFinal = dataFinal.plusDays(1);

			return ResponseEntity.ok(lancamentoService.gerarExtratoFinal(numcta, dataInicio, dataFinal));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao gerar extrato: " + e.getSuppressed());
		}
	}

}
