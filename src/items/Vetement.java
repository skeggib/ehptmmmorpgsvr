package items;

import personnage.EntiteVivante;

public abstract class Vetement extends Equipable {

	/*
	 * Constructeurs
	 */

	public Vetement() {
		super();
	}

	public Vetement(int qualite) {
		super(qualite);
	}

	/*
	 * Variables
	 */

	private int force;
	private int adresse;
	private int resistance;

	/*
	 * Methode
	 */

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		cible.getCaractEquip().ajouterForce(this.getForce());
		cible.getCaractEquip().ajouterAdresse(this.getAdresse());
		cible.getCaractEquip().ajouterResistance(this.getResistance());
	}

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getAdresse() {
		return adresse;
	}

	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	/*
	 * Methodes d'acces
	 */

}
