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
	
	/**
	 * Supprime un item de l'inventaire
	 * @param item Item a supprimer
	 */
	public void supprimer(Item item){
		if(this.contient(item)){
			this.retirer(item);
		}
	}
}
 