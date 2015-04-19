package items;

public class Vetement extends Objet {
	private int encombrement;
	private int protection;
	
	public Vetement () {
		
	}
	/**
	 * Retourne l'encombrement de l'objet
	 * @return encombrement
	 */
	public int getEncombrement () {
		return this.encombrement;
	}
	/**
	 * Retourne la protection de l'objet
	 * @return protection
	 */
	public int getProtection () {
		return this.protection;
	}
	private void setEncombrement (int value) {
		this.encombrement = value;
	}
	private void setProtection (int value) {
		this.protection = value;
	}
}
