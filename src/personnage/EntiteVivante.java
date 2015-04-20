package personnage;
/**
 * Classe EntiteVivante, contient : <br>
 *  - Inventaire <br>
 *  - Caracteristique <br>
 *  - Vie <br>
 *  - nom <br>
 *  - position (x, y) <br>
 *  
 *  ainsi que toute les methodes pour manipuler une entite
 *  
 * @author armya
 *
 */
abstract public class EntiteVivante {

	private Caracteristique caracteristique = new Caracteristique();
	private Inventaire inventaire = new Inventaire();
	private Vie vie = new Vie();
	private String nom;

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
	abstract public void seDeplacer ();
	
	/**
	 * Gere une attaque vers la cible de l'entite
	 */
	public void attaquer (EntiteVivante cible) {
		int adresseCible = cible.getCaracteristique().getAdresse();
		int encombrementCible = cible.getInventaire().getEncombrement();
		int paradeCible = cible.getInventaire().getParade();
		int esquiveCible = Capacite.getRandomEsquive(adresseCible, encombrementCible, paradeCible);
		System.out.println("esquive cible " + esquiveCible);
		
		int adresseJ = this.getCaracteristique().getAdresse();
		int maniabiliteJ = this.getInventaire().getManiabilite();
		int attaqueJ = Capacite.getRandomAttaque(adresseJ, maniabiliteJ);
		System.out.println("attaque joueur " + attaqueJ);
		
		if (attaqueJ > esquiveCible){
			int resistanceCible = cible.getCaracteristique().getResistance();
			int protectionCible = cible.getInventaire().getProtection();
			int defenseCible = Capacite.getRandomDefense(resistanceCible, protectionCible);
			System.out.println("defense cible " + defenseCible);

			int forceJ = this.getCaracteristique().getForce();
			int impactJ = this.getInventaire().getImpact();
			int degatJ = Capacite.getRandomDegat(forceJ, impactJ);
			System.out.println("degat joueur " + degatJ);
			
			if (degatJ > defenseCible){
				int degatSubit = degatJ - defenseCible;
				System.out.println("degat subit " + degatSubit);
				
				int vieEnMoins = (degatSubit/3);
				System.out.println("vie a retirer " + vieEnMoins);
				
				cible.getVie().retirerVie(vieEnMoins);
			} else {
				
			}
					
		} else {

		}
	}
	
	/**
	 * Retourne l'objet caracteristique de l'entite
	 * @return Caracteristique
	 */
	public Caracteristique getCaracteristique () {
		return this.caracteristique;
	}
	
	/**
	 * Retourne l'objet inventaire de l'entite
	 * @return Inventaire
	 */
	public Inventaire getInventaire () {
		return this.inventaire;
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
