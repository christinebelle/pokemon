package projetPokemon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projetPokemon.model.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
	
	//Methode renvoyer dans une collection
	public List<Pokemon> findByNomPokemon(String nomPokemon);

}
