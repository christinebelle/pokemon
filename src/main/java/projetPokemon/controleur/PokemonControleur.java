package projetPokemon.controleur;

/**
 *
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import projetPokemon.model.Pokemon;
import projetPokemon.repository.PokemonRepository;


@RestController
@RequestMapping("/api")
public class PokemonControleur { 
	
	@Autowired
	private PokemonRepository pokemonRepo;
	
//	@Autowired
//	private TypeRepository typeRepo;
	
	
	/**
	 * Methode qui permet d'ajouter un pokemon
	 * @param pokemon
	 * @return la creation d'un newPokemon
	 */
	@RequestMapping(value="/pokemonPost", method = RequestMethod.POST)
	public ResponseEntity<?> creerPokemon(@RequestBody Pokemon pokemon) {
		Pokemon newPokemon = null;
		
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
	@ResponseBody
	public ResponseEntity<?> affichePokemon() {
		List<Pokemon> listePokemons = null;
		
		listePokemons = (List<Pokemon>) pokemonRepo.findAll();
			
		return ResponseEntity.status(HttpStatus.OK).body(listePokemons);
	}
	
	
	/**      
	 * Méthode qui affiche un pokemon uniquement      
	 * @param nompokemon      
	 * @return un pokemon      
	 */     
	@RequestMapping(value = "/pokemonGet/{nomPokemon}")
	@ResponseBody
	public ResponseEntity<?> recherchePokemon(@PathVariable String nomPokemon) { 
		List<Pokemon> pokemonRecherche = null;                 
		pokemonRecherche = pokemonRepo.findByNomPokemon(nomPokemon);         
		return ResponseEntity.status(HttpStatus.OK).body(pokemonRecherche);    
		}
	
	/**
	 * Méthode qui supprime un pokemon
	 * @param idPokemon
	 * @return null
	 */
	@RequestMapping(value = "/pokemonDelete/{idPokemon}", method = RequestMethod.DELETE)
	public ResponseEntity<?> supprimePokemon(@PathVariable Integer idPokemon) {
		pokemonRepo.deleteById(idPokemon);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
	/**
	 * Méthode qui modifie un pokémon
	 * @param pokemon
	 * @param idPokemon
	 * @return
	 */
	@RequestMapping(value = "/pokemonUpdate/{idPokemon}", method = RequestMethod.PUT)
	public ResponseEntity<?> modifiePokemon(@RequestBody Pokemon pokemon, @PathVariable Integer idPokemon) {
		Pokemon pokemonModifie = null;
		
		String nomPokemon = pokemon.getNomPokemon();
		
		if ((nomPokemon == null) || (nomPokemon.isEmpty())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le nom du pokémon !");
		}
		pokemonModifie = pokemonRepo.save(pokemon);
		
		return ResponseEntity.status(HttpStatus.OK).body(pokemonModifie);
		
	}
	
}
