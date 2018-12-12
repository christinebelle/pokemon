package projetPokemon.controleur;

/**
 *
 */
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	/**
	 * Methode qui permet d'ajouter un pokemon
	 * @param pokemon
	 * @return la creation d'un newPokemon
	 */
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
	
	/**
	 * Methode qui affiche tous les pokemons
	 * @return liste de pokemon
	 */
	@RequestMapping(value = "/pokemonGetAll", method = RequestMethod.GET)
	public ResponseEntity<?> affichePokemon() {
		Iterable<PokemonEntity> listePokemons = null;
		
		listePokemons = pokemonRepo.findAll();
			
		return ResponseEntity.status(HttpStatus.OK).body(listePokemons);
	}
	
	
	/**      
	 * Méthode qui affiche un pokemon uniquement      
	 * @param nompokemon      
	 * @return un pokemon      
	 */     
	@RequestMapping(value = "/pokemonGet/{nomPokemon}")     
	public ResponseEntity<?> recherchePokemon(@PathVariable String nomPokemon) { 
		List<PokemonEntity> pokemonRecherché = null;                 
		pokemonRecherché = pokemonRepo.findByNom(nomPokemon);         
		return ResponseEntity.status(HttpStatus.OK).body(pokemonRecherché);    
		}
	
	
}
