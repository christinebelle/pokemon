package projetPokemon.model;

/**
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

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="type")
public class Categorie implements Serializable{

	/**
	 * numero de version par default de la classe pour que les ojets generes soit reconnu
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idType;
	private String nomType;
	private String attaqueIm1;
	private String attaqueIm2;
	private String attaqueChar1;
	private String attaqueChar2;
	
	/**
     * relation de la clef etrangere de la table
     * name ="idPokemon"
     */
	@OneToMany(mappedBy="categorie")
	@JsonIgnore
    private Set<Pokemon> pokemons = new HashSet<Pokemon>();

	
	/**
     * constructeur vide
     */
	public Categorie() {
		
	}
	
	public Categorie(Integer idType, String nomType) {
		super();
		this.idType = idType;
		this.nomType = nomType;
	}



	/**
	 * get et set methode
	 */
	public Integer getIdType() {
		return idType;
	}

	public void setIdType(Integer idType) {
		this.idType = idType;
	}

	public String getNomType() {
		return nomType;
	}

	public void setNomType(String nomType) {
		this.nomType = nomType;
	}

	public String getAttaqueIm1() {
		return attaqueIm1;
	}

	public void setAttaqueIm1(String attaqueIm1) {
		this.attaqueIm1 = attaqueIm1;
	}

	public String getAttaqueIm2() {
		return attaqueIm2;
	}

	public void setAttaqueIm2(String attaqueIm2) {
		this.attaqueIm2 = attaqueIm2;
	}

	public String getAttaqueChar1() {
		return attaqueChar1;
	}

	public void setAttaqueChar1(String attaqueChar1) {
		this.attaqueChar1 = attaqueChar1;
	}

	public String getAttaqueChar2() {
		return attaqueChar2;
	}

	public void setAttaqueChar2(String attaqueChar2) {
		this.attaqueChar2 = attaqueChar2;
	}

	public Set<Pokemon> getPokemons() {
		return pokemons;
	}

	public void setPokemons(Set<Pokemon> pokemons) {
		this.pokemons = pokemons;
	}

	/**
	 * hashCode (stocke l'adresse memoire de la recherche) 
	 * et equals (pour comparer deux valeurs) methode
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attaqueChar1 == null) ? 0 : attaqueChar1.hashCode());
		result = prime * result + ((attaqueChar2 == null) ? 0 : attaqueChar2.hashCode());
		result = prime * result + ((attaqueIm1 == null) ? 0 : attaqueIm1.hashCode());
		result = prime * result + ((attaqueIm2 == null) ? 0 : attaqueIm2.hashCode());
		result = prime * result + ((idType == null) ? 0 : idType.hashCode());
		result = prime * result + ((nomType == null) ? 0 : nomType.hashCode());
		result = prime * result + ((pokemons == null) ? 0 : pokemons.hashCode());
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
		Categorie other = (Categorie) obj;
		if (attaqueChar1 == null) {
			if (other.attaqueChar1 != null)
				return false;
		} else if (!attaqueChar1.equals(other.attaqueChar1))
			return false;
		if (attaqueChar2 == null) {
			if (other.attaqueChar2 != null)
				return false;
		} else if (!attaqueChar2.equals(other.attaqueChar2))
			return false;
		if (attaqueIm1 == null) {
			if (other.attaqueIm1 != null)
				return false;
		} else if (!attaqueIm1.equals(other.attaqueIm1))
			return false;
		if (attaqueIm2 == null) {
			if (other.attaqueIm2 != null)
				return false;
		} else if (!attaqueIm2.equals(other.attaqueIm2))
			return false;
		if (idType == null) {
			if (other.idType != null)
				return false;
		} else if (!idType.equals(other.idType))
			return false;
		if (nomType == null) {
			if (other.nomType != null)
				return false;
		} else if (!nomType.equals(other.nomType))
			return false;
		if (pokemons == null) {
			if (other.pokemons != null)
				return false;
		} else if (!pokemons.equals(other.pokemons))
			return false;
		return true;
	}

	

	/**
	 * toString methode pour afficher les variables
	 */
	@Override
	public String toString() {
		return "Type [idType=" + idType + ", nomType=" + nomType + ", attaqueIm1=" + attaqueIm1 + ", attaqueIm2="
				+ attaqueIm2 + ", attaqueChar1=" + attaqueChar1 + ", attaqueChar2=" + attaqueChar2 + ", pokemons="
				+ pokemons + "]";
	}

	
	
	
}
