package mmorpg.affichage.fenetre;

import mmorpg.affichage.Image;

public class FenetreFinJeu extends Fenetre {
	
	private static final long serialVersionUID = 4813274906987852647L;
	
	
	
	
	
	
	
	/* --- CONSTRUCTEURS --- */

	public FenetreFinJeu() {
		super();
		this.setTitre("Fin du jeu");
		this.dessinerFinJeu();
	}
	
	
	
	
	
	
	
	
	/* --- METHODES --- */
	
	private boolean dessinerFinJeu() {
		
		Image image = new Image();
		
		String str = "";
		
		str += "'  ` '  `  '  `  '  `  '\n"
			 + "~ ~  Vous etes mort  ~ ~\n"
			 + ",  . ,  .  ,  .  ,  .  ,";
		
		if (!image.chargerString(str))
			return false;
		
		this.setTaille(image.getLargeur() + 4, image.getHauteur() + 4);
		
		
		this.getMatrice().dessinerImage(1, 1, image);
		
		
		return true;
	}

}
