package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureFichier;
import mmorpg.personnage.EntiteVivante;

public class PotionDeDegat extends Potion {

	/*
	 * Variable
	 */
	
	int malusVie;

	/*
	 * Constantes
	 */

	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/potionDegat.txt");

	public PotionDeDegat() {
		this.setMalusVie(new Random().nextInt(PotionDeDegat.NOM.length) + 1);
		this.setNom(this.randNom());
	}

	/*
	 * Methode
	 */

	public String randNom() {
		return PotionDeSoin.NOM[this.getMalusVie() - 1];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		cible.retirerVie(this.getMalusVie());
		utilisateur.retirerObjet(this);
	}
	
	/*
	 * Methode d'acces
	 */

	public int getMalusVie() {
		return malusVie;
	}

	private void setMalusVie(int malusVie) {
		this.malusVie = malusVie;
	}
}
