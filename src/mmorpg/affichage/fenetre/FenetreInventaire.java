package mmorpg.affichage.fenetre;

import mmorpg.affichage.Matrice;
import mmorpg.affichage.Pixel;
import mmorpg.exceptions.affichage.fenetre.CantDrawWindowException;
import mmorpg.items.Item;
import mmorpg.personnage.Equipement;
import mmorpg.personnage.Inventaire;
import mmorpg.personnage.Joueur;

public class FenetreInventaire extends Fenetre {
	
	private static final long serialVersionUID = 3778417611018397347L;
	
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
	
	private boolean dessinerInventaire() throws CantDrawWindowException {
		if (this.joueur == null)
			throw new CantDrawWindowException("Le joueur n'est pas defini");
		
		// --- Fond
		Pixel p = new Pixel(' ', "BLACK", "WHITE");
		this.getMatrice().dessinerRectangle(0, 0, this.getLargeur(), this.getHauteur(), p);

		
		String texte;
		
		String titreCouleur = "BLACK";
		String titreCouleurFond = "CYAN";
		
		// --- Inventaire
		
		// Titre
		this.getMatrice().dessinerTexte(3, 0, "Inventaire", titreCouleur, titreCouleurFond);
		
		Inventaire inventaire = this.joueur.getInventaire();
		int tailleInventaire = inventaire.getTaille();
		Item objet;
		for (int i = 0; i < tailleInventaire; i++) {
			objet = inventaire.get(i);
			texte = i+1 + ". " + objet.getNom() + " (" + objet.getType() + ")";
			this.getMatrice().dessinerTexte(0, i + 2, texte, "BLACK", "WHITE");
		}
		
		// --- Equipement
		int moitierLargeur = this.getLargeur() / 2;
		
		// Titre
		this.getMatrice().dessinerTexte(moitierLargeur + 3, 0, "Equipement", titreCouleur, titreCouleurFond);
		
		Equipement equipement = this.joueur.getEquipement();
		int tailleEquipement = equipement.getTaille();
		for (int i = 0; i < tailleEquipement; i++) {
			objet = equipement.get(i);
			texte = i+1 + ". " + objet.getNom() + " (" + objet.getType() + ")";
			this.getMatrice().dessinerTexte(moitierLargeur, i + 2, texte, "BLACK", "WHITE");
		}
		
		return true;
	}
	
	public Matrice getMatriceFen() throws CantDrawWindowException {
		try {
			this.dessinerInventaire();
			return super.getMatriceFen();
		} catch (CantDrawWindowException e) {
			throw e;
		}
	}
	
	/* --- GETTERS / SETTERS --- */
	
	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

}
