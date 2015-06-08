package mmorpg.fichiers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LectureObjet {
	public static Object lire(String chemin) {
		
		File fichier = new File(chemin);
		
		Object o = null;
		
		ObjectInputStream ois;
		try {
			//Ouverture du flux
			ois = new ObjectInputStream(new FileInputStream(fichier));
			try {
				o = ois.readObject();
			} catch (ClassNotFoundException e) {
				// Gestion exception de lecture
				e.printStackTrace();
			} finally {
				// On ferme le flux dans tout les cas
				ois.close();
			}
		} catch (IOException e) {
			//Gestion des exeptions d'ouverture
			e.printStackTrace();
		}
		return o;
	}
}
