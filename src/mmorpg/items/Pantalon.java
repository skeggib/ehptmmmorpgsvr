package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureRessource;
import mmorpg.personnage.EntiteVivante;

public class Pantalon extends Vetement {

	private static final long serialVersionUID = 3068876954778600010L;
	
	/*
	 * Constantes
	 */
	public static final String[] NOM = LectureRessource
			.lire("noms/jambe.txt").split("\n");

	/*
	 * Constructeur
	 */

	public Pantalon() {
		super();
		this.setNom(this.randNom());
	}
	
	public Pantalon(Pantalon pa){
		super(pa);
		this.setNom(pa.getNom());
	}

	/*
	 * Methode
	 */
	
	public Pantalon clone(){
		return new Pantalon(this);
	}

	public String randNom() {
		int i = new Random().nextInt((Pantalon.NOM.length));
		return Pantalon.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		super.affecterBonus(utilisateur, cible);
	}

}
