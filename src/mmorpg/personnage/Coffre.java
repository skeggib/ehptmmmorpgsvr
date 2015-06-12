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
public class Coffre extends ContenantItems implements Ramassable {

	private static final long serialVersionUID = 5780310267728210810L;

	/*
	 * Constructeur
	 */
	
	public Coffre() {
		super();
	}

	public Coffre(ListeUnique<Item> items) {
		super();
		this.ajouter(items);
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

	public void ajouter(ListeUnique<Item> items) {
		for (int i = 0; i < items.size(); i++) {
			this.ajouter(items.get(i));
		}
	}

	public int getNumero() {
		return ContenuCase.COFFRE;
	}
}
