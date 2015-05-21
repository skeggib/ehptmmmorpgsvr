package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureFichier;
import mmorpg.personnage.EntiteVivante;

public class Torse extends Vetement{
	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/torse.txt");

	public String randNom() {
		int i = new Random().nextInt((Torse.NOM.length));
		return Torse.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		super.affecterBonus(utilisateur, cible);
	}

}
