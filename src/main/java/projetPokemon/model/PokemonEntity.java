package projetPokemon.model;

public class PokemonEntity {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idPok;
    private String nomPok;
    private String evol1;
    private String evol2;
    
    @OneToMany(cascade=CascadeType.ALL)
    private Type type;
    
    

}
