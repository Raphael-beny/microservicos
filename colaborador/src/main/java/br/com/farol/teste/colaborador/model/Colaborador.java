package br.com.farol.teste.colaborador.model;

import java.util.Date;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;




@Entity (name = "Colaborador")
@Table(name = "colaboradores")
public class Colaborador {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name="colab_id_seq", sequenceName="colab_id_seq", allocationSize=1)
	@Column(name="id_colab")
	private Long id;
	
	@Column(name="nome_colab", nullable = false)
	@NotEmpty
	private String nome;
	
	@Column(name = "cpf_colab", unique = true, nullable = false)
	@NotEmpty
	private String cpf;
	
	@Column(name="data_admissao_colab", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataAdmissao = new Date();
	
	@Column(name="rg_colab", nullable = false)
	@NotEmpty
	private String rg;
	
	@Column(name="nome_da_mae_colab", nullable = false)
	@NotEmpty
	private String nomeDaMae;
	
	@ManyToOne
	@JoinColumn(name = "id_cargo", nullable = false)
	@NotNull
	private Cargo cargo;
	
	@ManyToOne
	@JoinColumn(name = "id_departamento", nullable = false)
	@NotNull
	private Departamento departamento;
	
	//@OneToMany(mappedBy = "colaborador", fetch = FetchType.LAZY)
	//private List<Ponto> pontos;
	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	//public List<Ponto> getPontos() {
	//	return pontos;
	//}

	//public void setPontos(List<Ponto> pontos) {
	//	this.pontos = pontos;
	//}

	
	
}
