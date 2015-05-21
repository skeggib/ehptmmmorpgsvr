package personnage;

import items.Objet;

/**
 * 
 * La Classe ContenantObjet est la classe mere de toute les classe contenant des objets </br>
 *  - Inventaire </br>
 *  - Coffre </br>
 * 
 * @author armya
 *
 */
public abstract class ContenantObjet implements ContenirObjets {

	private ListeUnique<Objet> listObjet;

	/*
	 * Constructeur
	 */
	public ContenantObjet() {
		this.listObjet = new ListeUnique<Objet>();
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
		return this.listObjet.add(o);
	}

	public void ajouterObjets(ListeUnique<Objet> list) {
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
