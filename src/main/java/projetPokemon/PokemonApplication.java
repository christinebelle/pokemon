package projetPokemon;

/**
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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PokemonApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonApplication.class, args);
	}
}
