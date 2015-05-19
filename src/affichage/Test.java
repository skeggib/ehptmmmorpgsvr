package affichage;

import affichage.fenetre.Fenetre;

public class Test {

	public static void main(String[] args) {
				
		Matrice matr1 = new Matrice(50, 20);
		Fenetre fen = new Fenetre(40, 10, "Test");
		
		matr1.dessinerFenetre(1, 1, fen);
		
		matr1.afficher();
		
	}

}
