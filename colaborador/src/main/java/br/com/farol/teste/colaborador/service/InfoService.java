package br.com.farol.teste.colaborador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.farol.teste.colaborador.model.Colaborador;
import br.com.farol.teste.colaborador.repository.ColaboradorRepository;

@Service
public class InfoService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	public Colaborador getInfoColaboradorPorId(long id) {
		return colaboradorRepository.findById(id);
	}
	
	public List<Colaborador> buscarColaboradores() {
		return colaboradorRepository.findAll();
	}
	
}
