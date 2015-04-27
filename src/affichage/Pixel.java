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
	 * @param color Couleur du caractère
	 */
	public Pixel(char c, String color) {
		this.c = c;
		this.color = color;
	}
	
	public char getChar() {
		return this.c;
	}
	
	public void setChar(char c) {
		this.c = c;
	}
	
	public String getCouleur() {
		return this.color;
	}
	
	public void setCouleur(String c) {
		this.color = c;
	}
	
	/**
	 * @return La chaine de caracteres qui affiche le caractere du pixel colore dans le terminal
	 */
	public String toStringCouleur() {
		return this.color + c;
	}
}
