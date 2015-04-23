package personnage;

/**
 * Cette Classe contient les caracteristiques d'une entite vivante
 * @author armya
 *
 */
public class Caracteristique {

	private int force;
	private int adresse;
	private int resistance;

	/**
	 * Retourne la force (d'une entite)
	 * @return force
	 */
	public int getForce () {
		return this.force;
	}
	/**
	 * Retourne l'adresse (d'une entite)
	 * @return adresse
	 */
	public int getAdresse () {
		return this.adresse;
	}
	
	/**
	 * Retourne la resistance (d'une entite)
	 * @return resistance
	 */
	public int getResistance () {
		return this.resistance;
	}

	/**
	 * Change la valeur de Force
	 * @param value valeur affectee a Force
	 */
	public void setForce (int value) {
		if (value < 0) {
			this.force = value;
		}
	}
	
	/**
	 * Change la valeur de Adresse
	 * @param value valeur affectee a Adresse
	 */
	public void setAdresse (int value) {
		if (value < 0) {
			this.adresse = value;
		}
	}
	
	/**
	 * Change la valeur de Resistance
	 * @param value valeur affectee a Resistance
	 */
	public void setResistance (int value) {
		if (value < 0) {
			this.resistance = value;
		}
	}


}
