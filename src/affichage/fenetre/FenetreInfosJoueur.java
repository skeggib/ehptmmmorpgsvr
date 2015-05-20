package affichage.fenetre;

import java.util.ArrayList;

import affichage.Matrice;
import affichage.Pixel;
import personnage.Joueur;

public class FenetreInfosJoueur extends Fenetre {

	Joueur joueur;
	
	/* --- CONSTRUCTEURS --- */
	
	public FenetreInfosJoueur() {
		super();
		this.setTitre("Infos joueur");
	}
	
	public FenetreInfosJoueur(int w, int h) {
		super(w, h);
		this.setTitre("Infos joueur");
	}
	
	public FenetreInfosJoueur(Joueur joueur) {
		this();
		this.setJoueur(joueur);
	}
	
	public FenetreInfosJoueur(Joueur joueur, String titre) {
		this(joueur);
		this.setTitre(titre);
	}
	
	public FenetreInfosJoueur(Joueur joueur, int w, int h, String titre) {
		this(w, h);
		this.setJoueur(joueur);
		this.setTitre(titre);
	}
	
	/* --- METHODES --- */
	
	private boolean dessinerInfos() {
		if (this.joueur == null)
			return false;
		
		Pixel remplissage = new Pixel(' ', "BLACK", "WHITE");
		int matriceH = this.getMatrice().getHauteur();
		int matriceW = this.getMatrice().getLargeur();
		this.getMatrice().dessinerRectangle(0, 0, matriceW, matriceH, remplissage);
		
		ArrayList<String> lignes = new ArrayList<String>();
		lignes.add("Nom: " + this.joueur.getNom());
		lignes.add("PA:  " + this.joueur.getPointAction());
		lignes.add("Vie: " + this.joueur.getVie());
		
		for (int i = 0; i < lignes.size(); i++) {
			this.getMatrice().dessinerTexte(0, i, lignes.get(i), "BLACK", "WHITE");
		}
		
		return true;
	}
	
	public Matrice getMatriceFen() {
		this.dessinerInfos();
		return super.getMatriceFen();
	}
	
	/* --- GETTERS / SETTERS --- */
	
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}
	
}
