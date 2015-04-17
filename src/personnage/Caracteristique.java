package personnage;
/**
 * 
 * @author Kevin
 *
 */
public class Caracteristique {
	/**
	 * Variable privé stockant la force, adresse et resistance d'un personnage
	 */
	private int force;
	private int adresse;
	private int resistance;
		
	/**
	 * 
	 * @return force
	 */
	public int getForce () {
		return this.force;
	}
	/**
	 * 
	 * @return adresse
	 */
	public int getAdresse () {
		return this.adresse;
	}
	/**
	 * 
	 * @return resistance
	 */
	public int getResistance () {
		return this.resistance;
	}

	/**
	 * Change la valeur de Force
	 * @param value valeur affectée a Force
	 */
	public void setForce (int value) {
		this.force = value;
	}
	/**
	 * Change la valeur de Adresse
	 * @param value valeur affectée a Adresse
	 */
	public void setAdresse (int value) {
		this.adresse = value;
	}
	/**
	 * Change la valeur de Resistance
	 * @param value valeur affectée a Resistance
	 */
	public void setResistance (int value) {
		this.resistance = value;
	}
	
	
}
