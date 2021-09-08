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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor 
@NoArgsConstructor 
@Builder
@Entity
@Table(name = "departamentos")
public class Departamento {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="depart_id_seq", sequenceName="depart_id_seq", allocationSize=1)
	@Column(name="id_departamento")
	private Long id;
	
	@Column(name="descricao_departamento", unique = true, nullable = false)
	@NotEmpty
	private String descricao;
	
	@OneToMany(mappedBy = "departamento")
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

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", descricao=" + descricao + ", colaboradores=" + colaboradores + "]";
	}
	
	

}
