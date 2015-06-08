package mmorpg.affichage.fenetre;

import java.util.ArrayList;

import mmorpg.affichage.Matrice;
import mmorpg.affichage.Pixel;
import mmorpg.exceptions.affichage.fenetre.CantDrawWindowException;
import mmorpg.personnage.Joueur;

public class FenetreInfosJoueur extends Fenetre {

	private static final long serialVersionUID = 5841962965164032985L;
	
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
	
	private boolean dessinerInfos() throws CantDrawWindowException {
		if (this.joueur == null)
			throw new CantDrawWindowException("Le joueur n'est pas defini");
		
		Pixel remplissage = new Pixel(' ', "BLACK", "WHITE");
		int matriceH = this.getMatrice().getHauteur();
		int matriceW = this.getMatrice().getLargeur();
		this.getMatrice().dessinerRectangle(0, 0, matriceW, matriceH, remplissage);
		
		ArrayList<String> lignes = new ArrayList<String>();
		lignes.add("Nom: " + this.joueur.getNom());
		lignes.add("PA:  " + this.joueur.getPointAction());
		lignes.add("Vie: " + this.joueur.getVie());
		lignes.add("");
		lignes.add("Experience: " + this.joueur.getExperience());
		lignes.add("");
		lignes.add("Force:   " + this.joueur.getCaractTotal().getForce());
		lignes.add("Adresse: " + this.joueur.getCaractTotal().getAdresse());
		lignes.add("Resist.: " + this.joueur.getCaractTotal().getResistance());
		lignes.add("Impact:  " + this.joueur.getCaractTotal().getImpact());
		lignes.add("Maniab.: " + this.joueur.getCaractTotal().getManiabilite());
		
		for (int i = 0; i < lignes.size(); i++) {
			this.getMatrice().dessinerTexte(0, i, lignes.get(i), "BLACK", "WHITE");
		}
		
		return true;
	}
	
	public Matrice getMatriceFen() throws CantDrawWindowException {
		try {
			this.dessinerInfos();
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
