package mmorpg.controles;

import java.util.Random;

import mmorpg.carte.Carte;
import mmorpg.carte.Position;
import mmorpg.jeu.Log;
import mmorpg.personnage.Joueur;
import mmorpg.personnage.Monstre;

public abstract class IAMonstre {
	
	public static boolean realiserAction(Monstre monstre, Carte carte, Log log) {
		
		if (!monstre.actionDisponible())
			return false;
		
		if (!monstre.estVivant())
			return false;
		
		Position pos = carte.getPosContenu(monstre);
		if (pos == null)
			return false;
		
		Position posJoueur = null;
		
		// Verifier s'il y a un joueur a coté
		if (carte.getCase(pos.getX() - 1, pos.getY()).contientJoueur()) {
			posJoueur = new Position(pos.getX() - 1, pos.getY());
		}
		else if (carte.getCase(pos.getX(), pos.getY() - 1).contientJoueur()) {
			posJoueur = new Position(pos.getX(), pos.getY() - 1);
		}
		else if (carte.getCase(pos.getX() + 1, pos.getY()).contientJoueur()) {
			posJoueur = new Position(pos.getX() + 1, pos.getY());
		}
		else if (carte.getCase(pos.getX(), pos.getY() + 1).contientJoueur()) {
			posJoueur = new Position(pos.getX(), pos.getY() + 1);
		}
		
		// S'il y en a un, l'attaquer
		if (posJoueur != null) {
			Joueur cible = (Joueur)carte.getCase(posJoueur.getX(), posJoueur.getY()).getContenu();
			int degats = monstre.attaquer(cible);
			if (degats > 0)
				log.add(monstre.getNom() + " attaque " + cible.getNom() + " (-" + degats + ")");
			return true;
		}

		// S'il y en a pas
		else {
			
			// Choisir une direction au hasart
			int direction = new Random().nextInt(3);		
			
			// Boucle avec 4 iterations parce qu'il y a 4 directiones possibles
			boolean deplace = false;
			int i = 0;
			// Tant que le monstre ne s'est pas deplace et que les 4 direction n'ont pas ete testees
			while (!deplace && i < 4) {
				
				// Se deplacer vers cette direction
				if (direction == 0) {
					deplace = monstre.seDeplacer(carte.getCase(pos.getX() - 1, pos.getY()));
				}
				if (direction == 1) {
					deplace = monstre.seDeplacer(carte.getCase(pos.getX(), pos.getY() - 1));
				}
				if (direction == 2) {
					deplace = monstre.seDeplacer(carte.getCase(pos.getX() + 1, pos.getY()));
				}
				if (direction == 3) {
					deplace = monstre.seDeplacer(carte.getCase(pos.getX(), pos.getY() + 1));
				}
				
				// On increment direction pour essayer de se deplacer dans une autre direction
				if (!deplace) {
					if (direction < 3)
						direction ++;
					else
						direction = 0;
				}
				
				i++;
				
			}
			
			return deplace;
			
		}
	}

}
