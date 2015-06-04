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

	public boolean add(E e) {
		if (!this.contains(e)) { // TODO:armya Fait gaffe avec contains...
			return super.add(e);
		}
		return false;
	}
}
