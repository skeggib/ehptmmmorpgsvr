package personnage;

import java.util.ArrayList;

import items.Objet;

public abstract class ContenantObjet implements ContenirObjets {

	private ArrayList<Objet> listObjet;

	/*
	 * Constructeur
	 */
	public ContenantObjet() {
		this.listObjet = new ArrayList<Objet>();
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

	public boolean ajouterObjet(Objet o) {
		if (this.listObjet.contains(o)) {
			return false;
		} else {
			this.listObjet.add(o);
			return true;
		}
	}

	public void ajouterObjets(ArrayList<Objet> list) {
		for(int i = 0; i < this.getTaille(); i++){
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
