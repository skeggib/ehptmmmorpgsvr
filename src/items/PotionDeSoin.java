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

	public static final String[] NOM = LectureFichier
			.lireT("../ressources/noms/potionSoin.txt");

	public PotionDeSoin() {
		this.setBonusVie(new Random().nextInt(PotionDeSoin.NOM.length) + 1);
		this.setNom(this.randNom());
	}

	/*
	 * Methode
	 */

	public String randNom() {
		return PotionDeSoin.NOM[this.getBonusVie() - 1];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		cible.ajouterVie(this.getBonusVie());
		utilisateur.retirerObjet(this);
	}

	/*
	 * Methode d'acces
	 */

	public int getBonusVie() {
		return bonusVie;
	}

	public void setBonusVie(int bonusVie) {
		this.bonusVie = bonusVie;
	}
}
