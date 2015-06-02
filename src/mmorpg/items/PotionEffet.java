package mmorpg.items;

import java.util.Random;

import mmorpg.personnage.Effet;
import mmorpg.personnage.EntiteVivante;

public class PotionEffet extends Potion{ // TODO:skeggib UML

	/*
	 * Variables
	 */

	private int force;
	private int adresse;
	private int resistance;
	private int maniabilite;
	private int impact;

	private int duree;

	/*
	 * Constructeur
	 */

	public PotionEffet() {
		super();

		Random rand = new Random();

		int niveau = 0;

		int valeurCaractAlea = 0;

		int resultRand = rand.nextInt(1001);
		if (resultRand < 200) {
			niveau = 0;
		} else if (resultRand >= 200 && resultRand < 600) {
			niveau = 1;
		} else if (resultRand >= 600 && resultRand < 850) {
			niveau = 2;
		} else if (resultRand >= 850 && resultRand < 950) {
			niveau = 3;
		} else if (resultRand >= 950 && resultRand < 1000) {
			niveau = 4;
		} else if (resultRand == 1000) {
			niveau = 5;
		}

		switch (niveau) {
		case 0:
			valeurCaractAlea = (rand.nextInt(3) + 2);
			this.setDuree(1);
			break;
		case 1:
			valeurCaractAlea = (rand.nextInt(3) + 4);
			this.setDuree(1);
			break;
		case 2:
			valeurCaractAlea = (rand.nextInt(3) + 6);
			this.setDuree(2);
			break;
		case 3:
			valeurCaractAlea = (rand.nextInt(3) + 8);
			this.setDuree(2);
			break;
		case 4:
			valeurCaractAlea = (rand.nextInt(3) + 10);
			this.setDuree(3);
			break;
		case 5:
			valeurCaractAlea = (14);
			this.setDuree(4);
			break;
		default:
			break;
		}

		int randomCaract = rand.nextInt(5);
		
		if (randomCaract == 0) {
			this.setAdresse(valeurCaractAlea);
		} else if (randomCaract == 1) {
			this.setForce(valeurCaractAlea);
		} else if (randomCaract == 2){
			this.setResistance(valeurCaractAlea);
		} else if (randomCaract == 3){
			this.setManiabilite(valeurCaractAlea);
		} else {
			this.setImpact(valeurCaractAlea);
		}
		
		this.setNom(this.randNom());
	}
	
	public PotionEffet(PotionEffet pe){
		this.setAdresse(pe.getAdresse());
		this.setForce(pe.getForce());
		this.setImpact(pe.getImpact());
		this.setManiabilite(pe.getManiabilite());
		this.setResistance(pe.getResistance());
		this.setDuree(pe.getDuree());
		this.setNom(pe.getNom());
	}

	/*
	 * Methode
	 */
	
	public PotionEffet clone(){
		return new PotionEffet(this);
	}

	@Override
	public String randNom() {
		if(this.getForce() > 0){
			this.setNom("Potion de force");
		} else if (this.getAdresse() > 0){
			this.setNom("Potion d'adresse");
		} else if (this.getResistance() > 0){
			this.setNom("Potion de resistance");
		} else if (this.getManiabilite() > 0){
			this.setNom("Potion de maniabilite");
		} else if (this.getImpact() > 0){
			this.setNom("Potion d'impact");
		}
		return null;
	}
	
	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
		Effet effet = new Effet(this.getDuree());
		
		effet.ajouterForce(this.getForce());
		effet.ajouterAdresse(this.getAdresse());
		effet.ajouterResistance(this.getResistance());
		effet.ajouterImpact(this.getImpact());
		effet.ajouterManiabilite(this.getManiabilite());
		
		cible.ajouterEffet(effet);
		
		utilisateur.retirerObjet(this);
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

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

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
