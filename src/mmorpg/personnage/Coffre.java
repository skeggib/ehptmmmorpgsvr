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
		this.ajouter(list);
	}
	
	public Coffre(Coffre cof){
		super(cof);
	}
	
	/*
	 * Methode
	 */
	
	public ListeUnique<Item> getContenu(){
		ListeUnique<Item> liste = new ListeUnique<Item>();
		
		for (int i = 0; i < this.getTaille(); i++) {
			liste.add(this.get(i));
		}
		return liste;
	}

	public void ajouter(ListeUnique<Item> list) {
		for (int i = 0; i < list.size(); i++) {
			this.ajouter(list.get(i));
		}
	}

	public int getNumero() {
		return ContenuCase.COFFRE;
	}
}
