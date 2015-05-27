package mmorpg.personnage;


/**
 * 
 * Contient les caracteristiques d'un effet</br>
 * 
 * Un effet est un ajout de caracteristique limite le temps
 * 
 * @author armya
 *
 */
public class Effet extends Caracteristique {

	private int tourRestant;

	/*
	 * Constructeurs
	 */

	public Effet() {
		super();
	}
	
	public Effet(int tourRestant) {
		super();
		this.tourRestant = tourRestant;
	}
	
	public Effet (int force, int adresse, int resistance, int maniabilite, int impact, int tourRestant){
		super( force,  adresse,  resistance,  maniabilite,  impact);
		this.tourRestant = tourRestant;
	}

	/*
	 * Methode
	 */
	
	public void appliquerEffet(EntiteVivante cible){
		cible.getCaractEffet().ajouterForce(this.getForce());
		cible.getCaractEffet().ajouterAdresse(this.getAdresse());
		cible.getCaractEffet().ajouterResistance(this.getResistance());
		cible.getCaractEffet().ajouterManiabilite(this.getManiabilite());
		cible.getCaractEffet().ajouterImpact(this.getImpact());
	}

	public void reinitialiserTimer(int tourRestant){
		this.setTourRestant(tourRestant);
	}
	
	public boolean decrementerTour() {
		this.tourRestant--;

		if (this.tourRestant == 0) {
			return true;
		}
		return false;
	}

	public int getTourRestant() {
		return tourRestant;
	}

	private void setTourRestant(int tourRestant) {
		this.tourRestant = tourRestant;
	}
}
