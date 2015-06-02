package mmorpg.personnage;

import mmorpg.carte.ContenuCase;


/**
 * Cette classe permet la gestion d'un personnage non joueur. </br>
 * Il est comme un joueur mais est controlee par l'IA
 * 
 * @author armya
 *
 */
public class PersonnageNJ extends EntiteVivante {
	
	
	/*
	 * Constructeur
	 */
	
	public PersonnageNJ () {
		super();
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
	
	public PersonnageNJ(PersonnageNJ pnj){
		super(pnj);
	}
	
	/*
	 * Methodes
	 */
	
	public int getNumero(){
		return ContenuCase.JOUEUR;
	}

	public void recupererPA() {
		
	}
}
