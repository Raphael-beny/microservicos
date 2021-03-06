package br.com.farol.teste.ponto.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

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
@Entity(name = "Ponto")
@Table(name = "pontos")
public class Ponto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_ponto")
	private Long id;
	
	@Column(name = "id_func")
	private Long id_func;
	
	@NotNull(message = "A data de entrada é obrigatória")
	@Column(name = "data_ponto")
	private LocalDate data;
	
	@NotNull(message = "O horario de entrada é obrigatório")
	@Column(name = "hora_entrada")
	private LocalDateTime entrada;
	
	@NotNull(message = "O horario de saida é obrigatório")
	@Column(name = "hora_saida")
	private LocalDateTime saida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getId_func() {
		return id_func;
	}

	public void setId_func(Long id_func) {
		this.id_func = id_func;
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
