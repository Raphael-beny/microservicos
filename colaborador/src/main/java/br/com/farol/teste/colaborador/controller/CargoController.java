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

import br.com.farol.teste.colaborador.model.Cargo;
import br.com.farol.teste.colaborador.repository.CargoRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@GetMapping
	public List<Cargo> listaCargos(){
		return cargoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Cargo buscarCargo(@PathVariable long id){
		return cargoRepository.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cargo salvarCargo(@RequestBody Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	@DeleteMapping
	public void deletarCargo(@RequestBody Cargo cargo) {
		cargoRepository.delete(cargo);
	}
	
	@PutMapping
	public Cargo atualizarCargo(@RequestBody Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	@DeleteMapping("/{id}")
	public void deletarCargoPorId(@PathVariable long id){
		cargoRepository.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Cargo atualizarCargoPorId(@PathVariable long id, @RequestBody Cargo cargo) {
		cargo.setId(id);
		return cargoRepository.save(cargo);
	}
	

}
