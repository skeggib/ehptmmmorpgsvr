package items;

import java.util.Random;

import personnage.EntiteVivante;
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
		int i = new Random().nextInt((Casque.NOM.length));
		return Casque.NOM[i];
	}

	@Override
	public void affecterBonus(EntiteVivante cible) {
		// TODO Auto-generated method stub
		
	}
}