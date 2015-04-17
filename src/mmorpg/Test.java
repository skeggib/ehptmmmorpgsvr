package mmorpg;
import affichage.*;

public class Test {

	public static void main(String[] args) {
		Matrice mat = new Matrice(100, 50);
		Pixel pix = new Pixel('t', Couleur.GREEN);
		mat.dessinerRectangle(0, 0, 10, 10, pix);
		mat.afficher();
	}

}
