package mmorpg.fichiers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public abstract class LectureRessource {

	public static String lire(String path) throws Exception {
		String rtrn = "";

		InputStream is = Object.class
				.getResourceAsStream("/ressources/" + path);

		// Si le fichier est introuveble dans le jar
		if (is == null) {

			try {
				// On lit celui qui est dans le dossier ressources
				rtrn = LectureFichier.lireS("ressources/" + path);
			}
			catch (Exception e) {
				throw new Exception("Erreur lors de la lecture de la ressource '" + path + "'", e);
			}

			return rtrn;
		}

		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;

		try {
			while ((line = br.readLine()) != null) {
				rtrn += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			br.close();
			isr.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return rtrn;
	}
	
	public static String[] lireTab(String path) throws Exception {
		ArrayList<String> array = new ArrayList<String>();

		InputStream is = Object.class
				.getResourceAsStream("/ressources/" + path);

		// Si le fichier est introuveble dans le jar
		if (is == null) {
			
			String[] rtrn;
			
			try {
				// On lit celui qui est dans le dossier ressources
				rtrn  = LectureFichier.lireT("ressources/" + path);
			}
			catch (Exception e) {
				throw new Exception("Erreur lors de la lecture de la ressource '" + path + "'", e);
			}
			
			return rtrn;
		}

		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);

		String line;

		try {
			while ((line = br.readLine()) != null) {
				array.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			br.close();
			isr.close();
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return array.toArray(new String[array.size()]);
	}

}
