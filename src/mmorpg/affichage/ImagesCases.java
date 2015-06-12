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
	
	// Tableau qui va contenir les images deja chargees (pour ne pas lire le fichier a chaque fois)
	private static Image[][] tabImg;
	
	
	
	
	/**
	 * Retourne l'image correspondante au contenu de la case
	 * @param taille Taille de l'image
	 * @param c Case
	 * @return
	 * @throws Exception
	 */
	public static Image getImage(int taille, Case c) throws Exception {
		// Creer le tableau s'il n'existe pas
		if (ImagesCases.tabImg == null)
			ImagesCases.tabImg = new Image[InterfaceTerm.TAILLES.length][ContenuCase.NB_TYPES];
		
		if (taille < 0 || taille >= InterfaceTerm.TAILLES.length)
			return null;
		
		// Si la case est null on creer une case par defaut
		if (c == null)
			c = new Case();
		
		// Si la case contient null on lui donne un type Inconnu
		if (c.getContenu() == null)
			c.ajoutContenu(new Inconnu());
		
		int num = c.getContenu().getNumero();

		if (num < 0 || num >= ImagesCases.tabImg[taille].length)
			return null;

		// Si l'image existe deja dans le tableau
		if (ImagesCases.tabImg[taille][num] != null)
			return ImagesCases.tabImg[taille][num];
		
		
		// Si non on charge l'image
		
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
		
		String str;
		try {
			str = LectureRessource.lire("images/" + nomContenu + "/" + InterfaceTerm.TAILLES[taille]);
		} catch (Exception e) {
			throw new Exception("Impossible de charger l'image " + nomContenu + "/" + InterfaceTerm.TAILLES[taille], e);
		}
		
		String[] couleur = {"WHITE"}; 
		try {
			couleur = LectureRessource.lire("images/" + nomContenu + "/color").split("\n");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		if (rtrn.chargerString(str)) {
			rtrn.setCouleur(couleur[0]);
		}
		
		ImagesCases.tabImg[taille][num] = rtrn;
		
		return rtrn;
	}

}
