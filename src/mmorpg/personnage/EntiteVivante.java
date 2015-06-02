package mmorpg.personnage;

import java.util.Random;

import mmorpg.carte.Case;
import mmorpg.carte.ContenuCase;
import mmorpg.items.Arme;
import mmorpg.items.Equipable;
import mmorpg.items.Objet;

//TODO:armya Implementer l'exprerience (expPourNiveauSuivant() : int)

/**
 * 
 * La Classe EntiteVivante est la classe mere de toute entite contenu dans le
 * jeu : </br> - Joueur </br> - Monstre </br> - Personnage Non Joueur </br>
 * </br> Elle contient toutes les methodes necessaires a la gestion d'une entite
 * 
 * @author armya
 *
 */
public abstract class EntiteVivante implements ContenuCase { // TODO:skeggib
																// Verifier
																// toute cette
																// classe -> MAJ
																// UML

	/*
	 * Constante
	 */

	public static final int PA_UTILISE_POTION = 1;
	public static final int PA_DEPLACEMENT = 2;
	public static final int PA_ATTAQUE = 2;

	public static final int MAX_VIE = 7;
	public static final int MIN_VIE = 0;

	public static final int MIN_PA = 0;

	public static final int XP_VICTOIRE = 50;

	/*
	 * Variables
	 */

	private String nom;

	private int experience;

	private int pointAction;

	private int vie;

	private Case emplacement;

	private Caracteristique caractPrinc;
	private Caracteristique caractEquip;
	private Caracteristique caractEffet;

	private Inventaire inventaire;
	private Equipement equipement;
	public ListeUnique<Effet> effet;

	/*
	 * Constructeurs
	 */

	public EntiteVivante() {

		this.setVie(EntiteVivante.MAX_VIE);

		this.caractPrinc = new Caracteristique();
		this.caractEquip = new Caracteristique();
		this.caractEffet = new Caracteristique();

		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());

