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
			this.ajouterObjet(cobj.getObjet(i).clone());
		}
	}

	/*
	 * Methode
	 */

	public Item getObjet(int index) {
		if (index < this.getTaille() && index > -1) {
			return this.listObjet.get(index);
		}
		return null;
	}

	public boolean ajouterObjet(Item o) {
		return this.listObjet.add(o);
	}

	public void ajouterObjets(ListeUnique<Item> list) {
		for(int i = 0; i < list.size(); i++){
			this.ajouterObjet(list.get(i));
		}
	}

	public boolean retirerObjet(Item o) {
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
			if(this.getObjet(i) == o){
				contient = true;
			}
			i++;
		}
		return contient;
		
	}
}









