package affichage.fenetre;

import jeu.Log;

public class Test {

	public static void main(String[] args) {
		
		FenetreLog fen = new FenetreLog(20, 10);
		Log log = new Log();
		
		log.add("Salut 1");
		log.add("Salut 2");
		log.add("Salut 3");
		log.add("Salut 4");
		log.add("Salut 5");
		log.add("Salut 6");
		log.add("Salut 7");
		log.add("Salut 8");
		log.add("Salut 9");
		log.add("Salut 10");
		log.add("Salut 11");
		log.add("Salut 12");
		log.add("Salut 13");
		log.add("Salut 14");
		log.add("Salut 15");
		
		fen.setLog(log);
		
		fen.getMatriceFen().afficher();
		
		log.add("Test");
		log.add("Message");
		
		fen.getMatriceFen().afficher();

	}

}
