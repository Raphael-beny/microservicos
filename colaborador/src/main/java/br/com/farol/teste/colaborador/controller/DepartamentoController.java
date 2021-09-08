package br.com.farol.teste.colaborador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.farol.teste.colaborador.model.Departamento;
import br.com.farol.teste.colaborador.repository.DepartamentoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	@GetMapping
	public List<Departamento> listaDepartamentos(){
		return departamentoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Departamento buscarDepartamento(@PathVariable long id){
		return departamentoRepository.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Departamento salvarDepartamento(@RequestBody Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	@DeleteMapping
	public void deletarDepartamento(@RequestBody Departamento departamento) {
		departamentoRepository.delete(departamento);
	}
	
	@PutMapping
	public Departamento atualizarDepartamento(@RequestBody Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	
	@DeleteMapping("/{id}")
	public void deletarDepartamentoPorId(@PathVariable long id){
		departamentoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Departamento atualizarDepartamentoPorId(@PathVariable long id, @RequestBody Departamento departamento) {
		departamento.setId(id);
		return departamentoRepository.save(departamento);
	}


}
