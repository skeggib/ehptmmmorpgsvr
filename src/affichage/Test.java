package affichage;

public class Test {

	public static void main(String[] args) {
				
		Matrice matr1 = new Matrice(50, 20);
		matr1.dessinerRectangle(0, 0, matr1.getLargeur(), matr1.getHauteur(), new Pixel('#', "WHITE", "RED"));
		
		Matrice matr2 = new Matrice(10, 5);
		matr2.dessinerTexte(1, 1, "Salut", "BLACK", "WHITE");
		
		matr1.dessinerMatrice(47, 10, matr2);
		
		matr1.afficher();
		
	}

}
