package personnage;

import java.util.Scanner;

import carte.ContenuCase;

public class Joueur extends EntiteVivante {
	
	
	/*
	 * Constructeur
	 */
	
	@SuppressWarnings("resource")
	public Joueur () {
		super();
		this.setNom(new Scanner(System.in).nextLine()); // armya -> Met au moins un println pour demander le nom... Je cherchais pourquoi mon programme marchait pas
	}
	
	public Joueur (String nom) {
		super();
		this.setNom(nom);
	}
	
	public Joueur (String nom, int force, int adresse, int resistance){
		super(force, adresse, resistance);
		this.setNom(nom);
	}
	
	/*
	 * Methodes
	 */
	
	public int getNumero(){
		return ContenuCase.JOUEUR;
	}
}
