package br.com.farol.teste.ponto.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor 
@NoArgsConstructor 
@Builder
@Entity(name = "Colaborador")
@Table(name = "colaboradores")
public class Colaborador {

	@Id
	@Column(name="id_func")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private Status status = Status.ATIVO;
	
	
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
