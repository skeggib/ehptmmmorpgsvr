package items;

public abstract class Vetement extends Equipable {
	
	/*
	 * Constructeurs
	 */
	
	public Vetement () {
		super();
	}
	
	public Vetement(int qualite){
		super(qualite);
	}

	/*
	 * Variables
	 */

	private int protection;
	private int bonusForce;
	private int bonusAdresse;
	private int bonusResistance;
	
	/*
	 * Methodes d'acces
	 */

	public int getProtection() {
		return protection;
	}

	public void setProtection(int protection) {
		this.protection = protection;
	}

	public int getBonusForce() {
		return bonusForce;
	}

	public void setBonusForce(int bonusForce) {
		this.bonusForce = bonusForce;
	}

	public int getBonusAdresse() {
		return bonusAdresse;
	}

	public void setBonusAdresse(int bonusAdresse) {
		this.bonusAdresse = bonusAdresse;
	}

	public int getBonusResistance() {
		return bonusResistance;
	}

	public void setBonusResistance(int bonusResistance) {
		this.bonusResistance = bonusResistance;
	}

}
