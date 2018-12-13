package projetPokemon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import projetPokemon.model.Type;

@RepositoryRestResource
public interface TypeRepository extends CrudRepository<Type, Integer>{
	

}
