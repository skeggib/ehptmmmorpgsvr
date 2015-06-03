package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureFichier;
import mmorpg.personnage.EntiteVivante;

public class Casque extends Vetement {

	private static final long serialVersionUID = -716294981418221813L;

	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/casque.txt");

	public Casque() {
		this.setNom(this.randNom());
	}

	public Casque(Casque ca) {
		super(ca);
		this.setNom(ca.getNom());
	}

	/*
	 * Methode
	 */

	public Casque clone() {
		return new Casque(this);
	}

	public String randNom() {
		int i = new Random().nextInt((Casque.NOM.length));
		return Casque.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		super.affecterBonus(utilisateur, cible);
	}
}