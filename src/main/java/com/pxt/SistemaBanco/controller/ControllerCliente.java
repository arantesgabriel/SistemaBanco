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

import com.pxt.SistemaBanco.domain.Cliente;
import com.pxt.SistemaBanco.domain.Conta;
import com.pxt.SistemaBanco.services.ClienteService;

@RestController
@RequestMapping("/cliente") // terá um /cliente na URL
public class ControllerCliente {

	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<?> salvar(@RequestBody Cliente cliente) {
		try {
			return ResponseEntity.ok(clienteService.cadastrarCliente(cliente));			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro ao cadastrar cliente " + e.getMessage());
		}
	}
	
	@GetMapping
	public List<Cliente> buscar(@RequestParam(name = "nomeCliente", required = false) String nome, 
								@RequestParam(name = "cpfCnp", required = false) String cpfCnpj,
								@RequestParam(name = "dataCadastro", required = false) @DateTimeFormat(iso = ISO.DATE) LocalDate dataCadastro) {
		return clienteService.buscar(nome, cpfCnpj);
	}
	
}
