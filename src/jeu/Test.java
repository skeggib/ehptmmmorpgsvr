package jeu;

public class Test {

	public static void main(String[] args) {
		
		Log log = new Log();
		
		log.add("Salut !");
		log.add("Salut1 !");
		log.add("Salut2 !");
		log.add("Salut3 !");
		log.add("Salut4 !");
		log.add("Salut5 !");
		log.add("Salut6 !");
		log.add("Salut7 !");
		
		String[] tab = log.getDerniersMessages(300);
		
		for (int i = 0; i < tab.length; i++)
			System.out.println(tab[i]);

	}

}
