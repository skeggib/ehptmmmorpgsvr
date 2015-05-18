package fichiers;

import java.util.List;

import items.*;
import personnage.Joueur;

public class Test {

	public static void main(String[] args) {
//		Joueur [] tabJ = {new Joueur ("Armya", 23, 43, 12, 9), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3), new Joueur ("Skeggib", 23, 54, 9, 3)};
//		EcritureXML.ecrireEntites("ressources/entites.xml", tabJ);
//		PotionDeSoin p = new PotionDeSoin ();
//		System.out.println(p.getNom());
//		System.out.println(p.getBonusVie());
//		List<Joueur> test = LectureXML.chargerJoueurs("ressources/entites.xml");
//		System.out.println("\n\nTaille List : " + test.size());
		
		Arme a = new Arme();
		
		EcritureObj.ecrire(a);
		
	}

}
