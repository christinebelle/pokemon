package projetPokemon.repository;

/**
 * @author christine
 * 
 * @Repository : Repositories sont des interfaces heritant de l'interface Repository.
 * L'objectif de ces interfaces consiste a rendre la creation de la couche d'acces aux donnees (requetes SELECT, UPDATE...) plus rapide.
 * @CrudRepository : interface qui permet de generer les operations CRUD dans un repository pour un certain type.
 */
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projetPokemon.model.Pokemon;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Integer> {
	
	/**
	 * 
	 * @param nomPokemon
	 * @return le Pokemon entree en parametre
	 * 
	 * signature d'une methode utilisant la method du CrudRepo "findById" 
	 * a laquel on change la valeur du parametre
	 */
	public List<Pokemon> findByNomPokemon(String nomPokemon);

}
