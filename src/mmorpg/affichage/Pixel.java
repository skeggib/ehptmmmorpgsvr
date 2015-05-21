package mmorpg.affichage;

public class Pixel {

	private char car;
	
	/**
	 * Couleur du type :
	 * "BLACK"
	 * "RED"
	 * "DEFAULT"
	 * etc...
	 */
	private String couleur;
	private String couleurFond;
	
	/**
	 * Contructeur par defaut
	 */
	public Pixel() {
		this.setCar(' ');
		this.setCouleur("WHITE");
		this.setCouleurFond("BLACK");
	}
	
	/**
	 * Constructeur par parametres 
	 * @param car Caractere
	 * @param couleur Couleur
	 * @param couleurFond Couleur de fond
	 */
	public Pixel(char car, String couleur, String couleurFond) {
		this.car = car;
		this.setCouleur(couleur);
		this.setCouleurFond(couleurFond);
	}
	
	/**
	 * Contructeur par copie
	 * @param pixel
	 */
	public Pixel(Pixel pixel) {
		this.car = pixel.car;
		this.couleur = pixel.couleur;
		this.couleurFond = pixel.couleurFond;
	}
	
	public void setCar(char car) {
		this.car = car;
	}
	
	public char getCar() {
		return this.car;
	}
	
	public String getCouleur() {
		return Couleur.getCouleur(this.couleur);
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	
	public String getCouleurFond() {
		return Couleur.getCouleur(this.couleurFond);
	}
	
	public void setCouleurFond(String couleurFond) {
		this.couleurFond = "BACK_" + couleurFond;
	}
	
	public String getPixelCouleur() {
		return this.getCouleur() + this.getCouleurFond() + this.getCar() + Couleur.getCouleur("DEFAULT");
	}
	
	public String toString() {
		return this.car + " (" + this.couleur + ")";
	}
}