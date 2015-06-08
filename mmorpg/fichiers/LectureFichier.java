package mmorpg.fichiers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class LectureFichier {
	/*
	 * La racine (chemin) est le dossier du projet
	 */

	/**
	 * 
	 * @param chemin
	 *            Chemin vers le fichier </br> Ex : ("ressources/fichier.txt")
	 * 
	 * @return Tableau de String contenant le contenu du fichier
	 */
	public static String[] lireT(String chemin) {
		String[] tab = null;

		chemin = LectureFichier.testChemin(chemin);

		try {
			BufferedReader buff = new BufferedReader(new FileReader(chemin));
			try {
				String ligne;
				int i = 0;

				/*
				 * On lit le fichier ligne par ligne. On compte d'abord les
				 * lignes pour cree le tableau
				 */

				while ((ligne = buff.readLine()) != null) {
					i++;
				}
				buff.close();
				buff = new BufferedReader(new FileReader(chemin));

				/*
				 * Creation du tableau
				 */
				tab = new String[i];
				i = 0;

				/*
				 * Remplissage du tableau
				 */
				while ((ligne = buff.readLine()) != null) {
					tab[i] = ligne;
					i++;
				}
			} finally {
				// dans tous les cas, on ferme nos flux
				buff.close();
			}
		} catch (IOException ioe) {
			// erreur de fermeture des flux
			System.out.println("Erreur --" + ioe.toString());
		}
		return tab;
	}

	/**
	 * 
	 * @param chemin
	 *            Chemin vers le fichier </br> Ex : ("ressources/fichier.txt")
	 * 
	 * @return String contenant le contenu du fichier
	 */
	public static String lireS(String chemin) {

		chemin = LectureFichier.testChemin(chemin);

		String result = "";

		try {
			BufferedReader buff = new BufferedReader(new FileReader(chemin));
			try {
				String ligne;

				while ((ligne = buff.readLine()) != null) {
					result += ligne + "\n";
				}
			} finally {
				buff.close();
			}
		} catch (IOException ioe) {
			// erreur de fermeture des flux
			System.out.println("Erreur --" + ioe.toString());
		}
		return result;
	}

	private static String testChemin(String chemin) {
		if (!new File(chemin).exists()) {
			if (new File("../" + chemin).exists()) {
				chemin = "../" + chemin;
			}
			if(new File("/" + chemin).exists()){
				chemin = "/" + chemin;
			}
		}

		return chemin;

	}
}
