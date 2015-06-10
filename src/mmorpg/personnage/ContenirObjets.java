package mmorpg.personnage;

import mmorpg.items.Item;

/**
 * 
 * L'interface ContenirObjet contient les methodes necessaires a la gestion d'une liste d'Objet </br>
 * Cette interface est implemente par toutes les classes contenant une liste d'Objet
 * 
 * @author armya
 *
 */
public interface ContenirObjets {

	/**
	 * Renvoie l'objet a l'index indique
	 * 
	 * @param index
	 *            Index de l'objet dans la liste
	 * @return Objet contenu a l'index
	 */
	public Item get(int index);

	/**
	 * Permet d'ajouter un objet a la liste
	 * 
	 * @param o
	 *            Objet a ajouter
	 * @return true si l'objet a ete ajoute, false sinon
	 */
	public boolean ajouter(Item o);

	/**
	 * Permet d'ajouter une liste d'objet a la liste
	 * 
	 * @param o
	 *            Objet a ajouter
	 * @return true si l'objet a ete ajoute, false sinon
	 */
	public void ajouter(ListeUnique<Item> list);

	/**
	 * Permet de retirer un objet de la liste
	 * 
	 * @param o
	 *            Objet a retirer de la liste
	 * @return true si l'objet a ete ajoute, false sinon
	 */
	public boolean retirer(Item o);

	/**
	 * Permet d'avoir la taille de la liste
	 * 
	 * @return int taille de la liste
	 */
	public int getTaille();

	/**
	 * Permet de savoir si la liste contient a certain objet
	 * 
	 * @param o
	 *            Objet a verifier
	 * @return true si l'objet est dans la liste, false sinon
	 */
	public boolean contient(Item o);
}
