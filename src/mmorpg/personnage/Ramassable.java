package mmorpg.personnage;

import mmorpg.carte.ContenuCase;
import mmorpg.items.Item;

public interface Ramassable extends ContenuCase{

	/**
	 * Permet d'avoir le contenu de l'interface Ramassable
	 * @return Liste contenant le contenu
	 */
	public ListeUnique<Item> getContenu();
	
}