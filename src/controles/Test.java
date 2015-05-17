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
		
		Joueur joueur = new Joueur("joueur");
		InterfaceTerm inter = new InterfaceTerm(0);
		
		Carte carte = new Carte();
		carte.chargerFichier("../ressources/carte/test");
		
		inter.setCarte(carte);
		
		joueur.initialiserPos((carte.getCase(3, 3)));
		
		carte.getCase(3, 3).ajoutContenu(new Gant());
		
		Test.ajoutMonstres(carte);
		
		Clavier clavier = new Clavier();
		clavier.setCarte(carte);
		clavier.setJoueur(joueur);
		
		while (true) {
			inter.afficher(joueur);
			clavier.saisieDirection();
		}

	}
	
	private static LinkedList<Monstre> ajoutMonstres(Carte carte) {
		Random rand = new Random();
		int randInt;
		
		LinkedList<Monstre> liste = new LinkedList<Monstre>();
		Monstre tempMonstre;
		
		// Chance qu'a chaque case de recevoir un Monstre
		int chanceCase = 5;
		// Chance que chaque monstre a de devenir un groupe de monstres
		int chanceDevientGroupe = 33;
		
		// On ajoute des monstres aleatoirement dans la carte sur les cases vides
		for (int i = 0; i < carte.getHauteur(); i++) {
			for (int j = 0; j < carte.getLargeur(); j++) {
				if (carte.getCase(j, i).estVide()) {
					randInt = rand.nextInt(100);
					if (randInt < chanceCase) {
						tempMonstre = new Monstre("monster");
						liste.add(tempMonstre);
						carte.getCase(j, i).ajoutContenu(tempMonstre);
					}
				}
			}
		}
		
		Position posM;
		LinkedList<Monstre> tempListe = new LinkedList<Monstre>();
		
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
							tempListe.add(tempMonstre);
							carte.getCase(x, y).ajoutContenu(tempMonstre);
						}
					}
				}
			}
		}
		
		liste.addAll(tempListe);
		
		return liste;
	}

}
