package mmorpg.fichiers;

import java.io.*;
import java.util.ArrayList;

public abstract class LectureRessource {

	public static String lire(String path) {
		String rtrn = "";

		InputStream is = Object.class
				.getResourceAsStream("/ressources/" + path);

		// Si le fichier est introuveble dans le jar
		if (is == null) {

			// On lit celui qui est dans le dossier ressources
			rtrn = LectureFichier.lireS("ressources/" + path);

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
	
	public static String[] lireTab(String path) {
		ArrayList<String> array = new ArrayList<String>();

		InputStream is = Object.class
				.getResourceAsStream("/ressources/" + path);

		// Si le fichier est introuveble dans le jar
		if (is == null) {

			// On lit celui qui est dans le dossier ressources
			return LectureFichier.lireT("ressources/" + path);
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