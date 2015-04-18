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
	private String color = new String();
	
	public Pixel() {
		this.c = ' ';
		this.color = Couleur.WHITE;
	}
	
	/**
	 * Constructeur
	 * @param c Caractère
	 * @param front Couleur du caractère
	 */
	public Pixel(char c, String front) {
		this.c = c;
		this.color = front;
	}
	
	public char getChar() {
		return c;
	}
	
	public void setChar(char c) {
		this.c = c;
	}
	
	public String getFrontCouleur() {
		return color;
	}
	
	public String toStringCouleur() {
		return this.color + c;
	}
}
