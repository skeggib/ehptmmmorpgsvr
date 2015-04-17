package affichage;

/**
 * Représente un "pixel" du terminal, c'est en réalité juste un caractére et une couleur.
 * @author skeggib
 *
 */
public class Pixel {
	private char c;
	private Couleur color;
	
	public char getChar() {
		return c;
	}
	
	public Couleur getCouleur() {
		return color;
	}
}
