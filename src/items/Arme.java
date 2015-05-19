package items;

import java.util.Random;

import personnage.EntiteVivante;
import fichiers.LectureFichier;

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
			.lireT("../ressources/noms/arme.txt");

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

	/*
	 * Methode
	 */

	public String randNom() {
		int i = new Random().nextInt((Arme.NOM.length));
		return Arme.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		utilisateur.setManiabiliteArm(utilisateur.getManiabiliteArm() + this.getManiabilite());
		utilisateur.setImpactArm(utilisateur.getImpactArm() + this.getImpact());
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
