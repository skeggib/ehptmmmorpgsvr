package personnage;


/**
 * Classe Joueur. Entite controlee par un joueur
 * @author armya
 *
 */
public class Joueur extends EntiteVivante {
	
	private int pointAction;
	
	private int exp;
	
	public void seDeplacer () {
		
	}

	/**
	 * @return the pointAction
	 */
	public int getPointAction() {
		return pointAction;
	}

	/**
	 * @param pointAction the pointAction to set
	 */
	public void setPointAction(int pointAction) {
		this.pointAction = pointAction;
	}

	/**
	 * @return the exp
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * @param exp the exp to set
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}
}

