package mmorpg.personnage;

import java.io.Serializable;

import mmorpg.items.Equipable;
import mmorpg.items.Item;

/**
 * 
 * Cette Classe permet de gerer l'equipement d'une entite </br> Elle controle
 * qu'il n'y a qu'un seul objet de chaque type (Une entite ne peut porte qu'un
 * seul casque, par exemple)
 * 
 * @author armya
 *
 */
public class Equipement implements ContenirObjets, Serializable {


	private static final long serialVersionUID = -63684723399622813L;

	private ListeUnique<Equipable> equipables;

	/*
	 * Constructeurs
	 */

	public Equipement() {
		this.equipables = new ListeUnique<Equipable>();
	}
	
	public Equipement (Equipement eq){
		this.equipables = new ListeUnique<Equipable>();
		for(int i = 0; i < eq.getTaille(); i++){
			this.ajouter(eq.get(i).clone());
		}
	}

	/*
	 * Methode
	 */

	public Item get(int index) {
		if (index < this.getTaille() && index > -1) {
			return this.equipables.get(index);
		}
		return null;
	}

	public boolean ajouter(Item obj) {
		Equipable eq = (Equipable) obj;
		return this.equipables.add(eq);
	}

	public void ajouter(ListeUnique<Item> list) {
		for (int i = 0; i < this.getTaille(); i++) {
			this.ajouter(list.get(i));
		}
	}

	public boolean retirer(Item o) {
		if (this.equipables.contains(o)) {
			this.equipables.remove(o);
			if (!(this.equipables.contains(o))) {
				return true;
			}
		}
		return false;
	}

	public int getTaille() {
		return this.equipables.size();
	}

	public boolean contient(Item o) {
		return this.equipables.contains(o);
	}
}
