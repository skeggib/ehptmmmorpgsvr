package items;

import personnage.EntiteVivante;

public class PotionDeDegat extends Potion {
	
	/*
	 * Variables
	 */
	
	private int malusVie;
	
	/*
	 * Constantes
	 */
	
	


	public PotionDeDegat () {
		this.setNom(this.randNom());
	}
	
	/*
	 * Methode
	 */
	
	public String randNom () {
		return Arme.NOM[0]; //TODO Trouver des noms de potions de degats a mettre dans un .txt
	}

	@Override
	public void affecterBonus(EntiteVivante cible) {
		// TODO Auto-generated method stub
		
	}
}
