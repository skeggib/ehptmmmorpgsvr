package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureRessource;
import mmorpg.personnage.EntiteVivante;

public class PotionDeDegat extends Potion {

	/*
	 * Variable
	 */
	
	private static final long serialVersionUID = -2082564338739933716L;

	int malusVie;

	/*
	 * Constantes
	 */

	public static final String[] NOM = LectureRessource
			.lire("noms/potionDegat.txt").split("\n");

	public PotionDeDegat() {
		this.setMalusVie(new Random().nextInt(PotionDeDegat.NOM.length) + 1);
		this.setNom(this.randNom());
	}
	
	public PotionDeDegat(PotionDeDegat pdd){
		this.setNom(pdd.getNom());
		this.setMalusVie(pdd.getMalusVie());
	}

	/*
	 * Methode
	 */
	
	public PotionDeDegat clone(){
		return new PotionDeDegat(this);
	}

	public String randNom() {
		return PotionDeDegat.NOM[this.getMalusVie() - 1];
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
