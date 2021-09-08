package br.com.farol.teste.colaborador.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.farol.teste.colaborador.model.Cargo;


@Repository
public interface CargoRepository  extends JpaRepository<Cargo, Long>{
	Cargo findById(long id);

}
