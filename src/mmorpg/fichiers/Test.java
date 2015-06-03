package mmorpg.fichiers;

import java.io.File;

import mmorpg.jeu.Moteur;

public class Test {

	public static void main(String[] args) {
		Object obj = LectureObjet.lire("objet.ser");
		
		System.out.println(obj.getClass());
		
		Moteur vroum = (Moteur) obj;
		
		vroum.jouer();
	}

}
