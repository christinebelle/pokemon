package projetPokemon.controleur;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import projetPokemon.model.PokemonEntity;
import projetPokemon.model.TypeEntity;
import projetPokemon.repository.PokemonRepository;
import projetPokemon.repository.TypeRepository;


@RestController
@RequestMapping("/api")
public class PokemonControleur {
	
	@Autowired
	private PokemonRepository pokemonRepo;
	
	@Autowired
	private TypeRepository typeRepo;

	@RequestMapping(value="/pokemonPost", method = RequestMethod.POST)
	public ResponseEntity<?> creerPokemon(@RequestBody PokemonEntity pokemon) {
		PokemonEntity newPokemon = null;
		
		//empeche le client de mettre un champ vide car la colone nomPokemon est NOT NULL
		String nomPokemon = pokemon.getNomPokemon();
		if((nomPokemon == null) || (nomPokemon.isEmpty())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le nom du Pokemon !");
		}
		
		newPokemon = pokemonRepo.save(pokemon);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newPokemon);
		
	}
}
