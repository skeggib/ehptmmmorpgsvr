package personnage;

public class EntiteVivante {

	private Caracteristique caracteristique = new Caracteristique();
	private Inventaire inventaire = new Inventaire();
	private Vie vie = new Vie();
	private String nom;
	private EntiteVivante cible;

	private int positionX;
	private int positionY;
	

	/**
	 * Constructeur par defaut
	 */
	public EntiteVivante () {
		
	}
	/**
	 * Gere le deplacement de l'entite
	 */
	public void seDeplacer () {
		//TODO A revoir pour son utilisation
	}
	/**
	 * Gere une attaque vers la cible de l'entite
	 */
	public void attaquer () {

	}
	/**
	 * Retourne l'objet caracteristique de l'entite
	 * @return Caracteristique
	 */
	public Caracteristique getCaracteristique () {
		return this.caracteristique;
	}
	/**
	 * Retourne l'objet cible de l'entite
	 * @return EntiteVivante
	 */	
	public Object getCible() {
		return cible;
	}
	/**
	 * Attribuer une cible a l'entite
	 * @param cible EntiteVivnte
	 */
	public void setCible(EntiteVivante cible) {
		this.cible = cible;
	}
	/**
	 * Retourne l'objet Vie de l'entite
	 * @return Vie
	 */
	public Vie getVie() {
		return vie;
	}
	/**
	 * Retourne la position X de l'entite
	 * @return positionX
	 */
	public int getPositionX() {
		return positionX;
	}
	/**
	 * Modifie la position X de l'entite
	 * @param positionX
	 */
	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}
	/**
	 * Retourne la position Y de l'entite
	 * @return positionY
	 */
	public int getPositionY() {
		return positionY;
	}
	/**
	 * Modifie la position Y de l'entite
	 * @param positionY
	 */
	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
	/**
	 * Retourne l'objet Inventaire de l'entité
	 * @return inventaire
	 */
	public Inventaire getInvent() {
		return inventaire;
	}
	/**
	 * Retourne le nom de l'entite
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * Modifie le nom de l'entite
	 * @param nom nom de l'entite
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
}
