package com.pxt.SistemaBanco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pxt.SistemaBanco.services.impl.ContaServiceImpl;

@RestController
@RequestMapping ("/conta")
public class ControllerConta {
	
	@Autowired
	private ContaServiceImpl contaCorrenteServiceImpl;
	
	@PutMapping("/inativar/{numeroConta}")
	public ResponseEntity<?> inativarConta (@PathVariable Long numeroConta){
		try {
			return ResponseEntity.ok(contaCorrenteServiceImpl.inativarConta(numeroConta));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao inativar conta: " + e.getMessage());
		}
	}

}
