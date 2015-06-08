package mmorpg.personnage;

import java.util.Random;

/**
 * Contient toutes les methodes pour calculer les capacites
 * 
 * @author armya
 *
 */
public abstract class Capacite {
	
	private static final int DE_MAX = 6;
	private static final int DE_MIN = 1;
	
	private static Random rand = new Random();
	
	private Capacite () {
		
	}
	
	/**
	 * 
	 * @param adresse Adresse de l'entite
	 * @param encombrement Encombrement des vetements de l'entite
	 * @return Retourne l'initiative
	 */
	public static int getRandomInitiative (int adresse, int encombrement) {
		int initiative = adresse - encombrement;
		
		initiative = Capacite.calculDeRandom(initiative);
		
		if(initiative < 0){
			return 0;
		}
		return (0 + (20 * initiative / (initiative + 50)));
	}
	
	/**
	 * 
	 * @param adresse Adresse de l'entite
	 * @param maniabilite Maniabilite de l'arme de l'entite
	 * @return Retourne l'attaque
	 */
	public static int getRandomAttaque (int adresse, int maniabilite) {
		int attaque = adresse + maniabilite;
		
		if(attaque < 0){
			return 5;
		}
		return (5 + (30 * attaque / (attaque + 50)));
	}
	
	/**
	 * 
	 * @param adresse Adresse de l'entite
	 * @param encombrement Encombrement des vetements de l'entite
	 * @return Retourne l'esquive
	 */
	public static int getRandomEsquive (int adresse, int encombrement) {
		int esquive = adresse - encombrement;
		
		esquive = Capacite.calculDeRandom(esquive);
		
		if(esquive < 0){
			return 5;
		}
		return (5 + (30 * esquive / (esquive + 50)));
	}
	
	/**
	 * 
	 * @param defense Defense de l'entite
	 * @param solidite des vetements de l'entite
	 * @return Retourne la defense
	 */
	public static int getRandomDefense(int defense) {

		if(defense < 0){
			return 50;
		}

		defense = Capacite.calculDeRandom(defense);
		
		return (50 + (30 * defense / (defense + 25)));
	}
	
	/**
	 * 
	 * @param force Force de l'entite
	 * @param impact Impact de l'arme de l'entite
	 * @return Retourne les degats
	 */
	public static int getRandomDegat (int force, int impact) {
		int degat = force + impact;
		
		if(degat < 0){
			return 5;
		}
		
		degat = Capacite.calculDeRandom(degat);
		
		return (5 + (30 * degat / (degat + 50)));
	}
	
	/**
	 * Retourne le seultat d'un lance de D
	 * @param degres Nombre de degres possede par la caracteristique
	 * @return Resultat du lance de de(s) + le bonus
	 */
	private static int calculDeRandom (int degres) {
		int nombreDe = Capacite.calculNiveau(degres);
		int result = 0;
		for(int i = 0; i < nombreDe; i++){
			result += (rand.nextInt((DE_MAX - DE_MIN) + 1) + DE_MIN);
		}
		result += calculBonus(degres);
		return result;
	}	
	
	/**
	 * Calcul le Bonus d'une caracteristique
	 * @param degres Nombre de degres possede par la caracteristique
	 * @return Bonus de la caracteristique
	 */
	private static int calculBonus (int degres) {
		return (degres%3);
	}
	
	/**
	 * Calcul le niveau d'une caracteristique (D)
	 * @param degres Nombre de degres possede par la caracteristique
	 * @return resultat du lance
	 */
	private static int calculNiveau (int degres) {
		return (degres - Capacite.calculBonus(degres))/3;
	}
}
