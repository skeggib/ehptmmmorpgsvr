package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureFichier;
import mmorpg.personnage.EntiteVivante;

public class Casque extends Vetement {
	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/casque.txt");

	public Casque() {
		this.setNom(this.randNom());
	}
	
	public Casque(Casque ca){
		super(ca);
		this.setNom(ca.getNom());
	}

	/*
	 * Methode
	 */

	public String randNom() {
		int i = new Random().nextInt((Casque.NOM.length));
		return Casque.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		super.affecterBonus(utilisateur, cible);
	}
}