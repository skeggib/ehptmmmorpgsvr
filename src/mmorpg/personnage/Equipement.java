package mmorpg.personnage;

import mmorpg.items.Arme;
import mmorpg.items.Equipable;
import mmorpg.items.Objet;

/**
 * 
 * Cette Classe permet de gerer l'equipement d'une entite </br> Elle controle
 * qu'il n'y a qu'un seul objet de chaque type (Une entite ne peut porte qu'un
 * seul casque, par exemple)
 * 
 * @author armya
 *
 */
public class Equipement implements ContenirObjets {

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

	public Objet getObjet(int index) {
		if (index < this.getTaille() && index > -1) {
			return this.listObjet.get(index);
		}
		return null;
	}

	public boolean ajouterObjet(Objet obj) {
		Equipable eq = (Equipable) obj;
		return this.listObjet.add(eq);
	}

	public void ajouterObjets(ListeUnique<Objet> list) {
		for (int i = 0; i < this.getTaille(); i++) {
			this.ajouterObjet(list.get(i));
		}
	}

	public boolean retirerObjet(Objet o) {
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

	public boolean contient(Objet o) {
		return this.listObjet.contains(o);
	}
}
