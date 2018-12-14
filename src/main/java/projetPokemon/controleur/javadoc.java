package projetPokemon.controleur;

public class javadoc {
	/** controleur
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
	 *Si le parametre de methode est Map<String, String> alors, la carte est renseignee avec tous les noms et valeurs de variables de chemin.
	 *
	 *@Autowired : permet l'injection des dependance PokemonRepository
	 *@httpStatus : permet l'implementation des methodes du langage liee au code HTTP
	 *@ResponseEntity :Extension de HttpEntity qui possede aussi un code au statut HttpStatus. 
	 *Utiliser dans RestTemplate il possede aussi les @Controller methods.
	 *Dans RestTemplate, cette classe est retournee par getForEntity()et exchange()
	 *Peut egalement etre utilise dans Spring MVC en tant que valeur de retour d'une methode @Controller
	 *Ou, en utilisant un generateur accessible via des methodes statiques
	 */
	
	/**categorie
	 * @author christine
	 * 
	 * Table de la base de donnee contenant le type des pokemons et leurs attaques
	 *  
	 * @Entity : Specifie que la classe est une entite. 
	 * Cette annotation est appliquee a la classe d'entite.
	 * @GeneratedValue : Fournit la specification pour les valeurs des cles primaires.
	 * @GenerationType : Definit les types de la cle primaire.
	 * @ID : Specifie la cle primaire d'une entite.
	 * @OneToMany : Definit une association à valeurs multiples avec une multiplicite de un a plusieurs.
	 * @Table : Specifie la table primaire pour l'entite annotee.
	 * 
	 * @Serializable : L'interface Serializable n'a pas de methodes ni de champs et sert uniquement a identifier la semantique Serializable.
	 * @HashSet : Cette classe implemente l' interface Set.
	 * @Set : Une collection qui ne contient aucun element en double
	 * 
	 * @JsonIgnore : pertmet d'ignorer la generation du Json de la methode 
	 * ( probleme de boucle infini lie a l'association de valeur multiple depuis l'ID)
	 */

	/**pokemon
	 * @author Christine
	 * 
	 * Table de la base de donnee contenant le nom des pokemons et leurs evolutions
	 * 
	 * @JoinColumn : Specifie une colonne pour rejoindre une association d'entites ou une collection d'elements.
	 * @ManyToOne : Definit une association a une valeur unique avec une autre classe d'entites ayant une multiplicite de plusieurs a un.
	 */
	
	/**repositorypokemon
	 * @author christine
	 * 
	 * @Repository : Repositories sont des interfaces heritant de l'interface Repository.
	 * L'objectif de ces interfaces consiste a rendre la creation de la couche d'acces aux donnees (requetes SELECT, UPDATE...) plus rapide.
	 * @CrudRepository : interface qui permet de generer les operations CRUD dans un repository pour un certain type.
	 */
	/**
	 * 
	 * @param nomPokemon
	 * @return le Pokemon entree en parametre
	 * 
	 * signature d'une methode utilisant la method du CrudRepo "findById" 
	 * a laquel on change la valeur du parametre
	 */
	
	/**application
	 * @author christine
	 * 
	 * @SpringBootApplication : Indique une classe de configuration qui declare une ou plusieurs methodes @Bean et 
	 * declenche egalement la configuration automatique et l'analyse des composants.
	 * @SpringApplication : Classe pouvant etre utilisee pour amorcer et lancer une application Spring à partir d'une methode principale Java. 
	 * Par defaut, la classe effectuera les etapes suivantes pour amorcer votre application:
	 * Creez une ApplicationContextinstance appropriee (en fonction de votre chemin de classe)
	 * Enregistrer un CommandLinePropertySourcepour exposer les arguments de ligne de commande en tant que proprietes Spring
	 * Actualiser le contexte de l'application en chargeant tous les beans singleton
	 * Declencher des CommandLineRunnerharicots
	 */
	
}
