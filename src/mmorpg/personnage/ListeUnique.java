package mmorpg.personnage;

import java.util.ArrayList;

public class ListeUnique<E> extends ArrayList<E> {

	private static final long serialVersionUID = 7059645323747881812L;

	public boolean add(E e) {
		if(!this.contains(e)){
			return super.add(e);
		}
		return false;
	}
}
