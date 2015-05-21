package mmorpg.fichiers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EcritureObj {

	public static void ecrire(Object obj) {
		File fichier = new File("objet.ser");

		ObjectOutputStream oos;
		try {
			oos = new ObjectOutputStream(new FileOutputStream(fichier));
			try {
				oos.writeObject(obj);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				oos.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
