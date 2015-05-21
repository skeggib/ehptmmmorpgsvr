package personnage;

/**
 * Contient les caracteristiques influant sur l'entite.</br>
 * 
 * @author armya
 *
 */
public class Caracteristique {

	private int force;
	private int adresse;
	private int resistance;
	private int maniabilite;
	private int impact;

	/*
	 * Constructeurs
	 */

	public Caracteristique() {
		this.setForce(0);
		this.setAdresse(0);
		this.setResistance(0);
		this.setManiabilite(0);
		this.setImpact(0);
	}

	public Caracteristique(int force, int adresse, int resistance,
			int maniabilite, int impact) {
		this.setForce(force);
		this.setAdresse(adresse);
		this.setResistance(resistance);
		this.setManiabilite(maniabilite);
		this.setImpact(impact);
	}

	/*
	 * Methode
	 */

	public void ajouter(Caracteristique c) { // TODO:skeggib Ajouter UML
		this.ajouterForce(c.getForce());
		this.ajouterAdresse(c.getAdresse());
		this.ajouterResistance(c.getResistance());
		this.ajouterManiabilite(c.getManiabilite());
		this.ajouterImpact(c.getImpact());
	}

	public void reinitialiserCaract() { // TODO:skeggib Ajouter UML
		this.setForce(0);
		this.setAdresse(0);
		this.setResistance(0);
		this.setManiabilite(0);
		this.setImpact(0);
	}

	public void reinitialiserCaract(int force, int adresse, int resistance,
			int maniabilite, int impact) { // TODO:skeggib Ajouter UML
		this.setForce(force);
		this.setAdresse(adresse);
		this.setResistance(resistance);
		this.setManiabilite(maniabilite);
		this.setImpact(impact);
	}

	public void ajouterForce(int force) {
		this.setForce(this.getForce() + force);
	}

	public void ajouterAdresse(int adresse) {
		this.setAdresse(this.getAdresse() + adresse);
	}

	public void ajouterResistance(int resistance) {
		this.setResistance(this.getResistance() + resistance);
	}

	public void ajouterManiabilite(int maniabilite) {
		this.setManiabilite(this.getManiabilite() + maniabilite);
	}

	public void ajouterImpact(int impact) {
		this.setImpact(this.getImpact() + impact);
	}

	/*
	 * Methode d'acces
	 */

	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}

	public int getAdresse() {
		return adresse;
	}

	public void setAdresse(int adresse) {
		this.adresse = adresse;
	}

	public int getResistance() {
		return resistance;
	}

	public void setResistance(int resistance) {
		this.resistance = resistance;
	}

	public int getManiabilite() {
		return maniabilite;
	}

	public void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}

	public int getImpact() {
		return impact;
	}

	public void setImpact(int impact) {
		this.impact = impact;
	}
}
