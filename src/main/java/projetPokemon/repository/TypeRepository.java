package projetPokemon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projetPokemon.model.Type;

@Repository
public interface TypeRepository extends CrudRepository<Type, Integer>{
	

}
