package carte;

import fichiers.LectureFichier;
import affichage.Image;
import affichage.Couleur;
import affichage.InterfaceTerm;

public class Case {
	public static final int JOUEUR_PRINCIPAL = 0;
	public static final int AUTRE_JOUEUR = 1;
	public static final int VIDE = 2;
	public static final int MUR = 3;
	public static final int MONSTRE = 4;
	public static final int OBJET = 5;
	
	private static Image[] IMG_JOUEUR_PRINCIPAL = null;
	private static Image[] IMG_AUTRE_JOUEUR = null;
	private static Image[] IMG_VIDE = null;
	private static Image[] IMG_MUR = null;
	private static Image[] IMG_MONSTRE = null;
	private static Image[] IMG_OBJET = null;
	
	private int valeur;
	
	public Case(int val) {
		this.valeur = val;
		this.chargerImages();		
	}
	
	public int getValeur() {
		return this.valeur;
	}
	
	public void setValeur(int val) {
		this.valeur = val;
		this.chargerImages();
	}
	
	private void chargerImages() {
		String str = new String();
		String[] array;

		/* --- JOUEUR_PRINCIPAL --- */

		if (Case.IMG_JOUEUR_PRINCIPAL == null) {
			Case.IMG_JOUEUR_PRINCIPAL = new Image[InterfaceTerm.TAILLES.length];
			for (int i = 0; i < InterfaceTerm.TAILLES.length; i ++) {
				array = LectureFichier.lire("../images/joueurPrincipal/" + InterfaceTerm.TAILLES[i]);
				str = new String();
				for (int j = 0; j < array.length; j ++)
					str += array[j] + "\n";
				Case.IMG_JOUEUR_PRINCIPAL[i] = new Image();
				Case.IMG_JOUEUR_PRINCIPAL[i].chargerString(str);
				Case.IMG_JOUEUR_PRINCIPAL[i].setCouleur(Couleur.getCouleurFromString(LectureFichier.lire("../images/joueurPrincipal/color")[0]));
			}
		}

		/* --- AUTRE_JOUEUR --- */

		if (Case.IMG_AUTRE_JOUEUR == null) {
			Case.IMG_AUTRE_JOUEUR = new Image[InterfaceTerm.TAILLES.length];
			for (int i = 0; i < InterfaceTerm.TAILLES.length; i ++) {
				array = LectureFichier.lire("../images/autreJoueur/" + InterfaceTerm.TAILLES[i]);
				str = new String();
				for (int j = 0; j < array.length; j ++)
					str += array[j] + "\n";
				Case.IMG_AUTRE_JOUEUR[i] = new Image();
				Case.IMG_AUTRE_JOUEUR[i].chargerString(str);
				Case.IMG_AUTRE_JOUEUR[i].setCouleur(Couleur.getCouleurFromString(LectureFichier.lire("../images/autreJoueur/color")[0]));
			}
		}

		/* --- VIDE --- */

		if (Case.IMG_VIDE == null) {
			Case.IMG_VIDE = new Image[InterfaceTerm.TAILLES.length];
			for (int i = 0; i < InterfaceTerm.TAILLES.length; i ++) {
				array = LectureFichier.lire("../images/vide/" + InterfaceTerm.TAILLES[i]);
				str = new String();
				for (int j = 0; j < array.length; j ++)
					str += array[j] + "\n";
				Case.IMG_VIDE[i] = new Image();
				Case.IMG_VIDE[i].chargerString(str);
				Case.IMG_VIDE[i].setCouleur(Couleur.getCouleurFromString(LectureFichier.lire("../images/vide/color")[0]));
			}
		}

		/* --- MUR --- */

		if (Case.IMG_MUR == null) {
			Case.IMG_MUR = new Image[InterfaceTerm.TAILLES.length];
			for (int i = 0; i < InterfaceTerm.TAILLES.length; i ++) {
				array = LectureFichier.lire("../images/mur/" + InterfaceTerm.TAILLES[i]);
				str = new String();
				for (int j = 0; j < array.length; j ++)
					str += array[j] + "\n";
				Case.IMG_MUR[i] = new Image();
				Case.IMG_MUR[i].chargerString(str);
				Case.IMG_MUR[i].setCouleur(Couleur.getCouleurFromString(LectureFichier.lire("../images/mur/color")[0]));
			}
		}

		/* --- MONSTRE --- */

		if (Case.IMG_MONSTRE == null) {
			Case.IMG_MONSTRE = new Image[InterfaceTerm.TAILLES.length];
			for (int i = 0; i < InterfaceTerm.TAILLES.length; i ++) {
				array = LectureFichier.lire("../images/monstre/" + InterfaceTerm.TAILLES[i]);
				str = new String();
				for (int j = 0; j < array.length; j ++)
					str += array[j] + "\n";
				Case.IMG_MONSTRE[i] = new Image();
				Case.IMG_MONSTRE[i].chargerString(str);
				Case.IMG_MONSTRE[i].setCouleur(Couleur.getCouleurFromString(LectureFichier.lire("../images/monstre/color")[0]));
			}
		}

		/* --- OBJET --- */

		if (Case.IMG_OBJET == null) {
			Case.IMG_OBJET = new Image[InterfaceTerm.TAILLES.length];
			for (int i = 0; i < InterfaceTerm.TAILLES.length; i ++) {
				array = LectureFichier.lire("../images/objet/" + InterfaceTerm.TAILLES[i]);
				str = new String();
				for (int j = 0; j < array.length; j ++)
					str += array[j] + "\n";
				Case.IMG_OBJET[i] = new Image();
				Case.IMG_OBJET[i].chargerString(str);
				Case.IMG_OBJET[i].setCouleur(Couleur.getCouleurFromString(LectureFichier.lire("../images/objet/color")[0]));
			}
		}

	}
	
	public Image getImage(int taille) {
		switch (this.valeur) {
			case Case.JOUEUR_PRINCIPAL:
				return Case.IMG_JOUEUR_PRINCIPAL[taille];
			case Case.AUTRE_JOUEUR:
				return Case.IMG_AUTRE_JOUEUR[taille];
			case Case.VIDE:
				return Case.IMG_VIDE[taille];
			case Case.MUR:
				return Case.IMG_MUR[taille];
			case Case.MONSTRE:
				return Case.IMG_MONSTRE[taille];
			case Case.OBJET:
				return Case.IMG_OBJET[taille];
			default:
				return Case.IMG_VIDE[taille];
		}
	}
	
	public String toString() {
		String str = new String();
		str += this.valeur;
		return str;
	}
}
