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

	private ListeUnique<Equipable> listObjet;

	/*
	 * Constructeurs
	 */

	public Equipement() {
		this.listObjet = new ListeUnique<Equipable>();
	}
	
	public Equipement (Equipement eq){
		this.listObjet = new ListeUnique<Equipable>();
		for(int i = 0; i < eq.getTaille(); i++){
			this.ajouterObjet(eq.getObjet(i).clone());
		}
	}

	/*
	 * Methode
	 */

	public Item getObjet(int index) {
		if (index < this.getTaille() && index > -1) {
			return this.listObjet.get(index);
		}
		return null;
	}

	public boolean ajouterObjet(Item obj) {
		Equipable eq = (Equipable) obj;
		return this.listObjet.add(eq);
	}

	public void ajouterObjets(ListeUnique<Item> list) {
		for (int i = 0; i < this.getTaille(); i++) {
			this.ajouterObjet(list.get(i));
		}
	}

	public boolean retirerObjet(Item o) {
		if (this.listObjet.contains(o)) {
			this.listObjet.remove(o);
			if (!(this.listObjet.contains(o))) {
				return true;
			}
		}
		return false;
	}

	public int getTaille() {
		return this.listObjet.size();
	}

	public boolean contient(Item o) {
		return this.listObjet.contains(o);
	}
}
