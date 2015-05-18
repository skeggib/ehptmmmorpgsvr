package personnage;

import java.util.Random;

import carte.ContenuCase;
import fichiers.LectureFichier;

public class Monstre extends EntiteVivante {
	
	public static final String[] NOM = LectureFichier
			.lireT("../ressources/noms/monstre.txt");
	
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
}
