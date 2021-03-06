package br.com.farol.teste.ponto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.farol.teste.ponto.client.ColaboradorClient;
import br.com.farol.teste.ponto.dto.InfoColaboradorDto;
import br.com.farol.teste.ponto.dto.PontoDto;
import br.com.farol.teste.ponto.model.Colaborador;
import br.com.farol.teste.ponto.model.Ponto;
import br.com.farol.teste.ponto.model.Status;
import br.com.farol.teste.ponto.repository.ColaboradorRepository;
import br.com.farol.teste.ponto.repository.PontoRepository;

@Service
public class PontoService {

	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ColaboradorClient colaboradorClient;
	
	@Autowired
	private PontoRepository pontoRepository;
	
	public Ponto registraPonto(PontoDto ponto) throws Exception {

		Ponto pontoSalvo = new Ponto();
		
		Colaborador colaborador = colaboradorRepository.getById(ponto.getIdFuncionario());
		
		if (validaAtivos(colaborador)) {
			pontoSalvo.setData(ponto.getData());
			pontoSalvo.setEntrada(ponto.getEntrada());
			pontoSalvo.setSaida(ponto.getSaida());
			pontoSalvo.setId_func(colaborador.getId());
			pontoRepository.save(pontoSalvo);
		}else {
			throw new Exception("Colaborador Inativo");
		}
		return pontoSalvo;
	}

	public Ponto getById(Long id) {
		return pontoRepository.findById(id).orElse(new Ponto());
	}

	public List<Ponto> getByPontosFuncionario(Long id) {
		return pontoRepository.findByPontosPorFuncionario(id);
	}
	
	public InfoColaboradorDto infoColaborador(Long id) {
		return colaboradorClient.getInfoColaboradorPorId(id);
	}
	
	public boolean validaAtivos(Colaborador colaborador) {
		return colaborador.getStatus() == Status.ATIVO;
	}


}
