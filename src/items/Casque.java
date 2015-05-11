package items;

import fichiers.LectureFichier;

public class Casque extends Vetement {
	public static final String [] NOM = LectureFichier.lire("ressources/noms/casque.txt");

	public Casque () {
		this.setNom(this.randNom());
	}
	
	/*
	 * Methode
	 */
	
	public String randNom () {
		return Casque.NOM[0];
	}
}