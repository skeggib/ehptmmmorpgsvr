package items;

import fichiers.LectureFichier;

public class PotionDeSoin extends Potion {
	
	/*
	 * Variables
	 */
	
	private int bonusVie;
	
	/*
	 * Constantes
	 */
	
	public static final String [] NOM = LectureFichier.lire("ressources/noms/potionSoin.txt");


	public PotionDeSoin () {
		this.setNom(this.randNom());
	}
	
	/*
	 * Methode
	 */
	
	public String randNom () {
		return PotionDeSoin.NOM[0];
	}
}
