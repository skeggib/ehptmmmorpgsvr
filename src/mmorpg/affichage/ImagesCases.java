package mmorpg.affichage;

import mmorpg.carte.Case;
import mmorpg.carte.ContenuCase;
import mmorpg.carte.Inconnu;
import mmorpg.fichiers.LectureRessource;

/**
 * 
 * Contient les images correspondantes aux differents types de cases.
 * 
 * @author Sébastien Klasa
 *
 */
public abstract class ImagesCases {
	
	private static Image[][] tabImg;
	
	public static Image getImage(int taille, Case c) {
		if (ImagesCases.tabImg == null)
			ImagesCases.tabImg = new Image[InterfaceTerm.TAILLES.length][ContenuCase.NB_TYPES];
		
		if (taille < 0 || taille >= InterfaceTerm.TAILLES.length)
			return null;

		if (c == null)
			c = new Case();
		
		if (c.getContenu() == null)
			c.ajoutContenu(new Inconnu());
		
		int num = c.getContenu().getNumero();

		if (num < 0 || num >= ImagesCases.tabImg[taille].length)
			return null;

		if (ImagesCases.tabImg[taille][num] != null)
			return ImagesCases.tabImg[taille][num];
		
		Image rtrn = new Image();
		
		String nomContenu = new String();
		switch (num) {
		case ContenuCase.INCONNU:
			nomContenu = "inconnu";
			break;
		case ContenuCase.JOUEUR:
			nomContenu = "joueurPrincipal";
			break;
		case ContenuCase.MONSTRE:
			nomContenu = "monstre";
			break;
		case ContenuCase.MUR:
			nomContenu = "mur";
			break;
		case ContenuCase.OBJET:
			nomContenu = "objet";
			break;
		case ContenuCase.PNJ:
			nomContenu = "autreJoueur";
			break;
		case ContenuCase.VIDE:
			nomContenu = "vide";
			break;
		case ContenuCase.COFFRE:
			nomContenu = "coffre";
			break;
		}
		
		String str = LectureRessource.lire("images/" + nomContenu + "/" + InterfaceTerm.TAILLES[taille]);
		
		String[] couleur = LectureRessource.lire("images/" + nomContenu + "/color").split("\n");
		
		if (rtrn.chargerString(str)) {
			rtrn.setCouleur(couleur[0]);
		}
		
		ImagesCases.tabImg[taille][num] = rtrn;
		
		return rtrn;
	}

}
