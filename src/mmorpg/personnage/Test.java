package mmorpg.personnage;

import java.util.ArrayList;

import mmorpg.items.Arme;
import mmorpg.items.Casque;
import mmorpg.items.Gant;
import mmorpg.items.Objet;
import mmorpg.items.PotionEffet;

public class Test {

	public static void main(String[] args) {

		/*
		 * TEST POTION EFFET
		 */
		
		PotionEffet pEf = new PotionEffet();
		Joueur j = new Joueur();
		System.out.println("\nPOTION : ");
		System.out.println("Adresse : " + pEf.getAdresse());
		System.out.println("Force : " + pEf.getForce());
		System.out.println("Resistance : " + pEf.getResistance());
		System.out.println("Maniabilite : " + pEf.getManiabilite());
		System.out.println("Impact : " + pEf.getImpact());
		System.out.println("Duree : " + pEf.getDuree());
		j.rammasserObjet(pEf);
		System.out.println("\nJOUEUR");
		System.out.println("Adresse : " + j.getCaractTotal().getAdresse());
		System.out.println("Force : " + j.getCaractTotal().getForce());
		System.out.println("Resistance : " + j.getCaractTotal().getResistance());
		System.out.println("Maniabilite : " + j.getCaractTotal().getManiabilite());
		System.out.println("Impact : " + j.getCaractTotal().getImpact());
		pEf.affecterBonus(j, j);
		System.out.println("\nUTILISE LA POTION\nJOUEUR");
		System.out.println("Adresse : " + j.getCaractTotal().getAdresse());
		System.out.println("Force : " + j.getCaractTotal().getForce());
		System.out.println("Resistance : " + j.getCaractTotal().getResistance());
		System.out.println("Maniabilite : " + j.getCaractTotal().getManiabilite());
		System.out.println("Impact : " + j.getCaractTotal().getImpact());
		j.debutTour();
		j.debutTour();
		j.debutTour();
		j.debutTour();
		System.out.println("\nQUELQUE TOUR PLUS TARD\nJOUEUR");
		System.out.println("Adresse : " + j.getCaractTotal().getAdresse());
		System.out.println("Force : " + j.getCaractTotal().getForce());
		System.out.println("Resistance : " + j.getCaractTotal().getResistance());
		System.out.println("Maniabilite : " + j.getCaractTotal().getManiabilite());
		System.out.println("Impact : " + j.getCaractTotal().getImpact());
		
		/*
		 * TEST XP
		 */

//		Joueur a = new Joueur("armya", 10, 10, 10);
//		Joueur s = new Joueur("skeggib", 10, 10, 10);
//		s.ajouterXP(100);
//		a.ajouterXP(100);
//		while(s.estVivant()){
//			a.attaquer(s);
//			System.out.println("EXPERIENCE ARMYA : " + a.getExperience());
//		}
//		System.out.println("FORCE : " + a.getCaractPrinc().getForce());
//		System.out.println("EXP POUR NEXT LVL FORCE : " + a.expPourNiveauSuivant(a.getCaractPrinc().getForce()));
//		a.augmenterNiveauForce();
//		System.out.println("EXPERIENCE RESTANT : " + a.getExperience());
//		System.out.println("FORCE : " + a.getCaractPrinc().getForce());
//		System.out.println("EXP POUR NEXT LVL FORCE : " + a.expPourNiveauSuivant(a.getCaractPrinc().getForce()));
//		a.augmenterNiveauForce();
//		System.out.println("EXPERIENCE RESTANT : " + a.getExperience());
//		System.out.println("FORCE : " + a.getCaractPrinc().getForce());
//		System.out.println("EXP POUR NEXT LVL FORCE : " + a.expPourNiveauSuivant(a.getCaractPrinc().getForce()));
//		a.augmenterNiveauForce();
//		System.out.println("EXPERIENCE RESTANT : " + a.getExperience());
//		System.out.println("FORCE : " + a.getCaractPrinc().getForce());
//		System.out.println("EXP POUR NEXT LVL FORCE : " + a.expPourNiveauSuivant(a.getCaractPrinc().getForce()));
//		a.augmenterNiveauForce();
//		System.out.println("EXPERIENCE RESTANT : " + a.getExperience());
//		System.out.println("FORCE : " + a.getCaractPrinc().getForce());
//		System.out.println("EXP POUR NEXT LVL FORCE : " + a.expPourNiveauSuivant(a.getCaractPrinc().getForce()));
//		a.augmenterNiveauForce();
//		System.out.println("EXPERIENCE RESTANT : " + a.getExperience());
//		System.out.println("FORCE : " + a.getCaractPrinc().getForce());
		
		/*
		 * TEST CONTAIN()
		 */
		// Inventaire i = new Inventaire();
		// Arme a = new Arme("a", 10, 10);
		// i.ajouterObjet(a);
		// Arme a2 = new Arme("a", 10, 10);
		// System.out.println(i.contient(a));
		//
		//

		/*
		 * TEST AJOUT COFFRE DANS INVENTAIRE
		 */
		// Inventaire i = new Inventaire();
		//
		// Coffre c = new Coffre();
		// c.ajouterObjet(new Arme());
		// ListeUnique<Objet> liste = new ListeUnique<Objet>();
		// liste.add(new Casque());
		// liste.add(new Gant());
		// c.ajouterObjets(liste);
		//
		// System.out.println("INVENTAIRE VIDE (taille de l'inventaire) : " +
		// i.getTaille());
		// i.ajouterObjet(new Arme());
		// System.out.println("AJOUT D'UNE ARME (taille de l'inventaire) : " +
		// i.getTaille());
		// i.ajouterContenuCoffre(c);
		// System.out.println("AJOUT D'UN COFFRE DE TAILLE " + c.getTaille());
		// System.out.println("NOUVELLE TAILLE DE L'INVENTAIRE : " +
		// i.getTaille());

		/*
		 * TEST COFFRE
		 */
		// Coffre c = new Coffre();
		// System.out.println("COFFRE VIDE (taille du coffre) : " +
		// c.getTaille());
		// c.ajouterObjet(new Arme());
		// System.out.println("AJOUT D'UNE ARME (taille du coffre) : " +
		// c.getTaille());
		// ListeUnique<Objet> liste = new ListeUnique<Objet>();
		// liste.add(new Casque());
		// liste.add(new Gant());
		// System.out.println("AJOUT D'UNE LISTE DE TAILLE " + liste.size());
		// c.ajouterObjets(liste);
		// System.out.println("NOUVELLE TAILLE DU COFFRE : " + c.getTaille());

		/*
		 * TEST STAT RANDOM MONSTRE
		 */
		// Monstre m = new Monstre();
		// System.out.println("FORCE : " + m.getCaractPrinc().getForce());
		// System.out.println("ADRESSE : " + m.getCaractPrinc().getAdresse());
		// System.out.println("RESISTANCE : " +
		// m.getCaractPrinc().getResistance());

		/*
		 * TEST EFFET
		 */
		// Joueur j = new Joueur("Armya", 0, 0, 0);
		//
		// Effet f = new Effet(10, 0, 0, 0, 0, 1);
		// System.out.println("Force effet : " + f.getForce());
		// System.out.println("Duree (Tour) : " + f.getTourRestant());
		//
		// j.ajouterEffet(f);
		//
		// System.out.println("Force Caracteristique Effet apres ajout de l'effet : "
		// + j.getCaractEffet().getForce());
		// System.out.println("Force Caracteristique Total apres ajout de l'effet : "
		// + j.getCaractTotal().getForce());
		//
		// j.debutTour();
		//
		// System.out.println("Force Caracteristique Effet apres debutTour de l'effet : "
		// + j.getCaractEffet().getForce());
		// System.out.println("Force Caracteristique Total apres debutTour de l'effet : "
		// + j.getCaractTotal().getForce());

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

		/*
		 * FORMULE ESQUIVE
		 */
		// float x = 10;
		// System.out.println(5.00 + (30 * (x/(x+50))));

		/*
		 * FORMULE EXPERIENCE
		 */
		// (x²)/10 + 20
		//

		/*
		 * TEST ATTAQUE
		 */
		// Joueur j = new Joueur("Armya", 10, 10, 10);
		// Joueur b = new Joueur("Skeggib", 10, 10, 10);
		// //PersonnageNJ b = new PersonnageNJ(null, 10, 10, 10);
		// System.out.println("\nRETURN : " + j.attaquer(b));
		// System.out.println("\nRETURN : " + j.attaquer(b));
		// System.out.println("\nRETURN : " + j.attaquer(b));
		// System.out.println("\nRETURN : " + j.attaquer(b));
		// System.out.println("\nRETURN : " + j.attaquer(b));
		// System.out.println("\nRETURN : " + j.attaquer(b));
		// System.out.println("\nRETURN : " + j.attaquer(b));
		// System.out.println("\nRETURN : " + j.attaquer(b));
		// System.out.println("\nRETURN : " + j.attaquer(b));
		// System.out.println("\nRETURN : " + j.attaquer(b));

		/*
		 * TEST EQUIPEMENT
		 */
		// Joueur j = new Joueur("Armya", 0, 0, 0);
		// Joueur b = new Joueur("Skeggib", 0, 0, 0);
		//
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

		/*
		 * TEST EQUIPEMENT UNIQUE
		 */
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
