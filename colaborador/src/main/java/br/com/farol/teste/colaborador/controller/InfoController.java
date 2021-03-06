package br.com.farol.teste.colaborador.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

import javax.jms.JMSException;
import javax.naming.NamingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.farol.teste.colaborador.jms.Producer;
import br.com.farol.teste.colaborador.model.Colaborador;
import br.com.farol.teste.colaborador.model.ColaboradorFila;
import br.com.farol.teste.colaborador.model.Status;
import br.com.farol.teste.colaborador.repository.ColaboradorRepository;
import br.com.farol.teste.colaborador.service.InfoService;

@RequiredArgsConstructor
@Controller
@RestController
@RequestMapping("/colaboradores")
public class InfoController {
	
	@Autowired
	private InfoService infoService;
	
	@Autowired
	private Producer producer;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;

	@RequestMapping("/{id}")
	public Colaborador getInfoColaboradorPorId(@PathVariable long id) {
		return infoService.getInfoColaboradorPorId(id);
	}
	
	@GetMapping
	public List<Colaborador> listaColaboradores(){
		return infoService.buscarColaboradores();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void salvarColaborador(@RequestBody Colaborador colaborador) throws JMSException, NamingException {
		colaboradorRepository.save(colaborador);
		ColaboradorFila colab = new ColaboradorFila();
		colab.setNome(colaborador.getNome());
		colab.setId(colaborador.getId());
		producer.send(colab);
	}
	
	@DeleteMapping
	public void deletarColaborador(@RequestBody Colaborador colaborador) {
		colaboradorRepository.delete(colaborador);
		ColaboradorFila colab = new ColaboradorFila();
		colab.setNome(colaborador.getNome());
		colab.setId(colaborador.getId());
		colab.setStatus(Status.INATIVO);
		producer.send(colab);
	}
	
	@PutMapping
	public void atualizarColaborador(@RequestBody Colaborador colaborador) {
		colaboradorRepository.save(colaborador);
		ColaboradorFila colab = new ColaboradorFila();
		colab.setNome(colaborador.getNome());
		colab.setId(colaborador.getId());
		producer.send(colab);
	}
	
	@DeleteMapping("/{id}")
	public void deletarColaboradorPorId(@PathVariable long id, @RequestBody Colaborador colaborador){
		colaboradorRepository.deleteById(id);
		ColaboradorFila colab = new ColaboradorFila();
		colab.setNome(colaborador.getNome());
		colab.setId(id);
		colab.setStatus(Status.INATIVO);
		producer.send(colab);
	}
	
	@PutMapping("/{id}")
	public void atualizarColaboradorPorId(@PathVariable long id, @RequestBody Colaborador colaborador) {
		colaborador.setId(id);
		colaboradorRepository.save(colaborador);
		ColaboradorFila colab = new ColaboradorFila();
		colab.setNome(colaborador.getNome());
		colab.setId(id);
		producer.send(colab);
	}
}
