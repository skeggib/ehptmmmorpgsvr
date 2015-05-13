package items;

import java.util.Random;

import personnage.EntiteVivante;
import fichiers.LectureFichier;

public class PotionDeSoin extends Potion {
	
	/*
	 * Variables
	 */
	
	private int bonusVie;
	
	/*
	 * Constantes
	 */
	
	public static final String [] NOM = LectureFichier.lireT("ressources/noms/potionSoin.txt");


	public PotionDeSoin () {
		this.setNom(this.randNom());
	}
	
	/*
	 * Methode
	 */
	
	public String randNom () {
		int i = new Random().nextInt((PotionDeSoin.NOM.length));
		return PotionDeSoin.NOM[i];
	}

	@Override
	public void affecterBonus(EntiteVivante cible) {
		// TODO Auto-generated method stub
		
	}
}
