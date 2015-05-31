package mmorpg.personnage;

import java.util.Random;

import mmorpg.carte.Carte;
import mmorpg.carte.ContenuCase;
import mmorpg.fichiers.LectureFichier;

/**
 * Cette classe permet la gestion d'un monstre controlle par l'IA
 * 
 * @author armya
 *
 */
public class Monstre extends EntiteVivante {

	public static final int BASE_PA = 10;

	// Demi constante qui ne peut etre modifier qu'avec
	// une potion qui augmente le nombre de PA pour un
	// certains nombre de tour
	private int MAX_PA;

	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/monstre.txt");

	/*
	 * Constructeur
	 */

	public Monstre() {
		super();
		this.statRandom();
		this.setNom(this.nomRandom());
	}

	public Monstre(String nom) {
		super();
		this.statRandom();
		this.setNom(nom);
	}

	public Monstre(String nom, int force, int adresse, int resistance) {
		super(force, adresse, resistance);
		this.setNom(nom);
	}

	public Monstre(String nom, int force, int adresse, int resistance, int vie) {
		super(force, adresse, resistance, vie);
		this.setNom(nom);
	}

	/*
	 * Methodes
	 */

	private void statRandom() {
		Random rand = new Random();

		int niveau = 0;

		int resultRand = rand.nextInt(1000);
		
		if (resultRand < 300) {
			niveau = 0;
		} else if (resultRand >= 300 && resultRand < 600) {
			niveau = 1;
		} else if (resultRand >= 600 && resultRand < 850) {
			niveau = 2;
		} else if (resultRand >= 850 && resultRand < 950) {
			niveau = 3;
		} else if (resultRand >= 950 && resultRand < 999) {
			niveau = 4;
		}

		switch (niveau) {
		case 0:
			this.getCaractPrinc().setForce(rand.nextInt(4) + 8);
			this.getCaractPrinc().setAdresse(rand.nextInt(4) + 8);
			this.getCaractPrinc().setResistance(rand.nextInt(4) + 8);
			break;
		case 1:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 16);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 16);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 16);
			break;
		case 2:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 16);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 16);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 16);
			break;
		case 3:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 26);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 26);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 26);
			break;
		case 4:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 36);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 36);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 36);
			break;
		case 5:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 56);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 56);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 56);
			break;
		default:
			break;
		}

	}

	public String nomRandom() {
		int i = new Random().nextInt((Monstre.NOM.length));
		return Monstre.NOM[i];
	}

	public int getNumero() {
		return ContenuCase.MONSTRE;
	}

	public void recupererPA() {
		this.setPointAction(this.getMAX_PA());
	}
	
	public void realiserAction(Carte carte) {
		
		// Verifier s'il y a un joueur a coté
			// S'il y en a un, l'attaquer
		
			
			// S'il y en a pas
				// Choisir une direction au hasart
				
				
				// Se deplacer vers cette direction
		
	}

	/*
	 * Methode d'acces
	 */

	public int getMAX_PA() {
		return this.MAX_PA;
	}

	public void setMAX_PA(int nbPA) {
		this.MAX_PA = nbPA;
	}
}
