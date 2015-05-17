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
	
	public Gant(int qualite){
		super(qualite);
		this.setNom(this.randNom());
	}

	/*
	 * Methode
	 */

	public String randNom() {
		int i = new Random().nextInt((Gant.NOM.length));
		return Gant.NOM[i];
	}

	public void affecterBonus(EntiteVivante cible) {
		// TODO:armya Auto-generated method stub
		
	}

}
