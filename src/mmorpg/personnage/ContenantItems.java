package mmorpg.personnage;

import java.io.Serializable;

import mmorpg.items.Item;

/**
 * 
 * La Classe ContenantObjet est la classe mere de toute les classe contenant des objets </br>
 *  - Inventaire </br>
 *  - Coffre </br>
 * 
 * @author armya
 *
 */
public abstract class ContenantItems implements ContenirItems, Serializable {

	private static final long serialVersionUID = -2909010841238767244L;
	
	private ListeUnique<Item> items;

	/*
	 * Constructeur
	 */
	public ContenantItems() {
		this.items = new ListeUnique<Item>();
	}
	
	public ContenantItems(ContenantItems cObj){
		this.items = new ListeUnique<Item>();
		for(int i = 0; i < cObj.getTaille(); i++){
			this.ajouter(cObj.get(i).clone());
		}
	}

	/*
	 * Methode
	 */

	public Item get(int index) {
		if (index < this.getTaille() && index > -1) {
			return this.items.get(index);
		}
		return null;
	}

	public boolean ajouter(Item o) {
		return this.items.add(o);
	}

	public void ajouter(ListeUnique<Item> items) {
		for(int i = 0; i < items.size(); i++){
			this.ajouter(items.get(i));
		}
	}

	public boolean retirer(Item o) {
		if (this.items.contains(o)) {
			this.items.remove(o);
			if (!(this.items.contains(o))) {
				return true;
			}
		}
		return false;
	}

	public int getTaille() {
		return this.items.size();
	}

	public boolean contient(Item o) {
		
		boolean contient = false;
		int i = 0;
		
		while(!contient && (i < this.getTaille())){
			if(this.get(i) == o){
				contient = true;
			}
			i++;
		}
		return contient;
		
	}
}









