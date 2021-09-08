package br.com.farol.teste.ponto.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PontoDto {
	
	private LocalDate data;
	
	private LocalDateTime entrada;
	
	private LocalDateTime saida;
	
	private Long idFuncionario;
	
	

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}
	
	

}
