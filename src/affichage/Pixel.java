package affichage;

/**
 * Représente un "pixel" du terminal, 
 * c'est en réalité juste un caractére 
 * et deux couleur (front et back).
 * @author skeggib
 *
 */
public class Pixel {
	private char c;
	private String backColor = new String();
	private String frontColor = new String();
	
	public Pixel() {
		this.c = ' ';
		this.backColor = Couleur.BLACK;
		this.frontColor = Couleur.WHITE;
	}
	
	/**
	 * Constructeur
	 * @param c Caractère
	 * @param front Couleur du caractère
	 * @param back COuleur du fond
	 */
	public Pixel(char c, String front, String back) {
		this.c = c;
		this.backColor = back;
		this.frontColor = front;
	}
	
	public char getChar() {
		return c;
	}
	
	public String getBackCouleur() {
		return backColor;
	}
	
	public String getFrontCouleur() {
		return frontColor;
	}
}
