package mmorpg.items;

import java.util.Random;

import mmorpg.fichiers.LectureRessource;
import mmorpg.personnage.EntiteVivante;

public class Arme extends Equipable {

	/*
	 * Variable
	 */
	private static final long serialVersionUID = 4266819174155112530L;
	
	private int maniabilite;
	private int impact;

	/*
	 * Constantes
	 */

	public static final String[] NOM = LectureRessource
			.lire("noms/arme.txt").split("\n");
	// TODO:armya Je ne pense pas que ce soit une bonne idee
	// de stocker les noms comme ca,
	// imagine tu en a 1000 dans le fichier, et bien tu va stocker
	// un tableau de 1000 String...
	// Je pense q'il serait preferable de lire le fichier dans
	// la methode randNom()

	public Arme() {
		super();

		this.setNom(this.randNom());

		Random rand = new Random();

		switch (this.getQualite()) {
		case 0: // TODO:armya Ce serai plus lisible de mettre Equipable.MAUVAIS au lieu de 0, idem pour les autres case
			this.setManiabilite(rand.nextInt(2) + 2);
			this.setImpact(rand.nextInt(2) + 2);
			break;
		case 1:
			this.setManiabilite(rand.nextInt(2) + 3);
			this.setImpact(rand.nextInt(2) + 3);
			break;
		case 2:
			this.setManiabilite(rand.nextInt(3) + 4);
			this.setImpact(rand.nextInt(3) + 4);
			break;
		case 3:
			this.setManiabilite(rand.nextInt(3) + 5);
			this.setImpact(rand.nextInt(3) + 5);
			break;
		case 4:
			this.setManiabilite(rand.nextInt(3) + 6);
			this.setImpact(rand.nextInt(3) + 6);
			break;
		case 5:
			this.setManiabilite(9);
			this.setImpact(9);
			break;
		default:
			break;
		}
	}
	
	public Arme(String nom, int maniabilite, int impact){
		this.setNom(nom);
		this.setManiabilite(maniabilite);
		this.setImpact(impact);
	}
	
	public Arme(Arme ar){
		super(ar);
		this.setImpact(ar.getImpact());
		this.setManiabilite(ar.getManiabilite());
		this.setNom(ar.getNom());
	}

	/*
	 * Methode
	 */
	
	public String getType(){
		return "Arme";
	}
	
	public Arme clone(){
		return new Arme(this);
	}

	public String randNom() {
		int i = new Random().nextInt((Arme.NOM.length));
		return Arme.NOM[i];
	}

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		cible.getCaractEquip().ajouterManiabilite(this.getManiabilite());
		cible.getCaractEquip().ajouterImpact(this.getImpact());
	}

	/*
	 * Methodes d'acces
	 */

	public int getManiabilite() {
		return maniabilite;
	}

	public void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}

	public int getImpact() {
		return impact;
	}

	public void setImpact(int impact) {
		this.impact = impact;
	}
}
