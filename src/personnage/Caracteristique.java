package personnage;

public class Caracteristique {
	
	private int force;
	private int adresse;
	private int resistance;
	

	public int getForce () {
		return this.force;
	}
	public int getAdresse () {
		return this.adresse;
	}
	public int getResistance () {
		return this.resistance;
	}

	public void setForce (int value) {
		this.force = value;
	}
	public void setAdresse (int value) {
		this.adresse = value;
	}
	public void setResistance (int value) {
		this.resistance = value;
	}
	
	
}
