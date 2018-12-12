package projetPokemon.repository;

import org.springframework.data.repository.CrudRepository;

import projetPokemon.model.PokemonEntity;

public interface PokemonRepository extends CrudRepository<PokemonEntity, Integer> {

}
