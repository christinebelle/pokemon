package projetPokemon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import projetPokemon.model.Pokemon;

@RepositoryRestResource
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
	
	//Methode renvoyer dans une collection
	public List<Pokemon> findByNomPokemon(String nomPokemon);

}
