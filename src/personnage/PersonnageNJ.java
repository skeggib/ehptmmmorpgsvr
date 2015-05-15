package personnage;

import java.util.Scanner;

import carte.ContenuCase;

public class PersonnageNJ extends EntiteVivante {
	
	
	/*
	 * Constructeur
	 */
	
	@SuppressWarnings("resource")
	public PersonnageNJ () {
		super();
		this.setNom(new Scanner(System.in).nextLine()); // armya -> Met au moins un println pour demander le nom... Je cherchais pourquoi mon programme marchait pas
	}
	
	public PersonnageNJ (String nom) {
		super();
		this.setNom(nom);
	}
	
	public PersonnageNJ (String nom, int force, int adresse, int resistance){
		super(force, adresse, resistance);
		this.setNom(nom);
	}
	
	public PersonnageNJ (String nom, int force, int adresse, int resistance, int vie){
		super(force, adresse, resistance, vie);
		this.setNom(nom);
	}
	
	/*
	 * Methodes
	 */
	
	public int getNumero(){
		return ContenuCase.JOUEUR;
	}
}
