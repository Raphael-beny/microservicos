package br.com.farol.teste.colaborador.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;



@Entity
@Table(name = "cargos")
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="cargos_id_seq", sequenceName="cargos_id_seq", allocationSize=1)
	@Column(name="id_cargo")
	private Long id;
	
	@Column(name="descricao_cargo", unique = true, nullable = false)
	@NotEmpty
	private String descricao;
	
	@Column(name="atribuicao_cargo")
	private String atribuicao;
	
	@OneToMany(mappedBy = "cargo")
	private List<Colaborador> colaboradores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getAtribuicao() {
		return atribuicao;
	}

	public void setAtribuicao(String atribuicao) {
		this.atribuicao = atribuicao;
	}
	
	
}
