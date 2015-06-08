package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureRessource;
import mmorpg.personnage.EntiteVivante;

public class Torse extends Vetement {

	private static final long serialVersionUID = -6459569773295966695L;

	public static final String[] NOM = LectureRessource
			.lire("noms/torse.txt").split("\n");

	public Torse() {
		this.setNom(this.randNom());
	}

	public Torse(Torse to) {
		super(to);
		this.setNom(to.getNom());
	}

	public Torse clone() {
		return new Torse(this);
	}

	public String randNom() {
		int i = new Random().nextInt((Torse.NOM.length));
		return Torse.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		super.affecterBonus(utilisateur, cible);
	}

}