		this.effet = new ListeUnique<Effet>();
	}

	public EntiteVivante(int force, int adresse, int resistance) {

		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
		this.setVie(EntiteVivante.MAX_VIE);
		this.effet = new ListeUnique<Effet>();

		this.caractPrinc = new Caracteristique();
		this.caractEquip = new Caracteristique();
		this.caractEffet = new Caracteristique();

		this.caractPrinc.setForce(force);
		this.caractPrinc.setAdresse(adresse);
		this.caractPrinc.setResistance(resistance);
	}

	public EntiteVivante(int force, int adresse, int resistance, int vie) {

		this.setInventaire(new Inventaire());
		this.setEquipement(new Equipement());
		this.setVie(vie);
		this.effet = new ListeUnique<Effet>();

		this.caractPrinc = new Caracteristique();
		this.caractEquip = new Caracteristique();
		this.caractEffet = new Caracteristique();

		this.caractPrinc.setForce(force);
		this.caractPrinc.setAdresse(adresse);
		this.caractPrinc.setResistance(resistance);
	}
	
	public EntiteVivante (EntiteVivante etv) {
		this.setEquipement(new Equipement(etv.getEquipement()));
		this.setInventaire(new Inventaire(etv.getInventaire()));
		this.setExperience(etv.getExperience());
		this.setNom(etv.getNom());
		this.setPointAction(etv.getPointAction());
		this.setVie(etv.getVie());
		this.setNom(etv.getNom());

		this.effet = new ListeUnique<Effet>();
		for(int i = 0; i < etv.effet.size(); i++){
			this.effet.add(new Effet(etv.effet.get(i)));
		}
		
		this.caractPrinc = new Caracteristique(etv.getCaractPrinc());
		this.caractEffet = new Caracteristique();
		this.caractEquip = new Caracteristique();
		
		this.majCaractEffet();
		this.majCaractEqui();
	}

	/*
	 * Methode
	 */

	public void augmenterNiveauForce() {
		if (this.retirerXP(this.expPourNiveauSuivant(this.getCaractPrinc()
				.getForce()))) {
			this.getCaractPrinc()
					.setForce(this.getCaractPrinc().getForce() + 1);
		}
	}

	public void augmenterNiveauAdresse() {
		if (this.retirerXP(this.expPourNiveauSuivant(this.getCaractPrinc()
				.getAdresse()))) {
			this.getCaractPrinc().setAdresse(
					this.getCaractPrinc().getAdresse() + 1);
		}
	}

	public void augmenterNiveauResistance() {
		if (this.retirerXP(this.expPourNiveauSuivant(this.getCaractPrinc()
				.getResistance()))) {
			this.getCaractPrinc().setResistance(
					this.getCaractPrinc().getResistance() + 1);
		}
	}

	public int expPourNiveauSuivant(int niveauActuel) {
		return ((niveauActuel * niveauActuel) / 10 + 20);
	}

	/**
	 * Methode appele a la mort de l'entite. Cree un coffre avec les objets de
	 * son inventaire a l'interieur qui sera depose a son emplacement
	 */
	private void mourir() {
		if (!this.estVivant() && this.getEmplacement() != null) {
			this.getEmplacement().supprContenu();

			// On desequipe tout les objets
			for (int i = 0; i < this.getEquipement().getTaille(); i++) {
				this.desequiperObjet(this.getEquipement().getObjet(i));
			}

			// Si on possede un seul objet on le pose, sinon on cree un coffre
			if (this.getInventaire().getTaille() == 0) {

			} else if (this.getInventaire().getTaille() == 1) {
				this.getEmplacement().ajoutContenu(
						this.getInventaire().getObjet(0));
			} else {

				ListeUnique<Objet> liste = new ListeUnique<Objet>();
				for (int i = 0; i < this.getInventaire().getTaille(); i++) {
					liste.add(this.getInventaire().getObjet(i));
				}

				Coffre coffre = new Coffre(liste);

				this.getEmplacement().ajoutContenu(coffre);
			}

			this.setEmplacement(null);

		}
	}

	/**
	 * Permet de se deplacer
	 * 
	 * @param destination
	 *            Case de destination
	 * @return true si le deplacement est reussi, false sinon
	 */
	public boolean seDeplacer(Case destination) {
		if (this.deplacementPossible()) {
			if (destination.ajoutContenu(this)) {
				this.emplacement.supprContenu();
				this.setEmplacement(destination);

				this.setPointAction(this.getPointAction()
						- EntiteVivante.PA_DEPLACEMENT);
				return (this.getEmplacement() == destination);
			}
		}
		return false;
	}

	/**
	 * Initialise la position du joueur si ca n'a pas deja ete fait
	 * 
	 * @param position
	 *            Position de depart du joueur
	 * @return true si la position a ete initialiser, false sinon
	 */
	public boolean initialiserPos(Case position) {
		if (this.getEmplacement() == null) {
			this.setEmplacement(position);
			if (this.getEmplacement() == position) {
				return position.ajoutContenu(this);
			}
		}
		return false;
	}

	/**
	 * 
	 * Permet d'attaquer une cible
	 * 
	 * @param cible
	 *            Entite a attaquer
	 * @return Retourne le nombre de degat infliges. Retourne -1 si la cible
	 *         esquive
	 */
	public int attaquer(EntiteVivante cible) {
		if (this.attaquePossible()) {
			// Caracteristique de la cible et de l'attaquant
			Caracteristique cCible = cible.getCaractTotal();
			Caracteristique cThis = this.getCaractTotal();

			int esquiveCible = Capacite.getRandomEsquive(cCible.getAdresse(),
					cible.getEncombrement());

			if ((new Random().nextInt(100) + 1) > esquiveCible) {
				int defenseCible = Capacite.getRandomDefense(cCible
						.getResistance());

				int degatThis = Capacite.getRandomDegat(cThis.getForce(),
						cCible.getImpact());

				int attaqueThis = Capacite.getRandomAttaque(
						cCible.getAdresse(), cCible.getManiabilite());

				int degatSubit = degatThis
						* ((100 - defenseCible) + attaqueThis) / 100;

				int vieEnMoins = (degatSubit * 40 / 100);

				this.ajouterXP(1);

				if (vieEnMoins > 0) {
					cible.retirerVie(vieEnMoins);

					if (!cible.estVivant()) {
						this.ajouterXP(this.calculerExpVictoire(cible));
					}

					this.setPointAction(this.getPointAction()
							- EntiteVivante.PA_ATTAQUE);
					return vieEnMoins;
				}
			} else {

				this.setPointAction(this.getPointAction()
						- EntiteVivante.PA_ATTAQUE);
				return -1;
			}

			this.setPointAction(this.getPointAction()
					- EntiteVivante.PA_ATTAQUE);
		}
		return 0;
	}

	/**
	 * 
	 * Calcule l'experience gagne lors d'une victoire
	 * 
	 * @param Cible
	 *            Cible contre laquel l'attaquant a gagne
	 * @return Experience gagnee lors de la victoire
	 */
	private int calculerExpVictoire(EntiteVivante cible) {
		float ratio = cible.getExperience() / this.getExperience();

		if (ratio <= 1) {
			return EntiteVivante.XP_VICTOIRE;
		}

		return (int) (ratio * EntiteVivante.XP_VICTOIRE);
	}

	/**
	 * Permet de rammasser un coffre et son contenu
	 * 
	 * @param c
	 *            Coffre a rammasser
	 */
	public void rammasserCoffre(Coffre c) {
		this.inventaire.ajouterObjets(c.getContenu());
	}

	/**
	 * Permet de ramasser un objet
	 * 
	 * @param obj
	 *            Objet a rammasser
	 * @return true si l'objet a ete ajouter a l'inventaire, false sinon
	 */
	public boolean rammasserObjet(Objet obj) {
		if ((!this.inventaire.contient(obj) && !this.equipement.contient(obj))) {
			return this.inventaire.ajouterObjet(obj);
		}
		return false;
	}

	/**
	 * Permet d'equiper un objet
	 * 
	 * @param obj
	 *            Objet a equipe (doit etre dans l'inventaire du joueur
	 * @return true si l'objet a ete equipe, false sinon
	 */
	public boolean equiperObjet(Objet obj) {
		if (obj instanceof Equipable) {
			Equipable eq = (Equipable) obj;
			if (this.inventaire.retirerObjet(eq)) {
				if (eq instanceof Arme) {
					Arme a = (Arme) eq;
					int nombreArmeEquipe = 0;
					for (int i = 0; i < this.getEquipement().getTaille(); i++) {
						if (this.getEquipement().getObjet(i).getClass() == a.getClass()) {
							nombreArmeEquipe++;
						}
					}
					if (nombreArmeEquipe < 2) {
						this.getEquipement().ajouterObjet(a);
						this.majCaractEqui();
						return true;
					}
				} else {
					boolean dejaEquipe = false;
					int posObj = 0;
					for (int i = 0; i < this.getEquipement().getTaille(); i++) {
						if (this.getEquipement().getObjet(i).getClass() == eq.getClass()) {
							dejaEquipe = true;
							if(dejaEquipe){
								posObj = i;
							}
						}
					}
					if (!dejaEquipe) {
						this.getEquipement().ajouterObjet(eq);
						this.majCaractEqui();
						return true;
					} else {
						if(this.getInventaire().ajouterObjet(this.getEquipement().getObjet(posObj))){
							this.getEquipement().retirerObjet(this.getEquipement().getObjet(posObj));
							this.getEquipement().ajouterObjet(eq);
							this.getInventaire().retirerObjet(eq);
						}
						this.majCaractEqui();
						return true;
					}
				}
			}
			this.inventaire.ajouterObjet(obj);
			this.majCaractEqui();
			return false;
		}
		return false;	
	}

	/**
	 * Permet de desequiper un objet
	 * 
	 * @param obj
	 *            Objet a desequipe (doit etre dans l'inventaire du joueur
	 * @return true si l'objet a ete desequipe, false sinon
	 */
	public boolean desequiperObjet(Objet obj) {
		if (this.equipement.retirerObjet(obj)) {
			if (!this.inventaire.ajouterObjet(obj)) {
				return this.equipement.ajouterObjet(obj);
			} else {
				this.majCaractEqui();
				return true;
			}
		}
		return false;
	}

	/**
	 * Permet de mettre un Objet dans une case
	 * 
	 * @param obj
	 *            Objet a mettre dans la case
	 * @param destination
	 *            Case qui recevra l'objet
	 * @return
	 */
	public boolean deposerObjet(Objet obj, Case destination) {
		return destination.ajoutContenu(obj);
	}

	/**
	 * Retire un objet de l'inventaire
	 * 
	 * @param obj
	 *            Objet a retirer
	 */
	public void retirerObjet(Objet obj) {
		this.inventaire.retirerObjet(obj);
	}

	/**
	 * Permet d'ajouter de la vie
	 * 
	 * @param vie
	 *            Nombre de point de vie a ajouter
	 */
	public void ajouterVie(int vie) {
		if (vie > 0) {
			this.setVie(this.getVie() + vie);
		}
	}

	/**
	 * Permet de retirrer de la vie
	 * 
	 * @param vie
	 *            Nombre de point de vie a retirer
	 */
	public void retirerVie(int vie) {
		if (vie > 0) {
			this.setVie(this.getVie() - vie);

			if (!this.estVivant()) {
				this.mourir();
			}
		}
	}

	/**
	 * Controlle si l'entite est vivante
	 * 
	 * @return true si vie > 0, false sinon
	 */
	public boolean estVivant() {
		return !(this.getVie() <= 0);
	}

	/**
	 * Permet d'ajouter un effet a l'entite
	 * 
	 * @param effet
	 *            Effet a ajouter
	 * @return true si l'effet a ete ajoute, false sinon
	 */
	public boolean ajouterEffet(Effet effet) {
		if (!this.effet.contains(effet)) {
			this.effet.add(effet);
			if (this.effet.contains(effet)) {
				this.majCaractEffet();
				return true;
			}
		}
		this.majCaractEffet();
		return false;
	}

	/**
	 * Permet de retirer un effet a l'entite
	 * 
	 * @param effet
	 *            Effet a retirer
	 * @return true si l'effet a ete retirer, false sinon
	 */
	public boolean retirerEffet(Effet effet) {
		if (this.effet.contains(effet)) {
			this.effet.remove(effet);
			this.majCaractEffet();
		}
		return !this.effet.contains(effet);
	}

	/**
	 * Controlle les effets de l'entite Si l'effet prend fin, il sera supprime
	 */
	private void controlerEffet() {
		for (int i = 0; i < this.effet.size(); i++) {
			if (this.effet.get(i).decrementerTour()) {
				this.retirerEffet(this.effet.get(i));
			}
		}
	}

	/**
	 * Controlle le montant de PA
	 * 
	 * @return true s'il en reste assez pour effectuer une action, false sinon
	 */
	public boolean actionDisponible() {
		return (this.getPointAction() != 0);
	}

	public boolean deplacementPossible() {
		return (this.getPointAction() >= EntiteVivante.PA_DEPLACEMENT);
	}

	public boolean attaquePossible() {
		return (this.getPointAction() >= EntiteVivante.PA_ATTAQUE);
	}

	/**
	 * Effectue les actions necessaires a chaque debut de tour
	 */
	public void debutTour() {
		this.controlerEffet();
		this.ajouterVie(1);
		this.recupererPA();
	}

	/**
	 * Calcul les caracteristiques total de l'entite
	 * 
	 * @return Caracteristique total
	 */
	public Caracteristique getCaractTotal() {
		Caracteristique c = new Caracteristique();

		c.ajouter(this.caractPrinc);
		c.ajouter(this.caractEquip);
		c.ajouter(this.caractEffet);

		return c;
	}

	public abstract void recupererPA();

	/**
	 * Met a jour les caracteristiques apportees par l'equipement (reinitialise
	 * les caracteristiques a 0 pour tout recalculer)
	 */
	private void majCaractEqui() {
		this.caractEquip.reinitialiserCaract();

		for (int i = 0; i < this.equipement.getTaille(); i++) {
			this.equipement.getObjet(i).affecterBonus(this, this);
		}
	}

	/**
	 * Met a jour les caracteristiques apportees par les effets (reinitialise
	 * les caracteristiques a 0 pour tout recalculer)
	 */
	private void majCaractEffet() {
		this.caractEffet.reinitialiserCaract();

		for (int i = 0; i < this.effet.size(); i++) {
			this.effet.get(i).appliquerEffet(this);
		}
	}

	public void ajouterXP(int exp) {
		this.setExperience(this.getExperience() + exp);
	}

	public boolean retirerXP(int exp) {
		if ((this.getExperience() - exp) >= 0) {
			this.setExperience(this.getExperience() - exp);
			return true;
		}
		return false;
	}

	public int getEncombrement() {
		return (this.getEquipement().getTaille() * 2);
	}

	/*
	 * Methode d'acces
	 */

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		if (this.nom == null) {
			this.nom = nom;
		}
	}

	public int getPointAction() {
		return pointAction;
	}

	public void setPointAction(int pointAction) {
		this.pointAction = pointAction;
	}

	public int getVie() {
		return vie;
	}

	private void setVie(int vie) {
		this.vie = vie;

		if (this.getVie() < EntiteVivante.MIN_VIE) {
			this.vie = EntiteVivante.MIN_VIE;
		}
		if (this.getVie() > EntiteVivante.MAX_VIE) {
			this.vie = EntiteVivante.MAX_VIE;
		}
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	private void setInventaire(Inventaire inventaire) {
		if (this.inventaire == null) {
			this.inventaire = inventaire;
		}
	}

	public Equipement getEquipement() {
		return equipement;
	}

	private void setEquipement(Equipement equipement) {
		if (this.equipement == null) {
			this.equipement = equipement;
		}
	}

	public Case getEmplacement() {
		return emplacement;
	}

	private void setEmplacement(Case emplacement) {
		if (this.emplacement != emplacement) {
			this.emplacement = emplacement;
		}
	}

	public Caracteristique getCaractPrinc() {
		return this.caractPrinc;
	}

	public Caracteristique getCaractEquip() {
		return this.caractEquip;
	}

	public Caracteristique getCaractEffet() {
		return this.caractEffet;
	}

	public int getExperience() {
		return experience;
	}

	private void setExperience(int experience) {
		this.experience = experience;
	}
}
