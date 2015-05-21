package mmorpg.personnage;

import mmorpg.items.Arme;
import mmorpg.items.Equipable;
import mmorpg.items.Objet;

/**
 * 
 * Cette Classe permet de gerer l'equipement d'une entite </br>
 * Elle controle qu'il n'y a qu'un seul objet de chaque type (Une entite ne peut porte qu'un seul casque, par exemple)
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
		if (obj instanceof Equipable) {
			Equipable eq = (Equipable) obj;
			if (!this.listObjet.contains(eq)) {
				if (eq instanceof Arme) {
					Arme a = (Arme) eq;
					int nombreArmeEquipe = 0;
					for (int i = 0; i < this.listObjet.size(); i++) {
						if (this.listObjet.get(i).getClass() == a.getClass()) {
							nombreArmeEquipe++;
						}
					}
					if (nombreArmeEquipe < 2) {
						this.listObjet.add(a);
						return true;
					}
				} else {
					boolean dejaEquipe = false;
					for (int i = 0; i < this.listObjet.size(); i++) {
						if (this.listObjet.get(i).getClass() == eq.getClass()) {
							dejaEquipe = true;
						}
					}
					if (!dejaEquipe) {
						this.listObjet.add(eq);
						return true;
					}
				}
			}
			return false;
		}
		return false;
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