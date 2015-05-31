package mmorpg.personnage;

import java.util.Random;

import mmorpg.carte.Carte;
import mmorpg.carte.ContenuCase;
import mmorpg.carte.Position;
import mmorpg.fichiers.LectureFichier;
import mmorpg.items.*;

/**
 * Cette classe permet la gestion d'un monstre controlle par l'IA
 * 
 * @author armya
 *
 */
public class Monstre extends EntiteVivante {

	public static final int BASE_PA = 10;

	// Demi constante qui ne peut etre modifier qu'avec
	// une potion qui augmente le nombre de PA pour un
	// certains nombre de tour
	private int MAX_PA;

	public static final String[] NOM = LectureFichier
			.lireT("ressources/noms/monstre.txt");

	/*
	 * Constructeur
	 */

	public Monstre() {
		super();
		this.statRandom();
		this.remplirInvetaire();
		this.setNom(this.nomRandom());
	}

	public Monstre(String nom) {
		super();
		this.statRandom();
		this.remplirInvetaire();
		this.setNom(nom);
	}

	public Monstre(String nom, int force, int adresse, int resistance) {
		super(force, adresse, resistance);
		this.remplirInvetaire();
		this.setNom(nom);
	}

	public Monstre(String nom, int force, int adresse, int resistance, int vie) {
		super(force, adresse, resistance, vie);
		this.remplirInvetaire();
		this.setNom(nom);
	}

	/*
	 * Methodes
	 */

	private void statRandom() {
		Random rand = new Random();

		int niveau = 0;

		int resultRand = rand.nextInt(1000);

		if (resultRand < 300) {
			niveau = 0;
		} else if (resultRand >= 300 && resultRand < 600) {
			niveau = 1;
		} else if (resultRand >= 600 && resultRand < 850) {
			niveau = 2;
		} else if (resultRand >= 850 && resultRand < 950) {
			niveau = 3;
		} else if (resultRand >= 950 && resultRand < 999) {
			niveau = 4;
		}

		switch (niveau) {
		case 0:
			this.getCaractPrinc().setForce(rand.nextInt(4) + 8);
			this.getCaractPrinc().setAdresse(rand.nextInt(4) + 8);
			this.getCaractPrinc().setResistance(rand.nextInt(4) + 8);
			break;
		case 1:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 16);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 16);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 16);
			break;
		case 2:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 16);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 16);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 16);
			break;
		case 3:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 26);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 26);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 26);
			break;
		case 4:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 36);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 36);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 36);
			break;
		case 5:
			this.getCaractPrinc().setForce(rand.nextInt(8) + 56);
			this.getCaractPrinc().setAdresse(rand.nextInt(8) + 56);
			this.getCaractPrinc().setResistance(rand.nextInt(8) + 56);
			break;
		default:
			break;
		}

	}

	public void remplirInvetaire(){
		Random rand = new Random();
		
		int nombreObjet = rand.nextInt(2);
		switch(nombreObjet){
		case 0:
			this.getInventaire().ajouterObjet(this.creeRandomObjet());
			break;
		case 1:
			this.getInventaire().ajouterObjet(this.creeRandomObjet());
			this.getInventaire().ajouterObjet(this.creeRandomObjet());
			break;
		}
	}

	private Objet creeRandomObjet() {
		Random rand = new Random();

		int choix = rand.nextInt(8);

		switch (choix) {
		case 0:
			return new Casque();
		case 1:
			return new Torse();
		case 2:
			return new Gant();
		case 3:
			return new Pantalon();
		case 4:
			return new Arme();
		case 5:
			return new PotionDeSoin();
		case 6:
			return new PotionDeDegat();
		case 7:
			return new PotionEffet();
		default:
			return null;
		}

	}

	public String nomRandom() {
		int i = new Random().nextInt((Monstre.NOM.length));
		return Monstre.NOM[i];
	}

	public int getNumero() {
		return ContenuCase.MONSTRE;
	}

	public void recupererPA() {
		this.setPointAction(Monstre.BASE_PA);
	}
	
	public boolean realiserAction(Carte carte) { // TODO:skeggib A faire
		
		System.out.println(this.getPointAction());
		if (!this.actionDisponible())
			return false;
		
		if (!this.estVivant())
			return false;
		
		Position pos = carte.getPosContenu(this);
		if (pos == null)
			return false;
		
		Position posJoueur = null;
		
		// Verifier s'il y a un joueur a coté
		if (carte.getCase(pos.getX() - 1, pos.getY()).contientJoueur()) {
			posJoueur = new Position(pos.getX() - 1, pos.getY());
		}
		else if (carte.getCase(pos.getX(), pos.getY() - 1).contientJoueur()) {
			posJoueur = new Position(pos.getX(), pos.getY() - 1);
		}
		else if (carte.getCase(pos.getX() + 1, pos.getY()).contientJoueur()) {
			posJoueur = new Position(pos.getX() + 1, pos.getY());
		}
		else if (carte.getCase(pos.getX(), pos.getY() + 1).contientJoueur()) {
			posJoueur = new Position(pos.getX(), pos.getY() + 1);
		}
		
		// S'il y en a un, l'attaquer
		if (posJoueur != null) {
			this.attaquer((Joueur)carte.getCase(posJoueur.getX(), posJoueur.getY()).getContenu());
			return true;
		}

		// S'il y en a pas
		else {
			// Choisir une direction au hasart
			int direction = new Random().nextInt(3);		
			
			// Se deplacer vers cette direction
			switch (direction) {
			case 0:
				this.seDeplacer(carte.getCase(pos.getX() - 1, pos.getY()));
				break;
			case 1:
				this.seDeplacer(carte.getCase(pos.getX(), pos.getY() - 1));
				break;
			case 2:
				this.seDeplacer(carte.getCase(pos.getX() + 1, pos.getY()));
				break;
			case 3:
				this.seDeplacer(carte.getCase(pos.getX(), pos.getY() + 1));
				break;
			}
		}
		
<<<<<<< HEAD
		return true;
	}

	/*
	 * Methode d'acces
	 */

	public int getMAX_PA() {
		return this.MAX_PA;
	}

	public void setMAX_PA(int nbPA) {
		this.MAX_PA = nbPA;
=======
>>>>>>> branch 'develop' of https://github.com/skeggib/ehptmmmorpgsvr
	}
}
