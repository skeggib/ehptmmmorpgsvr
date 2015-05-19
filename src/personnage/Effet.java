package personnage;

public class Effet extends Caracteristique {

	private int tourRestant;

	/*
	 * Methode
	 */

	public boolean decrementerTour() {
		this.tourRestant--;

		if (this.tourRestant == 0) {
			return true;
		}

		return false;
	}
}
