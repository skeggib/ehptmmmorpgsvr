package items;

import java.util.Random;

import personnage.EntiteVivante;
import fichiers.LectureFichier;

public class Pantalon extends Vetement {

	/*
	 * Constantes
	 */

	public static final String[] NOM = LectureFichier
			.lireT("../ressources/noms/jambe.txt");

	/*
	 * Constructeur
	 */

	public Pantalon() {
		super();
		this.setNom(this.randNom());
	}

	/*
	 * Methode
	 */

	public String randNom() {
		int i = new Random().nextInt((Pantalon.NOM.length));
		return Pantalon.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		super.affecterBonus(utilisateur, cible);
	}

}
