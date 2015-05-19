package personnage;

import java.util.Scanner;

import carte.Case;
import carte.ContenuCase;

public class Joueur extends EntiteVivante {

	public static final int BASE_PA = 10;

	public static final int PA_DEPLACEMENT = 2;
	public static final int PA_ATTAQUE = 2;

	/*
	 * Constructeur
	 */

	public Joueur() {
		super();
		this.setNom(new Scanner(System.in).nextLine());
		this.setPointAction(BASE_PA);
	}

	public Joueur(String nom) {
		super();
		this.setNom(nom);
		this.setPointAction(BASE_PA);
	}

	public Joueur(String nom, int force, int adresse, int resistance) {
		super(force, adresse, resistance);
		this.setNom(nom);
		this.setPointAction(BASE_PA);
	}

	public Joueur(String nom, int force, int adresse, int resistance, int vie) {
		super(force, adresse, resistance, vie);
		this.setNom(nom);
		this.setPointAction(BASE_PA);
	}

	/*
	 * Methodes
	 */

	public int getNumero() {
		return ContenuCase.JOUEUR;
	}

	public boolean seDeplacer(Case destination) {
		if (this.getPointAction() >= Joueur.PA_DEPLACEMENT) {
			if (super.seDeplacer(destination)) {
				this.setPointAction(this.getPointAction()
						- Joueur.PA_DEPLACEMENT);
				return true;
			}
		}
		return false;
	}
	
	public void attaquer(EntiteVivante cible) {
		if(this.getPointAction() >= Joueur.PA_ATTAQUE){
			super.attaquer(cible);
			this.setPointAction(this.getPointAction() - 2);
		}
	}

	public void recupererPA() {
		int pa = this.getPointAction();
		int newPa = pa + Joueur.BASE_PA/2;
		
		if(newPa > Joueur.BASE_PA){
			newPa = Joueur.BASE_PA;
		}
		
		this.setPointAction(newPa);
		
	}
	
	public boolean actionDisponible(){
		return (this.getPointAction() != 0);
	}

	/*
	 * Methode d'acces
	 */

	public int getMAX_PA() {
		return Joueur.BASE_PA;
	}

}
