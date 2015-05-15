package fichiers;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import personnage.EntiteVivante;
import personnage.Joueur;
import personnage.Monstre;

public class LectureXML {
	public static void lire(String destination) {
		/*
		 * Etape 1 : récupération d'une instance de la classe
		 * "DocumentBuilderFactory"
		 */
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();

		try {
			/*
			 * Etape 2 : création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Etape 3 : création d'un Document
			 */
			final Document document = builder.parse(new File(destination));

			// Affiche du prologue
			System.out.println("*************PROLOGUE************");
			System.out.println("version : " + document.getXmlVersion());
			System.out.println("encodage : " + document.getXmlEncoding());
			System.out.println("standalone : " + document.getXmlStandalone());

			/*
			 * Etape 4 : récupération de l'Element racine
			 */
			final Element racine = document.getDocumentElement();

			// Affichage de l'élément racine
			System.out.println("\n*************RACINE************");
			System.out.println(racine.getNodeName());

			/*
			 * Etape 5 : récupération des personnes
			 */
			final NodeList racineNoeuds = racine.getChildNodes();
			final int nbRacineNoeuds = racineNoeuds.getLength();

			for (int i = 0; i < nbRacineNoeuds; i++) {
				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element entite = (Element) racineNoeuds.item(i);

					// Affichage d'une personne
					System.out.println("\n*************ENTITE************");

					/*
					 * Etape 6 : récupération du nom et du prénom
					 */
					String nom = entite.getElementsByTagName("nom").item(0)
							.getTextContent();
					int force = Integer.parseInt(entite
							.getElementsByTagName("force").item(0)
							.getTextContent());
					int adresse = Integer.parseInt(entite
							.getElementsByTagName("adresse").item(0)
							.getTextContent());
					int resistance = Integer.parseInt(entite
							.getElementsByTagName("resistance").item(0)
							.getTextContent());
					int vie = Integer.parseInt(entite
							.getElementsByTagName("vie").item(0)
							.getTextContent());

					// Affichage de l'entite
					System.out.println("nom : " + nom);
					System.out.println("force : " + force);
					System.out.println("adresse : " + adresse);
					System.out.println("resistance : " + resistance);
					System.out.println("vie : " + vie);
				}
			}
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Joueur> chargerJoueurs(String destination) {

		List<Joueur> result = new LinkedList<Joueur>();

		/*
		 * Etape 1 : récupération d'une instance de la classe
		 * "DocumentBuilderFactory"
		 */
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();

		try {
			/*
			 * Etape 2 : création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Etape 3 : création d'un Document
			 */
			final Document document = builder.parse(new File(destination));

			// Affiche du prologue
			System.out.println("*************PROLOGUE************");
			System.out.println("version : " + document.getXmlVersion());
			System.out.println("encodage : " + document.getXmlEncoding());
			System.out.println("standalone : " + document.getXmlStandalone());

			/*
			 * Etape 4 : récupération de l'Element racine
			 */
			final Element racine = document.getDocumentElement();

			// Affichage de l'élément racine
			System.out.println("\n*************RACINE************");
			System.out.println(racine.getNodeName());

			/*
			 * Etape 5 : récupération des personnes
			 */
			final NodeList racineNoeuds = racine.getChildNodes();
			final int nbRacineNoeuds = racineNoeuds.getLength();

			for (int i = 0; i < nbRacineNoeuds; i++) {
				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element entite = (Element) racineNoeuds.item(i);

					// Affichage d'une personne
					System.out.println("\n*************ENTITE************");

					/*
					 * Etape 6 : récupération du nom et du prénom
					 */
					String nom = entite.getElementsByTagName("nom").item(0)
							.getTextContent();
					int force = Integer.parseInt(entite
							.getElementsByTagName("force").item(0)
							.getTextContent());
					int adresse = Integer.parseInt(entite
							.getElementsByTagName("adresse").item(0)
							.getTextContent());
					int resistance = Integer.parseInt(entite
							.getElementsByTagName("resistance").item(0)
							.getTextContent());
					int vie = Integer.parseInt(entite
							.getElementsByTagName("vie").item(0)
							.getTextContent());

					// Affichage de l'entite
					System.out.println("nom : " + nom);
					System.out.println("force : " + force);
					System.out.println("adresse : " + adresse);
					System.out.println("resistance : " + resistance);
					System.out.println("vie : " + vie);

					result.add(new Joueur(nom, force, adresse, resistance, vie));
				}
			}
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static Joueur chargerJoueur(String destination) {

		Joueur result = null;

		/*
		 * Etape 1 : récupération d'une instance de la classe
		 * "DocumentBuilderFactory"
		 */
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();

		try {
			/*
			 * Etape 2 : création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Etape 3 : création d'un Document
			 */
			final Document document = builder.parse(new File(destination));

			// Affiche du prologue
			System.out.println("*************PROLOGUE************");
			System.out.println("version : " + document.getXmlVersion());
			System.out.println("encodage : " + document.getXmlEncoding());
			System.out.println("standalone : " + document.getXmlStandalone());

			/*
			 * Etape 4 : récupération de l'Element racine
			 */
			final Element racine = document.getDocumentElement();

			// Affichage de l'élément racine
			System.out.println("\n*************RACINE************");
			System.out.println(racine.getNodeName());

			/*
			 * Etape 5 : récupération des personnes
			 */
			final NodeList racineNoeuds = racine.getChildNodes();
			final int nbRacineNoeuds = racineNoeuds.getLength();

			for (int i = 0; i < nbRacineNoeuds; i++) {
				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element entite = (Element) racineNoeuds.item(i);

					// Affichage d'une personne
					System.out.println("\n*************ENTITE************");

					/*
					 * Etape 6 : récupération du nom et du prénom
					 */
					String nom = entite.getElementsByTagName("nom").item(0)
							.getTextContent();
					int force = Integer.parseInt(entite
							.getElementsByTagName("force").item(0)
							.getTextContent());
					int adresse = Integer.parseInt(entite
							.getElementsByTagName("adresse").item(0)
							.getTextContent());
					int resistance = Integer.parseInt(entite
							.getElementsByTagName("resistance").item(0)
							.getTextContent());
					int vie = Integer.parseInt(entite
							.getElementsByTagName("vie").item(0)
							.getTextContent());

					// Affichage de l'entite
					System.out.println("nom : " + nom);
					System.out.println("force : " + force);
					System.out.println("adresse : " + adresse);
					System.out.println("resistance : " + resistance);
					System.out.println("vie : " + vie);

					result = new Joueur(nom, force, adresse, resistance, vie);
				}
			}
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static List<Monstre> chargerMonstres(String destination) {

		List<Monstre> result = new LinkedList<Monstre>();

		/*
		 * Etape 1 : récupération d'une instance de la classe
		 * "DocumentBuilderFactory"
		 */
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();

		try {
			/*
			 * Etape 2 : création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Etape 3 : création d'un Document
			 */
			final Document document = builder.parse(new File(destination));

			// Affiche du prologue
			System.out.println("*************PROLOGUE************");
			System.out.println("version : " + document.getXmlVersion());
			System.out.println("encodage : " + document.getXmlEncoding());
			System.out.println("standalone : " + document.getXmlStandalone());

			/*
			 * Etape 4 : récupération de l'Element racine
			 */
			final Element racine = document.getDocumentElement();

			// Affichage de l'élément racine
			System.out.println("\n*************RACINE************");
			System.out.println(racine.getNodeName());

			/*
			 * Etape 5 : récupération des personnes
			 */
			final NodeList racineNoeuds = racine.getChildNodes();
			final int nbRacineNoeuds = racineNoeuds.getLength();

			for (int i = 0; i < nbRacineNoeuds; i++) {
				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element entite = (Element) racineNoeuds.item(i);

					// Affichage d'une personne
					System.out.println("\n*************ENTITE************");

					/*
					 * Etape 6 : récupération du nom et du prénom
					 */
					String nom = entite.getElementsByTagName("nom").item(0)
							.getTextContent();
					int force = Integer.parseInt(entite
							.getElementsByTagName("force").item(0)
							.getTextContent());
					int adresse = Integer.parseInt(entite
							.getElementsByTagName("adresse").item(0)
							.getTextContent());
					int resistance = Integer.parseInt(entite
							.getElementsByTagName("resistance").item(0)
							.getTextContent());
					int vie = Integer.parseInt(entite
							.getElementsByTagName("vie").item(0)
							.getTextContent());

					// Affichage de l'entite
					System.out.println("nom : " + nom);
					System.out.println("force : " + force);
					System.out.println("adresse : " + adresse);
					System.out.println("resistance : " + resistance);
					System.out.println("vie : " + vie);

					result.add(new Monstre(nom, force, adresse, resistance, vie));
				}
			}
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return result;
	}

	public static Monstre chargerMonstre(String destination) {

		Monstre result = null;

		/*
		 * Etape 1 : récupération d'une instance de la classe
		 * "DocumentBuilderFactory"
		 */
		final DocumentBuilderFactory factory = DocumentBuilderFactory
				.newInstance();

		try {
			/*
			 * Etape 2 : création d'un parseur
			 */
			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Etape 3 : création d'un Document
			 */
			final Document document = builder.parse(new File(destination));

			// Affiche du prologue
			System.out.println("*************PROLOGUE************");
			System.out.println("version : " + document.getXmlVersion());
			System.out.println("encodage : " + document.getXmlEncoding());
			System.out.println("standalone : " + document.getXmlStandalone());

			/*
			 * Etape 4 : récupération de l'Element racine
			 */
			final Element racine = document.getDocumentElement();

			// Affichage de l'élément racine
			System.out.println("\n*************RACINE************");
			System.out.println(racine.getNodeName());

			/*
			 * Etape 5 : récupération des personnes
			 */
			final NodeList racineNoeuds = racine.getChildNodes();
			final int nbRacineNoeuds = racineNoeuds.getLength();

			for (int i = 0; i < nbRacineNoeuds; i++) {
				if (racineNoeuds.item(i).getNodeType() == Node.ELEMENT_NODE) {
					final Element entite = (Element) racineNoeuds.item(i);

					// Affichage d'une personne
					System.out.println("\n*************ENTITE************");

					/*
					 * Etape 6 : récupération du nom et du prénom
					 */
					String nom = entite.getElementsByTagName("nom").item(0)
							.getTextContent();
					int force = Integer.parseInt(entite
							.getElementsByTagName("force").item(0)
							.getTextContent());
					int adresse = Integer.parseInt(entite
							.getElementsByTagName("adresse").item(0)
							.getTextContent());
					int resistance = Integer.parseInt(entite
							.getElementsByTagName("resistance").item(0)
							.getTextContent());
					int vie = Integer.parseInt(entite
							.getElementsByTagName("vie").item(0)
							.getTextContent());

					// Affichage de l'entite
					System.out.println("nom : " + nom);
					System.out.println("force : " + force);
					System.out.println("adresse : " + adresse);
					System.out.println("resistance : " + resistance);
					System.out.println("vie : " + vie);

					result = new Monstre(nom, force, adresse, resistance, vie);
				}
			}
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (final SAXException e) {
			e.printStackTrace();
		} catch (final IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}