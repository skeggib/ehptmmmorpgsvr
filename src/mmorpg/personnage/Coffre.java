package mmorpg.personnage;

import java.util.ArrayList;

import mmorpg.carte.ContenuCase;
import mmorpg.items.Objet;

/**
 * Cette Classe contient des Objets. </br> Il peut etre rammasser par une
 * EntiteVivante.
 * 
 * @author armya
 *
 */
public class Coffre extends ContenantObjet implements ContenuCase {

	public Coffre() {
		super();
	}

	public Coffre(ListeUnique<Objet> list) {
		super();
		this.ajouterObjets(list);
	}

	public void ajouterObjets(ListeUnique<Objet> list) {
		for (int i = 0; i < this.getTaille(); i++) {
			this.ajouterObjet(list.get(i));
		}
	}
	
	public ListeUnique<Objet> getContenu () {
		
		ListeUnique<Objet> liste = new ListeUnique();
		
		for (int i = 0; i < this.getTaille(); i++) {
			liste.add(this.getObjet(i));
		}
		return liste;
	}

	public int getNumero() {
		return ContenuCase.OBJET; //TODO:skeggib a changer quand tu auras fait ce qu'il faut pour le coffre
	}
}
