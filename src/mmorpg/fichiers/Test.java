package mmorpg.fichiers;

import java.io.File;

import mmorpg.items.Arme;
import mmorpg.jeu.Moteur;
import mmorpg.personnage.Joueur;

public class Test {

	public static void main(String[] args) {
		
		Joueur j = new Joueur("Armya", 20, 10, 10);
		j.ramasserObjet(new Arme());
		
		EcritureObjet.ecrire(j);
		
		Object obj = LectureObjet.lire("objet.ser");
		
		System.out.println(obj.getClass());
		
		Joueur j2 = (Joueur) obj;

		System.out.println("FORCE (BASE) : " + j.getCaractPrinc().getForce());
		System.out.println("FORCE (SAVE) : " + j2.getCaractPrinc().getForce());

		System.out.println("NOM ARME (BASE) : " + j.getInventaire().getObjet(0).getNom());
		System.out.println("NOM ARME (SAVE) : " + j2.getInventaire().getObjet(0).getNom());
		
		//
		// Moteur vroum = (Moteur) obj;
		//
		// vroum.jouer();
	}

}
