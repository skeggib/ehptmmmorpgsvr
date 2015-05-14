package affichage;

import personnage.Joueur;

public class Test {

	public static void main(String[] args) {
				
		Joueur joueur = new Joueur("joueur");
		InterfaceTerm inter = new InterfaceTerm(0);
		
		inter.chargerCarte("../ressources/carte/test");
		inter.getCarte().getCase(3, 3).ajoutContenu(joueur);
		
		if (!inter.afficher(joueur))
			System.out.println("Impossible d'afficher l'interface");
		
	}

}
