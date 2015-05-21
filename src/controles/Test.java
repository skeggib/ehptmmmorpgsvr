package controles;

import java.util.LinkedList;
import java.util.Random;

import items.Gant;
import carte.Carte;
import carte.Position;
import personnage.Joueur;
import personnage.Monstre;
import affichage.InterfaceTerm;

public class Test {

	public static void main(String[] args) {

	}
	
	private static void ajoutMonstres(Carte carte) { // TODO:skeggib Implementer au bon endroit
		Random rand = new Random();
		int randInt;
		
		LinkedList<Monstre> liste = new LinkedList<Monstre>();
		Monstre tempMonstre;
		
		// Chance qu'a chaque case de recevoir un Monstre
		int chanceCase = 5;
		// Chance que chaque monstre a de devenir un groupe de monstres
		int chanceDevientGroupe = 10;
		
		// On ajoute des monstres aleatoirement dans la carte sur les cases vides
		for (int i = 0; i < carte.getHauteur(); i++) {
			for (int j = 0; j < carte.getLargeur(); j++) {
				if (carte.getCase(j, i).estVide()) {
					randInt = rand.nextInt(100);
					if (randInt < chanceCase) {
						tempMonstre = new Monstre("monster");
						liste.add(tempMonstre);
						tempMonstre.initialiserPos(carte.getCase(j, i));
					}
				}
			}
		}
		
		Position posM;
		
		// On creer les groupes de monstre
		for (int i = 0; i < liste.size(); i++) {
			randInt = rand.nextInt(100);
			if (randInt < chanceDevientGroupe) {
				posM = carte.getPosContenu(liste.get(i));
				System.out.println(posM);
				
				for (int y = posM.getY() - 1; y <= posM.getY() + 1; y++) {
					for (int x = posM.getX() - 1; x <= posM.getX() + 1; x++) {
						randInt = rand.nextInt(100);
						if (randInt < 33) {
							tempMonstre = new Monstre("monster");
							tempMonstre.initialiserPos(carte.getCase(x, y));
						}
					}
				}
			}
		}
	}

}
