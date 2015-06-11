package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureRessource;
import mmorpg.personnage.EntiteVivante;

public class PotionDeSoin extends Potion {

	/*
	 * Variables
	 */

	private static final long serialVersionUID = 7047803648092557706L;

	private int bonusVie;

	/*
	 * Constantes
	 */

	public static final String[] NOM = PotionDeSoin.chargerNom();

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


	/**
	 * Chargement des noms disponibles pour une potion de soin
	 * @return Tableau de String etant des noms
	 */
	public static String[] chargerNom() {
		try {
			return LectureRessource.lire("noms/potionSoin.txt").split("\n");
		} catch (Exception e) {
			String[] result = {"Potion de soin minime", "Potion de soin", "Potion de soin majeur"}; 
			return result;
		}
	}

	public PotionDeSoin clone() {
		return new PotionDeSoin(this);
	}

	public String randNom() {
		return PotionDeSoin.NOM[this.getBonusVie() - 1];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		if(utilisateur.getPointAction() >= EntiteVivante.PA_UTILISE_POTION){
			utilisateur.setPointAction(utilisateur.getPointAction()
					- EntiteVivante.PA_UTILISE_POTION);
			cible.ajouterVie(this.getBonusVie());
			utilisateur.retirerObjet(this);
		}
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
