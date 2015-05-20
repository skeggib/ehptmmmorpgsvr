package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureFichier;
import mmorpg.personnage.EntiteVivante;

public class Gant extends Vetement {
	public static final String[] NOM = LectureFichier
			.lireT("../ressources/noms/gant.txt");

	public Gant() {
		super();
		this.setNom(this.randNom());
	}

	public Gant(int qualite) {
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

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		super.affecterBonus(utilisateur, cible);
	}

}
