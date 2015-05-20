package personnage;

import items.Arme;
import items.Gant;
import items.Pantalon;

public class Test {

	public static void main(String[] args) {

		/*
		 * TEST CARACTERISTIQUE
		 */
		// Caracteristique c = new Caracteristique();
		//
		// System.out.println(c.getForce());
		// c.setForce(3);
		// System.out.println(c.getForce());
		//
		//
		// Caracteristique c1 = new Caracteristique();
		//
		// System.out.println(c1.getForce());
		// c1.setForce(7);
		// System.out.println(c1.getForce());
		//
		// Caracteristique c2 = new Caracteristique();
		//
		// System.out.println(c2.getForce());
		// c2.ajouter(c);
		// c2.ajouter(c1);
		// System.out.println(c2.getForce());

		// Formule Esquive
		// float x = 10;
		// System.out.println(5.00 + (30 * (x/(x+50))));
		//
		// Formule experience
		// (x²)/10 + 20
		//

		Joueur j = new Joueur("Armya", 50, 50, 50);
		Joueur b = new Joueur("Skeggib", 10, 10, 10);
		j.attaquer(b);
		j.attaquer(b);
		j.attaquer(b);
		j.attaquer(b);
		j.attaquer(b);
		j.attaquer(b);
		j.attaquer(b);
		j.attaquer(b);
		j.attaquer(b);
		j.attaquer(b);

		// Arme a = new Arme();
		//
		// System.out.println("\nArme : ");
		// System.out.println("Nom : " + a.getNom());
		// System.out.println("Impact : " + a.getImpact());
		// System.out.println("Maniabilite : " + a.getManiabilite());
		//
		// Gant g = new Gant();
		//
		// System.out.println("\nGant : ");
		// System.out.println("Nom : " + g.getNom());
		// System.out.println("Adresse : " + g.getAdresse());
		// System.out.println("Force : " + g.getForce());
		// System.out.println("Resistance : " + g.getResistance());
		//
		// Pantalon p = new Pantalon();
		//
		// System.out.println("\nPantalon : ");
		// System.out.println("Nom : " + p.getNom());
		// System.out.println("Adresse : " + p.getAdresse());
		// System.out.println("Force : " + p.getForce());
		// System.out.println("Resistance : " + p.getResistance());
		//
		// System.out.println("\nAvant (maniabilite): "
		// + j.getCaractTotal().getManiabilite());
		// System.out.println("Avant (Force): " +
		// j.getCaractTotal().getForce());
		//
		// j.rammasserObjet(a);
		// j.equiperObjet(a);
		//
		// j.rammasserObjet(g);
		// j.equiperObjet(g);
		//
		// j.rammasserObjet(p);
		// j.equiperObjet(p);
		//
		// System.out.println("\nApres (maniabilite): "
		// + j.getCaractTotal().getManiabilite());
		// System.out.println("Apres (Force): " +
		// j.getCaractTotal().getForce());

		// for (int i = 0; i < 10; i++) {
		//
		// System.out
		// .println("====================================================");
		// System.out.println("========================" + (i + 1)
		// + "===========================");
		// System.out
		// .println("====================================================");
		//
		// Arme a = new Arme();
		// System.out.println("nom    : " + a.getNom());
		// System.out.println("impact : " + a.getImpact());
		// System.out.println("maniab : " + a.getManiabilite());
		// System.out.println("qualit : " + a.getQualite());
		//
		// System.out.println("Ramasse l'objet");
		// System.out.println("Ramasse?     " + j.rammasserObjet(a));
		// System.out.println("taille Inv : " + j.getInventaire().getTaille());
		// System.out.println("\n");
		// System.out.println("Equipe l'objet");
		// System.out.println("Equipe?     " + j.equiperObjet(a));
		// System.out.println("taille Equ : " + j.getEquipement().getTaille());
		// System.out.println("\n");
		// System.out.println("RE ramasse l'objet");
		// System.out.println("Ramasse?     " + j.rammasserObjet(a));
		// System.out.println("taille Inv : " + j.getInventaire().getTaille());
		// System.out.println("\n");
		// System.out.println("\n");
		// System.out.println("\n");
		// }
	}
}
