package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureRessource;
import mmorpg.personnage.EntiteVivante;

public class Gant extends Vetement {

	private static final long serialVersionUID = 8982478495592136422L;

	public static final String[] NOM = Gant.chargerNom();

	public Gant() {
		super();
		this.setNom(this.randNom());
	}

	public Gant(int qualite) {
		super(qualite);
		this.setNom(this.randNom());
	}

	public Gant(Gant ga) {
		super(ga);
		this.setNom(ga.getNom());
	}

	/*
	 * Methode
	 */

	/**
	 * Chargement des noms disponibles pour un Gant
	 * 
	 * @return Tableau de String etant des noms
	 */
	public static String[] chargerNom() {
		try {
			return LectureRessource.lire("noms/gant.txt").split("\n");
		} catch (Exception e) {
			String[] result = { "Gant solide", "Gant robuste" };
			return result;
		}
	}

	public Gant clone() {
		return new Gant(this);
	}

	public String randNom() {
		int i = new Random().nextInt((Gant.NOM.length));
		return Gant.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		super.affecterBonus(utilisateur, cible);
	}

}
