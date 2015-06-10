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

	public static final String[] NOM = Arme.chargerNom();

	public Arme() {
		super();

		this.setNom(this.randNom());

		Random rand = new Random();

		switch (this.getQualite()) {
		case Equipable.MAUVAIS:
			this.setManiabilite(rand.nextInt(2) + 2);
			this.setImpact(rand.nextInt(2) + 2);
			break;
		case Equipable.COMMUN:
			this.setManiabilite(rand.nextInt(2) + 3);
			this.setImpact(rand.nextInt(2) + 3);
			break;
		case Equipable.INHABITUEL:
			this.setManiabilite(rand.nextInt(3) + 4);
			this.setImpact(rand.nextInt(3) + 4);
			break;
		case Equipable.RARE:
			this.setManiabilite(rand.nextInt(3) + 5);
			this.setImpact(rand.nextInt(3) + 5);
			break;
		case Equipable.EPIQUE:
			this.setManiabilite(rand.nextInt(3) + 6);
			this.setImpact(rand.nextInt(3) + 6);
			break;
		case Equipable.LEGENDAIRE:
			this.setManiabilite(10);
			this.setImpact(10);
			break;
		default:
			break;
		}
	}

	public Arme(String nom, int maniabilite, int impact) {
		this.setNom(nom);
		this.setManiabilite(maniabilite);
		this.setImpact(impact);
	}

	public Arme(Arme ar) {
		super(ar);
		this.setImpact(ar.getImpact());
		this.setManiabilite(ar.getManiabilite());
		this.setNom(ar.getNom());
	}

	/*
	 * Methode
	 */


	/**
	 * Chargement des noms disponibles pour une Arme
	 * @return Tableau de String etant des noms
	 */
	public static String[] chargerNom() {
		try {
			return LectureRessource.lire("noms/arme.txt").split("\n");
		} catch (Exception e) {
			String[] result = {"Epee solide", "Epee robuste"}; 
			return result;
		}
	}

	public String getType() {
		return "Arme";
	}

	public Arme clone() {
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
		return this.maniabilite;
	}

	public void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}

	public int getImpact() {
		return this.impact;
	}

	public void setImpact(int impact) {
		this.impact = impact;
	}
}
