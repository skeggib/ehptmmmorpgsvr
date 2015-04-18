package personnage;

/**
 * Contient la vie d'une entite et les methodes pour controller, manipuler la vie d'une entite
 * 
 * @author armya
 *
 */
public class Vie {
	public static final int MORT = 0;
	public static final int INCONSCIENT = 1;
	public static final int GRAVEMENT_BLESSE = 2;
	public static final int BLESSE = 3;
	public static final int LEGEREMENT_BLESSE = 5;
	public static final int BLESSURES_SUPERFICIELLES = 5;
	public static final int PLEINE_FORME = 7;
	
	private int vieActuelle = 6;
	

	/**
	 * Constructeur par defaut
	 */
	public Vie () {
		
	}
	/**
	 * Ajoute de la vie a l'entite
	 * @param value Valeur a ajouter
	 */
	public void ajouterVie (int value) {
		if(this.controlerVie()){
			this.vieActuelle += value;
			this.controlerVie();
		}
	}
	/**
	 * Retire de la vie a l'entite
	 * @param value Valeur a retirer
	 */
	public void retirerVie (int value) {
		if(this.controlerVie()){
			this.vieActuelle -= value;
			this.controlerVie();
		}
	}
	/**
	 * Retourne la vie actuelle de l'entite
	 * @return vieActuelle
	 */
	public int getVie () {
		return this.vieActuelle;
	}
	/**
	 * Met la vie a la valeur donné en parametre
	 * @param value
	 */
	private void setVie (int value) {
		this.vieActuelle = value;
	}
	/**
	 * Controle si le joueur n'a pas trop de vie ou s'il n'est pas mort. Ajuste la vie de l'entité si celle ci depasse le maximum
	 * @return false si le joueur est mort, true si le joueur est vivant
	 */
	private boolean controlerVie () {
		if (this.vieActuelle < Vie.MORT) {
			this.setVie (0);
			return false;
		}
		else if (this.vieActuelle > Vie.PLEINE_FORME) {
			this.setVie(7);
			return true;
		} else { 
			return true;
		}
	}
	
}
