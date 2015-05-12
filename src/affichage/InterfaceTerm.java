package affichage;

import personnage.Joueur;
import carte.Carte;
import carte.Position;

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
	private Carte carte = new Carte();
	
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

	public boolean afficher(Joueur joueur) {
		if (!this.dessinerInterface(joueur))
			return false;
		
		this.matrice.afficher();
		
		return true;
	}
	
	private boolean dessinerInterface(Joueur joueur) {
		if (!this.dessinerCarte(joueur))
			return false;
		
		return true;
	}
	
	private boolean dessinerCarte(Joueur joueur) { // TODO: Apparement affiche NB_CASES_AFFICHEES_? - 1
		// Image a dessiner
		Image img;
		
		// Position de la case dans la matrice
		int posCaseMatrX;
		int posCaseMatrY;
		
		// Position (sur la carte) de la premiere case affichee
		int posPremCaseX;
		int posPremCaseY;
		
		/* CALCUL DE LA POSITION DE LA PREMIERE CASE AFFICHEE (pour centrer le joueur) */
		
		// Position du joueur sur la carte
		Position posJoueur = this.carte.getPosContenu(joueur);
		if (posJoueur == null)
			return false;
		
		// Calcul de cette position
		posPremCaseX = posJoueur.getX() - InterfaceTerm.NB_CASES_AFFICHEES_X / 2;
		posPremCaseY = posJoueur.getY() - InterfaceTerm.NB_CASES_AFFICHEES_Y / 2;
		
		// Verifier le depassement et le corriger si besoin
		if (posPremCaseX > this.carte.getLargeur() - InterfaceTerm.NB_CASES_AFFICHEES_X)
			posPremCaseX = this.carte.getLargeur() - InterfaceTerm.NB_CASES_AFFICHEES_X;
		else if (posPremCaseX < 0)
			posPremCaseX = 0;
		if (posPremCaseY > this.carte.getHauteur() - InterfaceTerm.NB_CASES_AFFICHEES_Y)
			posPremCaseY = this.carte.getHauteur() - InterfaceTerm.NB_CASES_AFFICHEES_Y;
		else if (posPremCaseY < 0)
			posPremCaseY = 0;
		
		/* DESSIN DES CASES */
		
		for (int i = 0; i < InterfaceTerm.NB_CASES_AFFICHEES_Y; i++) {
			for (int j = 0; j < InterfaceTerm.NB_CASES_AFFICHEES_X; j++) {
				img = new Image();
				img.chargerString(Integer.toString(this.carte.getCase(posPremCaseX + j, posPremCaseY + i).getContenu().getNumero())); // TODO: A changer pour mettre les vrais images
				
				posCaseMatrX = InterfaceTerm.LARGEUR_ESPACE_CARTE + j * (this.largeurCaseCarte + InterfaceTerm.LARGEUR_ESPACE_CARTE);
				posCaseMatrY = InterfaceTerm.LARGEUR_ESPACE_CARTE + i * (this.hauteurCaseCarte + InterfaceTerm.LARGEUR_ESPACE_CARTE);
				
				this.matrice.dessinerImage(posCaseMatrX, posCaseMatrY, img);
			}
		}
		
		return true;
	}
	
	public boolean chargerCarte(String chemin) {
		return this.carte.chargerFichier(chemin);
	}
	
	public Carte getCarte() { // TODO: A enlever
		return this.carte;
	}
	
	public String toString() {
		String rtrn = new String();
		rtrn += "Taille interface : " + InterfaceTerm.TAILLES[this.taille];
		rtrn += "\n";
		rtrn += "Matrice : " + this.matrice.getLargeur() + "x" + this.matrice.getHauteur();
		
		return rtrn;
	}
}
