package personnage;

import java.util.Scanner;

import carte.ContenuCase;

public class Monstre extends EntiteVivante {
	
	
	/*
	 * Constructeur
	 */
	
	@SuppressWarnings("resource")
	public Monstre () {
		super();
		this.setNom(new Scanner(System.in).nextLine()); // armya -> Met au moins un println pour demander le nom... Je cherchais pourquoi mon programme marchait pas
	}
	
	public Monstre (String nom) {
		super();
		this.setNom(nom);
	}
	
	public Monstre (String nom, int force, int adresse, int resistance){
		super(force, adresse, resistance);
		this.setNom(nom);
	}
	
	public Monstre (String nom, int force, int adresse, int resistance, int vie){
		super(force, adresse, resistance, vie);
		this.setNom(nom);
	}
	
	/*
	 * Methodes
	 */
	
	public int getNumero(){
		return ContenuCase.MONSTRE;
	}
}
