package mmorpg.fichiers;

import java.io.File;

public class Test {

	public static void main(String[] args) {
		String chemin = "ressources/noms/arme.txt";
		File f = new File(chemin);

		System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
		System.out.println("Nom du fichier : " + f.getName());
		System.out.println("Est-ce qu'il existe ? " + f.exists());
		System.out.println("Est-ce un répertoire ? " + f.isDirectory());
		System.out.println("Est-ce un fichier ? " + f.isFile());

		System.out.println(LectureFichier.lireS(chemin));
	}

}
