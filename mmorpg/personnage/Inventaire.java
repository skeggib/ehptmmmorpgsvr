package mmorpg.personnage;

/**
 * 
 * Cette classe gere l'equipement d'une entite
 * 
 * @author armya
 *
 */
public class Inventaire extends ContenantObjet {

	private static final long serialVersionUID = -2173272356083879117L;
	
	/*
	 * Constructeurs
	 */

	public Inventaire() {
		super();
	}
	
	public Inventaire(Inventaire inv){
		super(inv);
	}
}
 