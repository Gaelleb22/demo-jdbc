package fr.diginamic.jdbc.entites;

/**Représente un fournisseur
 * @author formation
 *
 */
public class Fournisseur {
	
	/** numéro identifiant */
	private int id;
	/** nom du fournisseur */
	private String nom;
	
	/** Constructeur
	 * @param id
	 * @param nom
	 */
	public Fournisseur(int id, String nom) {
		this.id = id;
		this.nom = nom;
	}
	
	
	
	@Override
	public String toString() {
		return "Fournisseur " + id +" = "+ nom;
	}



	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

}
