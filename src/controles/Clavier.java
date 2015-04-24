package controles;

import java.util.Scanner;

import personnage.EntiteVivante;

public class Clavier {
	
	private static Scanner sc = new Scanner(System.in);
	
	/**
	 * Constructeur par defaut prive pour ne pas pouvoir instancier un objet de cette classe
	 */
	private Clavier() {};
	
	/**
	 * Demande la saisie d'une direction
	 * @return L'int correspondant a la direction ou -1 si la saisie ne correspond pas a la demande
	 */
	public static int saisieDirection() { // TODO: Utiliser les fleches directionnelles
		System.out.print("Dans quelle direction ? (Haut -> 'z', Bas -> 's', Droite -> 'd', Gauche -> 'q') : ");
		char car = Clavier.saisieCar();
		
		if (car == 'z' || car == 'Z')
			return EntiteVivante.HAUT;
		else if (car == 's' || car == 'S')
			return EntiteVivante.BAS;
		else if (car == 'd' || car == 'D')
			return EntiteVivante.DROITE;
		else if (car == 'q' || car == 'Q')
			return EntiteVivante.GAUCHE;
		else
			return -1;
	}
	
	/**
	 * Demande une saisie et retourne le premier caractere saisit
	 * @return
	 */
	private static char saisieCar() {
		String str = sc.nextLine();
		if (str.isEmpty())
			return ' ';
		else
			return str.charAt(0);
	}
	
	public static int saisieInt() {
		return sc.nextInt();
	}
}
