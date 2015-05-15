package fichiers;

import java.io.BufferedWriter;
import java.io.FileWriter;

public abstract class EcritureFichier { // TODO:skeggib Ajouter cette classe dans l'UML (c'est maaaaaal de faire le Java avant l'UML armya !)
	/*
	 * La racine (chemin) est le dossier du projet
	 */

	/**
	 * 
	 * @param destination
	 *            String chemin vers le fichier
	 * @param reset
	 *            boolean true pour ecrire par dessus (reset le fichier), false
	 *            pour ecrire a la fin
	 * @param donnees
	 *            String a ecrire
	 */
	public static void ecrire(String destination, boolean reset, String donnees) {
		try {
			BufferedWriter fichier = new BufferedWriter(new FileWriter(
					destination, (!reset)));
			try {
				fichier.write(donnees);
				fichier.newLine();
			} finally {
				fichier.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param destination
	 *            String chemin vers le fichier
	 * @param reset
	 *            boolean true pour ecrire par dessus (reset le fichier), false
	 *            pour ecrire a la fin
	 * @param donnees
	 *            Tableau de String a ecrire
	 */
	public static void ecrire(String destination, boolean reset,
			String[] donnees) {
		try {
			BufferedWriter fichier = new BufferedWriter(new FileWriter(
					destination, (!reset)));
			try {
				for (int i = 0; i < donnees.length; i++) {
					fichier.write(donnees[i]);
					fichier.newLine();
				}
			} finally {
				fichier.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
