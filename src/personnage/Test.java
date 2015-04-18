package personnage;


public class Test {

	public static void main(String[] args) {

		Joueur joueur = new Joueur ();
		Joueur cible = new Joueur ();
		cible.getCaracteristique().setForce(5);
		cible.getCaracteristique().setAdresse(5);
		cible.getCaracteristique().setResistance(5);
		joueur.getCaracteristique().setForce(5);
		joueur.getCaracteristique().setAdresse(5);
		joueur.getCaracteristique().setResistance(5);
		
		System.out.println("\n   vie avant attaque : " + cible.getVie().getVie() + "\n");
		joueur.attaquer(cible);
		System.out.println("\n   vie apres attaque : " + cible.getVie().getVie() + "\n");
		joueur.attaquer(cible);
		System.out.println("\n   vie apres attaque : " + cible.getVie().getVie() + "\n");
		joueur.attaquer(cible);
		System.out.println("\n   vie apres attaque : " + cible.getVie().getVie() + "\n");
		
		cible.getVie().ajouterVie(6);

		System.out.println("\n   vie apres soin de la cible : " + cible.getVie().getVie() + "\n");
		
		
//		System.out.println(listObjet.toString());
//	    listObjet.remove(listObjet.indexOf(car3));
//		listObjet.clear();
	}    
	    
}


