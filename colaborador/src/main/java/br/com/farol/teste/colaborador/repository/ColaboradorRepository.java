package br.com.farol.teste.colaborador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.farol.teste.colaborador.model.Colaborador;

@Repository
public interface ColaboradorRepository  extends JpaRepository<Colaborador, Long>{
	Colaborador findById(long id);

}
