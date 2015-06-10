package mmorpg.personnage;

import mmorpg.carte.ContenuCase;
import mmorpg.items.Item;

/**
 * Cette Classe contient des Objets. </br> Il peut etre rammasser par une
 * EntiteVivante.
 * 
 * @author armya
 *
 */
public class Coffre extends ContenantObjet implements Ramassable {

	private static final long serialVersionUID = 5780310267728210810L;

	public Coffre() {
		super();
	}

	public Coffre(ListeUnique<Item> list) {
		super();
		this.ajouterObjets(list);
	}
	
	public Coffre(Coffre cof){
		super(cof);
	}
	
	/*
	 * Methode
	 */
	
	public ListeUnique<Item> getListeObjet(){
		ListeUnique<Item> liste = new ListeUnique<Item>();
		
		for (int i = 0; i < this.getTaille(); i++) {
			liste.add(this.getObjet(i));
		}
		return liste;
	}

	public void ajouterObjets(ListeUnique<Item> list) {
		for (int i = 0; i < list.size(); i++) {
			this.ajouterObjet(list.get(i));
		}
	}

	public int getNumero() {
		return ContenuCase.COFFRE;
	}
}
