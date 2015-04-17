package personnage;

import java.util.Random;


public class Capacite {
	
	private static final int DE_MAX = 6;
	private static final int DE_MIN = 1;
	
	private static Random rand = new Random();
	
	public static int getRandomInitiative (int adresse, int encombrement) {
		return (Capacite.calculDeRandom(adresse) + Capacite.calculDeRandom(encombrement));
	}		
	public static int getRandomAttaque (int adresse, int maniabilite) {
		return (Capacite.calculDeRandom(adresse) + Capacite.calculDeRandom(maniabilite));
	}
	public static int getRandomEsquive (int adresse, int encombrement) {
		return (Capacite.calculDeRandom(adresse) + Capacite.calculDeRandom(encombrement));
	}	
	public static int getRandomDefense(int defense, int solidite) {
		return (Capacite.calculDeRandom(defense) + Capacite.calculDeRandom(solidite));
	}	
	public static int getRandomDegat (int force, int impact) {
		return (Capacite.calculDeRandom(force) + Capacite.calculDeRandom(impact));
	}
	
	private static int calculDeRandom (int degres) {
		int nombreDe = Capacite.calculNiveau(degres);
		int result = 0;
		for(int i = 0; i < nombreDe; i++){
			result += (Capacite.rand.nextInt((DE_MAX - DE_MIN) + 1) + DE_MIN);
		}
		result += calculBonus(degres);
		return result;
	}	
	private static int calculBonus (int degres) {
		return (degres%3);
	}	
	private static int calculNiveau (int degres) {
		return (degres - Capacite.calculBonus(degres))/3;
	}
}
