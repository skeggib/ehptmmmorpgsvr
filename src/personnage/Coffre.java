package personnage;

import items.Objet;

import java.util.ArrayList;
import java.util.LinkedList;

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
