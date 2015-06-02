package mmorpg.personnage;

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
	
	public Coffre(Coffre cof){
		super(cof);
	}

	public void ajouterObjets(ListeUnique<Objet> list) {
		for (int i = 0; i < list.size(); i++) {
			this.ajouterObjet(list.get(i));
		}
	}
	
	public ListeUnique<Objet> getContenu () {
		
		ListeUnique<Objet> liste = new ListeUnique<Objet>();
		
		for (int i = 0; i < this.getTaille(); i++) {
			liste.add(this.getObjet(i));
		}
		return liste;
	}

	public int getNumero() {
		return ContenuCase.COFFRE;
	}
}
