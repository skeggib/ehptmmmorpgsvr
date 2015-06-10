package mmorpg.personnage;

import java.util.ArrayList;

/**
 * 
 * Cette Classe permet la gestion d'une liste ayant pour particularite de ne
 * posséder qu'une reference par objet </br> On ne peut trouver de doublon dans
 * cette liste
 * 
 * @author armya
 *
 * @param <E>
 *            Type d'Object contenu dans la liste
 */
public class ListeUnique<E> extends ArrayList<E> {

	private static final long serialVersionUID = 7059645323747881812L;

	/**
	 * Redefinition de la methode add de ArrayList 
	 * pour qu'elle ne contient une seul reference de chaque objet
	 */
	public boolean add(E e) {
		
		boolean contient = false;
		
		int i = 0;
		while(!contient && i < this.size()){
			if(this.get(i) == e){
				contient = true;
			}
			i++;
		}
		
		if (!contient) {
			return super.add(e);
		}
		return false;
	}
}
