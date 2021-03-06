package br.com.farol.teste.ponto.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farol.teste.ponto.dto.PontoDto;
import br.com.farol.teste.ponto.model.Ponto;
import br.com.farol.teste.ponto.service.PontoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ponto")
public class PontoController {
	
	@Autowired
	private PontoService pontoService;
	
	@PostMapping
	public Ponto registrarPonto(@RequestBody PontoDto ponto) throws Exception {
		
		return pontoService.registraPonto(ponto);
		
	}
	
	
	@GetMapping("/{id_func}")
	public List<Ponto> getByPontosFuncionario(@PathVariable("id_func") Long id) {
		return pontoService.getByPontosFuncionario(id);
	}
	
	
}
