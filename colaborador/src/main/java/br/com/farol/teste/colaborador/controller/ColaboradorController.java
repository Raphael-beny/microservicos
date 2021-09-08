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
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.farol.teste.colaborador.model.Colaborador;
import br.com.farol.teste.colaborador.repository.ColaboradorRepository;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/colaboradores")
public class ColaboradorController {
	
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@GetMapping
	public List<Colaborador> listaColaboradores(){
		return colaboradorRepository.findAll();
	}
	

	@GetMapping("/{id}")
	public Colaborador buscarColaborador(@PathVariable long	id){
		return colaboradorRepository.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Colaborador salvarColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorRepository.save(colaborador);
	}
	
	@DeleteMapping
	public void deletarColaborador(@RequestBody Colaborador colaborador) {
		colaboradorRepository.delete(colaborador);
	}
	
	@PutMapping
	public Colaborador atualizarColaborador(@RequestBody Colaborador colaborador) {
		return colaboradorRepository.save(colaborador);
	}
	
	@DeleteMapping("/{id}")
	public void deletarColaboradorPorId(@PathVariable long id){
		colaboradorRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Colaborador atualizarColaboradorPorId(@PathVariable long id, @RequestBody Colaborador colaborador) {
		colaborador.setId(id);
		return colaboradorRepository.save(colaborador);
	}
	
}
