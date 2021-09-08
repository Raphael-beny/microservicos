package br.com.farol.teste.colaborador.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.farol.teste.colaborador.model.Departamento;

@Repository
public interface DepartamentoRepository  extends JpaRepository<Departamento, Long>{
	Departamento findById(long id);

}
