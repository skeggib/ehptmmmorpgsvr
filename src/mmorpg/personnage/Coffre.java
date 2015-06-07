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
public class Coffre extends ContenantObjet implements ContenuCase, Ramassable {

	private static final long serialVersionUID = 5780310267728210810L;

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
	
	/*
	 * Methode
	 */
	
	public ListeUnique<Objet> getListeObjet(){
		ListeUnique<Objet> liste = new ListeUnique<Objet>();
		
		for (int i = 0; i < this.getTaille(); i++) {
			liste.add(this.getObjet(i));
		}
		return liste;
	}

	public void ajouterObjets(ListeUnique<Objet> list) {
		for (int i = 0; i < list.size(); i++) {
			this.ajouterObjet(list.get(i));
		}
	}
	
	public ListeUnique<Objet> getContenu () { //TODO armya : Enlever quand l'interface Ramassable sera valider
		
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
