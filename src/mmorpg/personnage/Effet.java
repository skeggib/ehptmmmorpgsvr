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
	// TODO skeggib : UML suppression de reinitiliserTimer()

	/*
	 * Constante
	 */
	
	private static final long serialVersionUID = 6716938930894174476L;

	/*
	 * Variable d'instance
	 */
	
	private int tourRestant;

	/*
	 * Constructeurs
	 */

	public Effet() {
		super();
	}

	public Effet(Effet ef) {
		super(ef);
		this.tourRestant = ef.getTourRestant();
	}

	public Effet(int tourRestant) {
		super();
		this.tourRestant = tourRestant;
	}

	public Effet(int force, int adresse, int resistance, int maniabilite,
			int impact, int tourRestant) {
		super(force, adresse, resistance, maniabilite, impact);
		this.tourRestant = tourRestant;
	}

	/*
	 * Methode
	 */

	/**
	 * Applique l'effet a l'entite : Ajoute les caracteristiques a celle de
	 * l'Entite
	 * 
	 * @param cible
	 *            EntiteVivante recevant l'ajout de caracteristiques
	 */
	public void appliquer(EntiteVivante cible) {
		cible.getCaractEffet().ajouterForce(this.getForce());
		cible.getCaractEffet().ajouterAdresse(this.getAdresse());
		cible.getCaractEffet().ajouterResistance(this.getResistance());
		cible.getCaractEffet().ajouterManiabilite(this.getManiabilite());
		cible.getCaractEffet().ajouterImpact(this.getImpact());
	}

	/**
	 * Decremente le nombre de tour pendant lequel l'effet est actif
	 * 
	 * @return true si l'effet est terminer, false sinon
	 */
	public boolean decrementerTour() {
		this.tourRestant--;

		if (this.tourRestant == 0) {
			return true;
		}
		return false;
	}
	
	/*
	 * Methode d'acces
	 */

	public int getTourRestant() {
		return this.tourRestant;
	}
}
