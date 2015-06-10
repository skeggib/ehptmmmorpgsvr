package mmorpg.personnage;

import mmorpg.carte.ContenuCase;
import mmorpg.items.Item;

public interface Ramassable extends ContenuCase{

	public ListeUnique<Item> getContenu();
	
}