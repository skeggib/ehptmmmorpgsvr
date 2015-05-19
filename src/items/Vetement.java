package items;

import personnage.EntiteVivante;

public abstract class Vetement extends Equipable {

	/*
	 * Constructeurs
	 */

	public Vetement() {
		super();
	}

	public Vetement(int qualite) {
		super(qualite);
	}

	/*
	 * Variables
	 */

	private int bonusForce;
	private int bonusAdresse;
	private int bonusResistance;
	
	/*
	 * Methode
	 */

	public void affecterBonus(EntiteVivante utilisateur, EntiteVivante cible) {
//		utilisateur.setForceEqui(utilisateur.getForceEqui() + this.getBonusForce());
//		utilisateur.setAdresseEqui(utilisateur.getAdresseEqui() + this.getBonusAdresse());
//		utilisateur.setResistanceEqui(utilisateur.getResistanceEqui() + this.getBonusResistance());
	}

	/*
	 * Methodes d'acces
	 */

	public int getBonusForce() {
		return bonusForce;
	}

	public void setBonusForce(int bonusForce) {
		this.bonusForce = bonusForce;
	}

	public int getBonusAdresse() {
		return bonusAdresse;
	}

	public void setBonusAdresse(int bonusAdresse) {
		this.bonusAdresse = bonusAdresse;
	}

	public int getBonusResistance() {
		return bonusResistance;
	}

	public void setBonusResistance(int bonusResistance) {
		this.bonusResistance = bonusResistance;
	}
}
