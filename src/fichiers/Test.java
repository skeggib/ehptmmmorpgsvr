package fichiers;

import java.io.File;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		System.out.println("Chemin du fichier (ex : ressources/noms/arme.txt) : " );
		String chemin = new Scanner(System.in).nextLine();
		
		File f = new File(chemin);

		System.out.println("Chemin absolu du fichier : " + f.getAbsolutePath());
		System.out.println("Nom du fichier : " + f.getName());
		System.out.println("Est-ce qu'il existe ? " + f.exists());
		System.out.println("Est-ce un répertoire ? " + f.isDirectory());
		System.out.println("Est-ce un fichier ? " + f.isFile()+"\n\n");
		
		
		
		System.out.println(LectureFichier.lireS(chemin));
	}

}
