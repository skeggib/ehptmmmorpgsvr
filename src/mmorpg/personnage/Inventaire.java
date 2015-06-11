package mmorpg.personnage;

import mmorpg.items.Item;

/**
 * 
 * Cette classe gere l'equipement d'une entite
 * 
 * @author armya
 *
 */
public class Inventaire extends ContenantItems {

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
	
	public void supprimer(Item obj){
		if(this.contient(obj)){
			this.retirer(obj);
		}
	}
}
 