package projetPokemon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import projetPokemon.model.PokemonEntity;

public interface PokemonRepository extends CrudRepository<PokemonEntity, Integer> {
	
	//Methode renvoyer dans une collection
	public List<PokemonEntity> findByNom(String nomPokemon);

}
