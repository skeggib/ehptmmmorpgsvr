package items;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

/**
 * 
 * Renvoie aleatoirement un nom pour <br>
 *  - Potion de soin<br>
 *  - Arme<br>
 *  - Casque<br>
 *  - Torse<br>
 *  - Jambe<br>
 *  - Gant<br>
 *  - Monstre<br>
 *  - PNJ<br>
 * 
 * @author armya
 *
 */
public class Nom {

	private static final String[] NOM_POTION_SOIN = Nom.getFileText("potion.txt");

	private static final String[] NOM_ARME = Nom.getFileText("arme.txt");

	private static final String[] NOM_CASQUE = Nom.getFileText("casque.txt");
	private static final String[] NOM_TORSE = Nom.getFileText("torse.txt");
	private static final String[] NOM_JAMBE = Nom.getFileText("jambe.txt");
	private static final String[] NOM_GANT = Nom.getFileText("gant.txt");
	private static final String[] NOM_MONSTRE = Nom.getFileText("monstre.txt");
	private static final String[] NOM_PNJ = Nom.getFileText("pnj.txt");

	private static Random rand = new Random();

	private Nom () {
		
	}
	
	public static String getNomPotionSoin(int valueSoin) {
		return Nom.NOM_POTION_SOIN[valueSoin];
	}
	/**
	 * Donne aleatoirement un nom d arme
	 * @return String nom d arme
	 */
	public static String getNomArme() {
		int i = Nom.rand.nextInt((Nom.NOM_ARME.length));
		return Nom.NOM_ARME[i];
	}

	/**
	 * Donne aleatoirement un nom de casque
	 * @return String nom de casque
	 */
	public static String getNomCasque() {
		int i = Nom.rand.nextInt((Nom.NOM_CASQUE.length));
		return Nom.NOM_CASQUE[i];
	}

	/**
	 * Donne aleatoirement un nom de torse
	 * @return String nom de torse
	 */
	public static String getNomTorse() {
		int i = Nom.rand.nextInt((Nom.NOM_TORSE.length));
		return Nom.NOM_TORSE[i];
	}

	/**
	 * Donne aleatoirement un nom de jambe
	 * @return String nom de jambe
	 */
	public static String getNomJambe() {
		int i = Nom.rand.nextInt((Nom.NOM_JAMBE.length));
		return Nom.NOM_JAMBE[i];
	}

	/**
	 * Donne aleatoirement un nom de gant
	 * @return String nom de gant
	 */
	public static String getNomGant() {
		int i = Nom.rand.nextInt((Nom.NOM_GANT.length));
		return Nom.NOM_GANT[i];
	}

	/**
	 * Donne aleatoirement un nom de monstre
	 * @return String nom de mostre
	 */
	public static String getNomMonstre() {
		int i = Nom.rand.nextInt((Nom.NOM_MONSTRE.length));
		return Nom.NOM_MONSTRE[i];
	}

	/**
	 * Donne aleatoirement un nom de PNJ
	 * @return String nom de PNJ
	 */
	public static String getNomPNJ() {
		int i = Nom.rand.nextInt((Nom.NOM_PNJ.length));
		return Nom.NOM_PNJ[i];
	}
	/**
	 * Lecture d'un fichier txt
	 * @param file chemin vers le fichiers txt (racine : txt/)
	 * @return tab : chaque ligne du fichier txt est retourne dans une case du tableau
	 */
	private static String[] getFileText(String file) {
		String filePath = "ressources/txt/" + file;
		String[] tab = null;
		try {
			BufferedReader buff = new BufferedReader(new FileReader(filePath));
			try {
				String ligne;
				int i = 0;
				
				/*
				 * On lit le fichier ligne par ligne.
				 * On compte d'abord les lignes pour cree le tableau
				 */
				
				while ((ligne = buff.readLine()) != null) {
					i++;
				}
				buff.close();
				buff = new BufferedReader(new FileReader(filePath));
				
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
}
