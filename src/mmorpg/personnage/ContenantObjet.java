package mmorpg.personnage;

import java.io.Serializable;

import mmorpg.items.Item;

/**
 * 
 * La Classe ContenantObjet est la classe mere de toute les classe contenant des objets </br>
 *  - Inventaire </br>
 *  - Coffre </br>
 * 
 * @author armya
 *
 */
public abstract class ContenantObjet implements ContenirObjets, Serializable {

	private static final long serialVersionUID = -2909010841238767244L;
	
	private ListeUnique<Item> listObjet;

	/*
	 * Constructeur
	 */
	public ContenantObjet() {
		this.listObjet = new ListeUnique<Item>();
	}
	
	public ContenantObjet(ContenantObjet cobj){
		this.listObjet = new ListeUnique<Item>();
		for(int i = 0; i < cobj.getTaille(); i++){
			this.ajouter(cobj.get(i).clone());
		}
	}

	/*
	 * Methode
	 */

	public Item get(int index) {
		if (index < this.getTaille() && index > -1) {
			return this.listObjet.get(index);
		}
		return null;
	}

	public boolean ajouter(Item o) {
		return this.listObjet.add(o);
	}

	public void ajouter(ListeUnique<Item> list) {
		for(int i = 0; i < list.size(); i++){
			this.ajouter(list.get(i));
		}
	}

	public boolean retirer(Item o) {
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

	public boolean contient(Item o) {
		
		boolean contient = false;
		int i = 0;
		
		while(!contient && (i < this.getTaille())){
			if(this.get(i) == o){
				contient = true;
			}
			i++;
		}
		return contient;
		
	}
}









