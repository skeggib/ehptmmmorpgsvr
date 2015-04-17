package mmorpg;
import affichage.*;

public class Test {

	public static void main(String[] args) {
		Matrice mat = new Matrice(100, 50);
		Pixel pix = new Pixel('#', Couleur.GREEN);
		mat.dessinerRectangle(0, 0, mat.getLargeur(), mat.getHauteur(), pix);
		mat.afficher();
	}

}
