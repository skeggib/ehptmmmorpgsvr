package items;

import fichiers.LectureFichier;

public class Gant extends Vetement {
	public static final String [] NOM = LectureFichier.lire("ressources/noms/gant.txt");

	public Gant () {
		this.setNom(this.randNom());
	}
	
	/*
	 * Methode
	 */
	
	public String randNom () {
		return Gant.NOM[0];
	}

}
