package personnage;

import java.util.Random;

import carte.ContenuCase;
import fichiers.LectureFichier;

/**
 * Cette classe permet la gestion d'un monstre controlle par l'IA
 * 
 * @author armya
 *
 */
public class Monstre extends EntiteVivante {

	public static final int BASE_PA = 5;

	// Demi constante qui ne peut etre modifier qu'avec
	// une potion qui augmente le nombre de PA pour un
	// certains nombre de tour
	private int MAX_PA;
	
	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/monstre.txt");
	
	/*
	 * Constructeur
	 */
	
	public Monstre () {
		super();
		this.setNom(this.randNom());
	}
	
	public String randNom() {
		int i = new Random().nextInt((Monstre.NOM.length));
		return Monstre.NOM[i];
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

	public void recupererPA() {
		
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
