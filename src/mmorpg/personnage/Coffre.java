package mmorpg.personnage;

import java.util.ArrayList;

import mmorpg.items.Objet;

/**
 * Cette Classe contient des Objets. </br>
 * Il peut etre rammasser par une EntiteVivante.
 * 
 * @author armya
 *
 */
public class Coffre extends ContenantObjet {

	public Coffre() {
		super();
	}

	public Coffre(ArrayList<Objet> list) {
		super();
		this.ajouterObjets(list);
	}

	public void ajouterObjets(ArrayList<Objet> list) {
		for (int i = 0; i < this.getTaille(); i++) {
			this.ajouterObjet(list.get(i));
		}
	}
}
