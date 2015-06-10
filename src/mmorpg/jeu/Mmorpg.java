package mmorpg.jeu;
import java.io.File;

import mmorpg.controles.Controleur;
import mmorpg.fichiers.LectureObjet;


public class Mmorpg {

	public static void main(String[] args) {
		
		File sav = new File("objet.ser");
		
		int reponse;
		if (sav.exists() && !sav.isDirectory()) {
			System.out.println("Que voulez vous faire ?");
			System.out.println("1. Commencer une nouvelle partie");
			System.out.println("2. Continuer à la derniere sauvegarde");
			
			reponse = Controleur.saisieInt(1, 2);
		}
		else
			reponse = 1;
		
		Moteur moteur;
		
		if (reponse == 1)
			moteur = new Moteur();
		else
			moteur = (Moteur) LectureObjet.lire("objet.ser");
		
		moteur.jouer();
		
	}
	
}
