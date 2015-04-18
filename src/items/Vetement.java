package items;

public class Vetement extends Objet {
	private int encombrement;
	private int protection;
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
}
