package items;

import java.util.Random;

import personnage.EntiteVivante;
import fichiers.LectureFichier;

public class Gant extends Vetement {
	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/gant.txt");

	public Gant() {
		this.setNom(this.randNom());
	}

	/*
	 * Methode
	 */

	public String randNom() {
		int i = new Random().nextInt((Gant.NOM.length));
		return Gant.NOM[i];
	}

	@Override
	public void affecterBonus(EntiteVivante cible) {
		// TODO Auto-generated method stub
		
	}

}
