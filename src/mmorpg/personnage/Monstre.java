package mmorpg.personnage;

import java.util.Random;

import mmorpg.carte.ContenuCase;
import mmorpg.fichiers.LectureFichier;
import mmorpg.items.Arme;
import mmorpg.items.Casque;
import mmorpg.items.Gant;
import mmorpg.items.Objet;
import mmorpg.items.Pantalon;
import mmorpg.items.Torse;

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
		this.remplirInvetaire();
		this.setNom(this.nomRandom());
	}

	public Monstre(String nom) {
		super();
		this.statRandom();
		this.remplirInvetaire();
		this.setNom(nom);
	}

	public Monstre(String nom, int force, int adresse, int resistance) {
		super(force, adresse, resistance);
		this.remplirInvetaire();
		this.setNom(nom);
	}

	public Monstre(String nom, int force, int adresse, int resistance, int vie) {
		super(force, adresse, resistance, vie);
		this.remplirInvetaire();
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

	public void remplirInvetaire(){
		Random rand = new Random();
		
		int nombreObjet = rand.nextInt(2);
		switch(nombreObjet){
		case 0:
			this.getInventaire().ajouterObjet(this.creeRandomObjet());
			break;
		case 1:
			this.getInventaire().ajouterObjet(this.creeRandomObjet());
			this.getInventaire().ajouterObjet(this.creeRandomObjet());
			break;
		}
	}

	private Objet creeRandomObjet() {
		Random rand = new Random();

		int choix = rand.nextInt(5);

		switch (choix) {
		case 0:
			return new Casque();
		case 1:
			return new Torse();
		case 2:
			return new Gant();
		case 3:
			return new Pantalon();
		case 4:
			return new Arme();
		default:
			return null;
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
