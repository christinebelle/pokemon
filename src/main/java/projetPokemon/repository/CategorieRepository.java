package projetPokemon.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import projetPokemon.model.Categorie;

@Repository
public interface CategorieRepository extends CrudRepository<Categorie, Integer>{
	

}
