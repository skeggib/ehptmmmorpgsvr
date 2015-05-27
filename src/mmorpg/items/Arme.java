package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureFichier;
import mmorpg.personnage.EntiteVivante;

public class Arme extends Equipable {

	/*
	 * Variable
	 */

	private int maniabilite;
	private int impact;

	/*
	 * Constantes
	 */

	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/arme.txt");

	public Arme() {
		super();

		this.setNom(this.randNom());

		Random rand = new Random();

		switch (this.getQualite()) {
		case 0:
			this.setManiabilite(rand.nextInt(2) + 2);
			this.setImpact(rand.nextInt(2) + 2);
			break;
		case 1:
			this.setManiabilite(rand.nextInt(2) + 3);
			this.setImpact(rand.nextInt(2) + 3);
			break;
		case 2:
			this.setManiabilite(rand.nextInt(3) + 4);
			this.setImpact(rand.nextInt(3) + 4);
			break;
		case 3:
			this.setManiabilite(rand.nextInt(3) + 5);
			this.setImpact(rand.nextInt(3) + 5);
			break;
		case 4:
			this.setManiabilite(rand.nextInt(3) + 6);
			this.setImpact(rand.nextInt(3) + 6);
			break;
		case 5:
			this.setManiabilite(9);
			this.setImpact(9);
			break;
		default:
			break;
		}
	}
	
	public Arme(String nom, int maniabilite, int impact){
		this.setNom(nom);
		this.setManiabilite(maniabilite);
		this.setImpact(impact);
	}

	/*
	 * Methode
	 */

	public String randNom() {
		int i = new Random().nextInt((Arme.NOM.length));
		return Arme.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		cible.getCaractEquip().ajouterManiabilite(this.getManiabilite());
		cible.getCaractEquip().ajouterImpact(this.getImpact());
	}

	/*
	 * Methodes d'acces
	 */

	public int getManiabilite() {
		return maniabilite;
	}

	public void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}

	public int getImpact() {
		return impact;
	}

	public void setImpact(int impact) {
		this.impact = impact;
	}
}
