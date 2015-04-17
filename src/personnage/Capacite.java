package personnage;

import java.util.Random;


public class Capacite {
	
	private static final int DE_MAX = 6;
	private static final int DE_MIN = 1;
	
	private Random rand = new Random();
	
	public int getRandomInitiative (Caracteristique carac) {
		return this.calculDeRandom(carac.getAdresse());
	}	
	public int getRandomAttaque (Caracteristique carac) {
		return this.calculDeRandom(carac.getAdresse());
	}	
	public int getRandomEsquive (Caracteristique carac) {
		return this.calculDeRandom(carac.getAdresse());
	}	
	public int getRandomDefense(Caracteristique carac) {
		return this.calculDeRandom(carac.getResistance());
	}	
	public int getRandomDegat (Caracteristique carac) {
		return this.calculDeRandom(carac.getForce());
	}
	
	private int calculDeRandom (int degres) {
		int nombreDe = this.calculNiveau(degres);
		int result = 0;
		for(int i = 0; i < nombreDe; i++){
			result += (this.rand.nextInt((DE_MAX - DE_MIN) + 1) + DE_MIN);
		}
		result += calculBonus(degres);
		return result;
	}	
	private int calculBonus (int degres) {
		return (degres%3);
	}	
	private int calculNiveau (int degres) {
		return (degres - this.calculBonus(degres))/3;
	}
	
}
