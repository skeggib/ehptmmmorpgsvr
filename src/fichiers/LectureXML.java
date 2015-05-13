package fichiers;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

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
					final Element nom = (Element) entite.getElementsByTagName(
							"nom").item(0);
					final Element force = (Element) entite
							.getElementsByTagName("force").item(0);
					final Element adresse = (Element) entite
							.getElementsByTagName("adresse").item(0);
					final Element resistance = (Element) entite
							.getElementsByTagName("resistance").item(0);
					final Element vie = (Element) entite.getElementsByTagName(
							"vie").item(0);

					// Affichage de l'entite
					System.out.println("nom : " + nom.getTextContent());
					System.out.println("force : " + force.getTextContent());
					System.out.println("adresse : " + adresse.getTextContent());
					System.out.println("resistance : "
							+ resistance.getTextContent());
					System.out.println("vie : " + vie.getTextContent());
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
}