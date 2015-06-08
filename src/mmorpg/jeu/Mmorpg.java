package mmorpg.jeu;
import mmorpg.controles.Controleur;
import mmorpg.fichiers.LectureObjet;


public class Mmorpg {

	public static void main(String[] args) {
		
		System.out.println("Que voulez vous faire ?");
		System.out.println("\t1. Commencer une nouvelle partie");
		System.out.println("\t2. Continuer à la derniere sauvegarde");
		
		int reponse = Controleur.saisieInt(1, 2);
		
		Moteur moteur;
		
		if (reponse == 1)
			moteur = new Moteur();
		else
			moteur = (Moteur) LectureObjet.lire("objet.ser");
		
		moteur.jouer();
		
	}
	
}
