package mmorpg.affichage.fenetre;

import mmorpg.affichage.Matrice;
import mmorpg.personnage.Joueur;

public class FenetreInventaire extends Fenetre {
	
	private Joueur joueur;
	
/* --- CONSTRUCTEURS --- */
	
	public FenetreInventaire() {
		super();
		this.setTitre("Inventaire");
	}
	
	public FenetreInventaire(int w, int h) {
		super(w, h);
		this.setTitre("Inventaire");
	}
	
	public FenetreInventaire(Joueur joueur) {
		this();
		this.setJoueur(joueur);
	}
	
	public FenetreInventaire(Joueur joueur, String titre) {
		this(joueur);
		this.setTitre(titre);
	}
	
	public FenetreInventaire(Joueur joueur, int w, int h, String titre) {
		this(w, h);
		this.setJoueur(joueur);
		this.setTitre(titre);
	}
	
	/* --- METHODES --- */
	
	private boolean dessinerInventaire() {
		if (this.joueur == null)
			return false;
		
		// TODO: A faire
		
		return true;
	}
	
	public Matrice getMatriceFen() {
		this.dessinerInventaire();
		return super.getMatriceFen();
	}
	
	/* --- GETTERS / SETTERS --- */
	
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

}
