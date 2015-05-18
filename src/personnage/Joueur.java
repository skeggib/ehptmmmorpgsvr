package personnage;

import java.util.Scanner;

import carte.ContenuCase;

public class Joueur extends EntiteVivante {

	public static final int BASE_PA = 10;

	// Demi constante qui ne peut etre modifier qu'avec
	// une potion qui augmente le nombre de PA pour un
	// certains nombre de tour
	private int MAX_PA;
	
	/*
	 * Constructeur
	 */
	
	@SuppressWarnings("resource")
	
	public Joueur () {
		super();
		this.setNom(new Scanner(System.in).nextLine()); // armya -> Met au moins un println pour demander le nom... Je cherchais pourquoi mon programme marchait pas
		this.setMAX_PA(Joueur.BASE_PA);
	}
	
	public Joueur (String nom) {
		super();
		this.setNom(nom);
	}
	
	public Joueur (String nom, int force, int adresse, int resistance){
		super(force, adresse, resistance);
		this.setNom(nom);
	}
	
	public Joueur (String nom, int force, int adresse, int resistance, int vie){
		super(force, adresse, resistance, vie);
		this.setNom(nom);
	}
	
	/*
	 * Methodes
	 */
	
	public int getNumero(){
		return ContenuCase.JOUEUR;
	}
	
	/*
	 * Methode d'acces
	 */
	
	public int getMAX_PA(){
		return this.MAX_PA;
	}
	
	public void setMAX_PA(int nbPA){
		this.MAX_PA = nbPA;
	}
	
	
}
