package personnage;

@SuppressWarnings("unused")
public class Effet {

	private int force;
	private int pointAction;
	private int adresse;
	private int resistance;
	private int esquive;

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
	
	/*
	 * Methode d'acces
	 */

	public int getEsquive() {
		return esquive;
	}

	private void setEsquive(int esquive) {
		this.esquive = esquive;
	}

	public int getResistance() {
		return resistance;
	}

	private void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public int getAdresse() {
		return adresse;
	}

	private void setAdresse(int adresse) {
		this.adresse = adresse;
	}

	public int getPointAction() {
		return pointAction;
	}

	private void setPointAction(int pointAction) {
		this.pointAction = pointAction;
	}

	public int getForce() {
		return force;
	}

	private void setForce(int force) {
		this.force = force;
	}
}
