package items;

import java.util.Random;

import personnage.EntiteVivante;
import fichiers.LectureFichier;

public class Arme extends Objet {

	/*
	 * Variable
	 */

	private int maniabilite;
	private int impact;
	private int parade;
	private int bonusForce;

	/*
	 * Constantes
	 */

	public static final String[] NOM = LectureFichier
			.lire("ressources/noms/arme.txt");

	public Arme() {
		this.setNom(this.randNom());
	}

	/*
	 * Methode
	 */

	public String randNom() {
		int i = new Random().nextInt((Arme.NOM.length));
		return Arme.NOM[i];
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

	public int getParade() {
		return parade;
	}

	public void setParade(int parade) {
		this.parade = parade;
	}

	public int getBonusForce() {
		return bonusForce;
	}

	public void setBonusForce(int bonusForce) {
		this.bonusForce = bonusForce;
	}

	@Override
	public void affecterBonus(EntiteVivante cible) {
		// TODO Auto-generated method stub
		
	}
}
