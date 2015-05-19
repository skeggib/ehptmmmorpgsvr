package personnage;

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
		cible
	}

	public void reinitialiserTimer(int tourRestant){
		this.tourRestant = tourRestant;
	}
	
	public boolean decrementerTour() {
		this.tourRestant--;

		if (this.tourRestant == 0) {
			return true;
		}
		return false;
	}
}
