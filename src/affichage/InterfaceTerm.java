package affichage;

public class InterfaceTerm {

	private int largeurCaseCarte;
	private int hauteurCaseCarte;
	private static int NB_CASES_AFFICHEES_X = 9;
	private static int NB_CASES_AFFICHEES_Y = 9;
	
	/**
	 * Tailles de l'interface possibles
	 */
	public static final String[] TAILLES = {"grande", "moyenne", "petite"};
	private int taille;
	
	// Largeur des espaces entre chaque cases
	private static int LARGEUR_ESPACE_CARTE = 1;
	private boolean espace = false;
	
	private Matrice matrice;
	
	public InterfaceTerm() {
		this.setTaille(0);
		this.creerMatrice();
	}
	
	/**
	 * Constucteur par taille
	 * @param taille Index de la taille voulue (a choisir dans TAILLES)
	 */
	public InterfaceTerm(int taille) {
		this.setTaille(taille);
		this.creerMatrice();
	}
	
	private void setTaille(int taille) {
		// Si la taille passee en parametre correspond a une case de la liste des tailles
		if (taille >= 0 && taille < InterfaceTerm.TAILLES.length)
			this.taille = taille;
		else
			this.taille = 0;
		
		switch (InterfaceTerm.TAILLES[this.taille]) {
		case "grande":
			this.largeurCaseCarte = 7;
			this.hauteurCaseCarte = 4;
			break;
		case "moyenne":
			this.largeurCaseCarte = 5;
			this.hauteurCaseCarte = 3;
			break;
		case "petite":
			this.largeurCaseCarte = 1;
			this.hauteurCaseCarte = 1;
			break;
		}
	}
	
	private void creerMatrice() {
		int largeur = this.largeurCaseCarte * InterfaceTerm.NB_CASES_AFFICHEES_X;
		if (this.espace)
			largeur += InterfaceTerm.LARGEUR_ESPACE_CARTE * (InterfaceTerm.NB_CASES_AFFICHEES_X + 1);

		int hauteur = this.hauteurCaseCarte * InterfaceTerm.NB_CASES_AFFICHEES_Y;
		if (this.espace)
			hauteur += InterfaceTerm.LARGEUR_ESPACE_CARTE * (InterfaceTerm.NB_CASES_AFFICHEES_Y + 1);
		
		this.matrice = new Matrice(largeur, hauteur);
	}
	
	public String toString() {
		String rtrn = new String();
		rtrn += "Taille interface : " + InterfaceTerm.TAILLES[this.taille];
		rtrn += "\n";
		rtrn += "Matrice : " + this.matrice.getLargeur() + "x" + this.matrice.getHauteur();
		
		return rtrn;
	}
}
