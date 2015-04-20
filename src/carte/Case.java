package carte;

import affichage.Image;
import affichage.Couleur;

public class Case {
	public static final int JOUEUR_PRINCIPAL = 0;
	public static final int AUTRE_JOUEUR = 1;
	public static final int VIDE = 2;
	public static final int MUR = 3;
	public static final int MONSTRE = 4;
	public static final int OBJET = 5;
	
	private int valeur;
	private Image img;
	
	public Case(int val) {
		this.valeur = val;
		this.chargerImages();		
	}
	
	public int getValeur() {
		return this.valeur;
	}
	
	public void setValeur(int val) {
		this.valeur = val;
	}
	
	private void chargerImages() {
		switch (valeur) {
			case Case.JOUEUR_PRINCIPAL:
				this.img = new Image();
				this.img.chargerString("  o  \n --- \n  |  \n / \\ ");
				this.img.setCouleur(Couleur.GREEN);
				break;
			case Case.AUTRE_JOUEUR:
				this.img = new Image();
				this.img.chargerString("  o  \n --- \n  |  \n / \\ ");
				this.img.setCouleur(Couleur.BLUE);
				break;
			case Case.VIDE:
				this.img = new Image();
				this.img.chargerString("     \n     \n     \n     ");
				break;
			case Case.MUR:
				this.img = new Image();
				this.img.chargerString("#####\n#####\n#####\n#####");
				this.img.setCouleur(Couleur.WHITE);
				break;
			case Case.MONSTRE:
				this.img = new Image();
				this.img.chargerString(" / \\ \n|. .|\n --- \n / \\ ");
				this.img.setCouleur(Couleur.PURPLE);
				break;
			case Case.OBJET:
				this.img = new Image();
				this.img.chargerString("/---\\\n| X |\n| X |\n\\---/");
				this.img.setCouleur(Couleur.WHITE);
				break;
			default:
				this.img = new Image();
				this.img.chargerString("     \n     \n     \n     ");
				break;
		}
	}
}
