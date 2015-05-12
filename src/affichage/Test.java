package affichage;

import personnage.Joueur;

public class Test {

	public static void main(String[] args) {
		
		Joueur joueur = new Joueur();
		InterfaceTerm inter = new InterfaceTerm(1);
		
		inter.chargerCarte("../ressources/carte/test");
		inter.getCarte().getCase(3, 3).changerContenu(joueur);
		
		inter.afficher(joueur);
		
	}

}
