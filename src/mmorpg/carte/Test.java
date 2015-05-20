package mmorpg.carte;

public class Test {

	public static void main(String[] args) {
		
		Carte carte = new Carte("../ressources/carte/test");
		System.out.println(carte);
		
		Inconnu inc = new Inconnu();
		carte.getCase(5, 3).changerContenu(inc);
		
		System.out.println(carte);
		
		System.out.println(carte.getPosContenu(inc));

	}

}
