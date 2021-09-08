package br.com.farol.teste.ponto.dto;

import br.com.farol.teste.ponto.model.Status;

public class InfoColaboradorDto {
	
	private Long id;
	
	private String nome;
	
	private Status status;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	


}
