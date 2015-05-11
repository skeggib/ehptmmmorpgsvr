package items;

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
		return Arme.NOM[0];
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
}
