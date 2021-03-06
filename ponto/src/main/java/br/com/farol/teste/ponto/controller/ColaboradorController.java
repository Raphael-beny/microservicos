package br.com.farol.teste.ponto.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farol.teste.ponto.model.Colaborador;
import br.com.farol.teste.ponto.repository.ColaboradorRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/colab")
public class ColaboradorController {
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@GetMapping("/{id_func}")
	public Colaborador getById(@PathVariable("id_func") long id) {
		return colaboradorRepository.findById(id);
	}

}
