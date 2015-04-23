package affichage;

import carte.Carte;

public class Test {

	public static void main(String[] args) {
		
		Carte carte = new Carte("");
		InterfaceTerm inter = new InterfaceTerm();
		System.out.println(inter.dessinerCarte(carte));
		inter.afficher();
		inter.afficher();
		inter.afficher();
		
	}

}
