package mmorpg.items;

import java.util.Random;

import mmorpg.personnage.EntiteVivante;

public abstract class Vetement extends Equipable {

	/*
	 * Variables
	 */

	private int force;
	private int adresse;
	private int resistance;

	/*
	 * Constructeurs
	 */

	public Vetement() {
		super();

		Random rand = new Random();
		
		int randomCaract = rand.nextInt(2);

		int valeurCaractAlea = 0;

		switch (this.getQualite()) {
		case Equipable.MAUVAIS:
			valeurCaractAlea = (rand.nextInt(3) + 2);
			this.setResistance(rand.nextInt(3) + 2);
			break;
		case Equipable.COMMUN:
			valeurCaractAlea = (rand.nextInt(3) + 3);
			this.setResistance(rand.nextInt(3) + 3);
			break;
		case Equipable.INHABITUEL:
			valeurCaractAlea = (rand.nextInt(3) + 4);
			this.setResistance(rand.nextInt(3) + 4);
			break;
		case Equipable.RARE:
			valeurCaractAlea = (rand.nextInt(3) + 5);
			this.setResistance(rand.nextInt(3) + 5);
			break;
		case Equipable.EPIQUE:
			valeurCaractAlea = (rand.nextInt(3) + 6);
			this.setResistance(rand.nextInt(3) + 6);
			break;
		case Equipable.LEGENDAIRE:
			valeurCaractAlea = (10);
			this.setResistance(10);
			break;
		default:
			break;
		}
		
		if(randomCaract == 0){
			this.setAdresse(valeurCaractAlea);
		} else {
			this.setForce(valeurCaractAlea);
		}
	}

	public Vetement(int qualite) {
		super(qualite);
	}

	/*
	 * Methode
	 */

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		cible.getCaractEquip().ajouterForce(this.getForce());
		cible.getCaractEquip().ajouterAdresse(this.getAdresse());
		cible.getCaractEquip().ajouterResistance(this.getResistance());
	}


	/*
	 * Methodes d'acces
	 */

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

}
