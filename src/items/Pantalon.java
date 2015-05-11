package items;

import fichiers.LectureFichier;

public class Pantalon extends Vetement {

	/*
	 * Constantes
	 */

	public static final String[] NOM = LectureFichier
			.lire("ressources/noms/jambe.txt");

	/*
	 * Constructeur
	 */

	public Pantalon() {
		this.setNom(this.randNom());
	}

	/*
	 * Methode
	 */

	public String randNom() {
		return Pantalon.NOM[0];
	}

}
