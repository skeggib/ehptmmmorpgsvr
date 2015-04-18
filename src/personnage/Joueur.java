package personnage;

import items.Casque;
import items.Pantalon;
import items.Torse;

public class Joueur extends EntiteVivante {
	
	private String pointAction;
	
	private int exp;
	
	private Casque casque;
	private Pantalon pantalon;
	private Torse torse;
	/**
	 * Gere la facon dont attaque un joueur
	 */
	public void attaquer () {
		System.out.println(((EntiteVivante) this.getCible()).getCaracteristique().getAdresse());
	}
	
}

