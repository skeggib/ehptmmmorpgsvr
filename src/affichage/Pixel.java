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
