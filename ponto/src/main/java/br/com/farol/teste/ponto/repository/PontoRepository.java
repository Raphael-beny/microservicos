package br.com.farol.teste.ponto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.farol.teste.ponto.model.Ponto;

@Repository
public interface PontoRepository extends JpaRepository<Ponto, Long>{

	@Query("SELECT p "
	        + "FROM Ponto p "
	        + "WHERE p.id_func =:id")
	List<Ponto> findByPontosPorFuncionario(Long id);

}
