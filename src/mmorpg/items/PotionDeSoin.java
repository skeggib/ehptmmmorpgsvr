package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureFichier;
import mmorpg.personnage.EntiteVivante;

public class PotionDeSoin extends Potion {

	/*
	 * Variables
	 */

	private int bonusVie;

	/*
	 * Constantes
	 */

	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/potionSoin.txt");

	public PotionDeSoin() {
		this.setBonusVie(new Random().nextInt(PotionDeSoin.NOM.length) + 1);
		this.setNom(this.randNom());
	}

	public PotionDeSoin(PotionDeSoin pds) {
		this.setBonusVie(pds.getBonusVie());
		this.setNom(pds.getNom());
	}

	/*
	 * Methode
	 */
	
	public PotionDeSoin clone(){
		return new PotionDeSoin(this);
	}

	public String randNom() {
		return PotionDeSoin.NOM[this.getBonusVie() - 1];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		utilisateur.setPointAction(utilisateur.getPointAction()
				- EntiteVivante.PA_UTILISE_POTION);
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
