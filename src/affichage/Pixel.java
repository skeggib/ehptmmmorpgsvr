package affichage;

public class Pixel {

	char car;
	
	/**
	 * Couleur du type :
	 * "BLACK"
	 * "RED"
	 * "DEFAULT"
	 * etc...
	 */
	String couleur;
	
	/**
	 * Contructeur par defaut
	 */
	public Pixel() {
		this.car = ' ';
		this.couleur = "DEFAULT";
	}
	
	/**
	 * Constructeur par parametres 
	 * @param car Caractere
	 * @param couleur Couleur
	 */
	public Pixel(char car, String couleur) {
		this.car = car;
		this.couleur = couleur;
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
}
