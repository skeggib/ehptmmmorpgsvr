package personnage;

import java.util.Scanner;

import carte.ContenuCase;

public class Joueur extends EntiteVivante {

	public static final int BASE_PA = 10;

	/*
	 * Constructeur
	 */

	public Joueur() {
		super();
		this.setNom(new Scanner(System.in).nextLine());
		
	}

	public Joueur(String nom) {
		super();
		this.setNom(nom);
	}

	public Joueur(String nom, int force, int adresse, int resistance) {
		super(force, adresse, resistance);
		this.setNom(nom);
	}

	public Joueur(String nom, int force, int adresse, int resistance, int vie) {
		super(force, adresse, resistance, vie);
		this.setNom(nom);
	}

	/*
	 * Methodes
	 */

	public int getNumero() {
		return ContenuCase.JOUEUR;
	}

	/*
	 * Methode d'acces
	 */

	public int getMAX_PA() {
		return Joueur.BASE_PA;
	}

	private void setPointAction(int pointAction) {
	
	}

}
