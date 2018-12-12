package projetPokemon.model;

/**
 * @author Christine
 * Table de la base de donnée contenant le nom des pokemons et leurs évolutions
 */

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class PokemonEntity implements Serializable {
	
    /**
	 * numero de version par default de la classe pour que les ojets generes soit reconnu
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer idPokemon;
    private String nomPokemon;
    private String nomEvol1;
    private String nomEvol2;
    
    /**
     * relation de la clef etrangere de la table
     * mappedBy="idType"
     */
    @OneToMany(mappedBy="idType", cascade=CascadeType.REMOVE)
    private Set<TypeEntity> types = new HashSet<TypeEntity>();
    
    /**
     * constructeur vide
     */
	public PokemonEntity() {
		
	}

	/**
	 * get et set methode
	 */
	public Integer getIdPokemon() {
		return idPokemon;
	}

	public void setIdPokemon(Integer idPokemon) {
		this.idPokemon = idPokemon;
	}

	public String getNomPokemon() {
		return nomPokemon;
	}

	public void setNomPokemon(String nomPokemon) {
		this.nomPokemon = nomPokemon;
	}

	public String getNomEvol1() {
		return nomEvol1;
	}

	public void setNomEvol1(String nomEvol1) {
		this.nomEvol1 = nomEvol1;
	}

	public String getNomEvol2() {
		return nomEvol2;
	}

	public void setNomEvol2(String nomEvol2) {
		this.nomEvol2 = nomEvol2;
	}

	public Set<TypeEntity> getTypes() {
		return types;
	}

	public void setTypes(Set<TypeEntity> types) {
		this.types = types;
	}
	

	/**
	 * hashCode (stocke l'adresse memoire de la recherche) 
	 * et equals (pour comparer deux valeurs) methode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPokemon == null) ? 0 : idPokemon.hashCode());
		result = prime * result + ((nomEvol1 == null) ? 0 : nomEvol1.hashCode());
		result = prime * result + ((nomEvol2 == null) ? 0 : nomEvol2.hashCode());
		result = prime * result + ((nomPokemon == null) ? 0 : nomPokemon.hashCode());
		result = prime * result + ((types == null) ? 0 : types.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PokemonEntity other = (PokemonEntity) obj;
		if (idPokemon == null) {
			if (other.idPokemon != null)
				return false;
		} else if (!idPokemon.equals(other.idPokemon))
			return false;
		if (nomEvol1 == null) {
			if (other.nomEvol1 != null)
				return false;
		} else if (!nomEvol1.equals(other.nomEvol1))
			return false;
		if (nomEvol2 == null) {
			if (other.nomEvol2 != null)
				return false;
		} else if (!nomEvol2.equals(other.nomEvol2))
			return false;
		if (nomPokemon == null) {
			if (other.nomPokemon != null)
				return false;
		} else if (!nomPokemon.equals(other.nomPokemon))
			return false;
		if (types == null) {
			if (other.types != null)
				return false;
		} else if (!types.equals(other.types))
			return false;
		return true;
	}

	
	/**
	 * toString methode pour afficher les variables
	 */
	@Override
	public String toString() {
		return "PokemonEntity [idPokemon=" + idPokemon + ", nomPokemon=" + nomPokemon + ", nomEvol1=" + nomEvol1
				+ ", nomEvol2=" + nomEvol2 + ", types=" + types + "]";
	}

	
	 

}
