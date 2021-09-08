package br.com.farol.teste.ponto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.farol.teste.ponto.model.Colaborador;

public interface ColaboradorRepository extends JpaRepository<Colaborador, Long>{
	Colaborador findById(long id);

}
