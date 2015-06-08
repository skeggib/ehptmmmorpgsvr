package mmorpg.fichiers;

import mmorpg.jeu.Moteur;

public class Test {

	public static void main(String[] args) {
		Object o = LectureObjet.lire("objet.ser");
		Moteur m = (Moteur) o;
		System.out.println(m.getClass());
		
		m.jouer();
		
	}

}
