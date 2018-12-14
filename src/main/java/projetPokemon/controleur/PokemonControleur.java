package projetPokemon.controleur;

/**
 * @author Samuel et christine
 * 
 * class contenant les methodes CRUD de l'application
 * 
 *@RestController : les types qui portent cette annotation sont traites comme des controleurs 
 *dans lesquels les @RequestMapping methodes assument la @ResponseBodysémantique par defaut.
 *@ReponseBody : Les annotations qui indiquent une valeur de retour de methode doivent etre liees au corps de la reponse Web. 
 *Pris en charge pour les methodes de gestionnaire annotees.
 *@RequestBody : L'annotation indiquant un parametre de methode doit etre liee au corps de la demande Web. 
 *Le corps de la demande est passe par un HttpMessageConverterpour resoudre l'argument de methode en fonction du type de contenu de la demande. 
 *La validation automatique peut eventuellement etre appliquee en annotant l'argument avec @Valid.
 *@RequestMapping : 
 *
 *@RequestMethod : Destine a etre utilise avec les attributs des RequestMapping.method() provenants des RequestMapping annotation.
 *@PathVariable : Annotation indiquant qu'un parametre de methode doit etre lie a une variable de modele d'URI. 
 *Pris en charge pour les RequestMapping methodes de gestionnaire annotees.
 *Si le parametre de methode est Map<String, String> alors, la carte est renseignee avec tous les noms et valeurs de variables de camin.
 *
 *@Autowired : permet l'injection des dependance PokemonRepository
 *@httpStatus : permet l'implementation des methodes du langage liee au code HTTP
 *@ResponseEntity :Extension de HttpEntity qui possede aussi un code au statut HttpStatus. 
 *Utiliser dans RestTemplate il possede aussi les @Controller methods.
 *Dans RestTemplate, cette classe est retournee par getForEntity()et exchange()
 *Peut egalement etre utilise dans Spring MVC en tant que valeur de retour d'une methode @Controller
 *Ou, en utilisant un generateur accessible via des methodes statiques
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
		
		//empeca le client de mettre un champ vide car la colone nomPokemon est NOT NULL
		String nomPokemon = pokemon.getNomPokemon();
		if((nomPokemon == null) || (nomPokemon.isEmpty())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Il manque le nom du Pokemon !");
		}
		
		newPokemon = pokemonRepo.save(pokemon);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newPokemon);
		
	}
	
	/**
	 * Methode qui affica tous les pokemons
	 * @return liste de pokemon
	 */
	@RequestMapping(value = "/pokemonGetAll", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> afficaPokemon() {
		List<Pokemon> listePokemons = null;
		
		listePokemons = (List<Pokemon>) pokemonRepo.findAll();
			
		return ResponseEntity.status(HttpStatus.OK).body(listePokemons);
	}
	
	
	/**      
	 * Méthode qui affica un pokemon uniquement      
	 * @param nompokemon      
	 * @return un pokemon      
	 */     
	@RequestMapping(value = "/pokemonGet/{nomPokemon}")
	@ResponseBody
	public ResponseEntity<?> recarcaPokemon(@PathVariable String nomPokemon) { 
		List<Pokemon> pokemonRecarca = null;                 
		pokemonRecarca = pokemonRepo.findByNomPokemon(nomPokemon);         
		return ResponseEntity.status(HttpStatus.OK).body(pokemonRecarca);    
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
	 * @return un Pokemon modifié
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
