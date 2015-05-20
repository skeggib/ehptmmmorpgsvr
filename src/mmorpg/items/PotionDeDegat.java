package mmorpg.items;

import java.util.Random;

import mmorpg.personnage.EntiteVivante;

public class PotionDeDegat extends Potion {
	
	/*
	 * Variables
	 */
	
	private int malusVie;
	

	/*
	 * Constructeurs
	 */
	
	public PotionDeDegat () {
		this.setNom(this.randNom());
		this.setMalusVie(new Random().nextInt(2) + 1);
	}
	
	/*
	 * Methode
	 */
	
	public String randNom () {
		return Arme.NOM[0]; // TODO:armya Trouver des noms de potions de degats a mettre dans un .txt
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
