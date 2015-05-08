package items;

public abstract class Objet {
	
	/* 
	 * Variable
	 */

	private String nom;
	
	/*
	 * Constructeur
	 */

	public Objet () {
		
	}
	
	/*
	 * Methode d'acces
	 */

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
