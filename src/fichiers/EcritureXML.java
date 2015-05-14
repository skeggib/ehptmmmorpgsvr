package fichiers;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import personnage.EntiteVivante;

public class EcritureXML {
	public static void ecrireEntite(String destination, EntiteVivante perso) {
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
			final Document document = builder.newDocument();

			/*
			 * Etape 4 : création de l'Element racine
			 */
			final Element racine = document.createElement("entiteVivante");
			document.appendChild(racine);

			/*
			 * Etape 5 : création d'une personne puis d'un monstre
			 */
			final Comment commentaire = document
					.createComment("Contient la sauvegarde d'une EntiteVivante");
			racine.appendChild(commentaire);

			final Element entite = document.createElement("entite");
			racine.appendChild(entite);

			/*
			 * Etape 6 : création du personnage
			 */
			final Element nom = document.createElement("nom");
			nom.appendChild(document.createTextNode(perso.getNom()));

			final Element force = document.createElement("force");
			force.appendChild(document.createTextNode("" + perso.getForce()));

			final Element adresse = document.createElement("adresse");
			adresse.appendChild(document.createTextNode("" + perso.getAdresse()));

			final Element resistance = document.createElement("resistance");
			resistance.appendChild(document.createTextNode(""
					+ perso.getResistance()));

			final Element vie = document.createElement("vie");
			vie.appendChild(document.createTextNode("" + perso.getVie()));

			entite.appendChild(nom);
			entite.appendChild(force);
			entite.appendChild(adresse);
			entite.appendChild(resistance);
			entite.appendChild(vie);

			/*
			 * Etape 8 : affichage
			 */
			final TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			final DOMSource source = new DOMSource(document);
			final StreamResult sortie = new StreamResult(new File(destination));
			// final StreamResult result = new StreamResult(System.out);

			// prologue
			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

			// formatage
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");

			// sortie
			transformer.transform(source, sortie);
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public static void ecrireEntites(String destination, EntiteVivante[] persos) {
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
			final Document document = builder.newDocument();

			/*
			 * Etape 4 : création de l'Element racine
			 */
			final Element racine = document.createElement("entiteVivante");
			document.appendChild(racine);

			/*
			 * Etape 5 : création d'une personne puis d'un monstre
			 */
			final Comment commentaire = document
					.createComment("Contient la sauvegarde de plusieur EntiteVivante");
			racine.appendChild(commentaire);
			for (int i = 0; i < persos.length; i++) {
				final Element entite = document.createElement("entite");
				racine.appendChild(entite);

				/*
				 * Etape 6 : création du personnage
				 */
				final Element nom = document.createElement("nom");
				nom.appendChild(document.createTextNode(persos[i].getNom()));

				final Element force = document.createElement("force");
				force.appendChild(document.createTextNode("" + persos[i].getForce()));

				final Element adresse = document.createElement("adresse");
				adresse.appendChild(document.createTextNode(""
						+ persos[i].getAdresse()));

				final Element resistance = document.createElement("resistance");
				resistance.appendChild(document.createTextNode(""
						+ persos[i].getResistance()));

				final Element vie = document.createElement("vie");
				vie.appendChild(document.createTextNode("" + persos[i].getVie()));

				entite.appendChild(nom);
				entite.appendChild(force);
				entite.appendChild(adresse);
				entite.appendChild(resistance);
				entite.appendChild(vie);
			}

			/*
			 * Etape 8 : affichage
			 */
			final TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			final DOMSource source = new DOMSource(document);
			final StreamResult sortie = new StreamResult(new File(destination));
			// final StreamResult result = new StreamResult(System.out);

			// prologue
			transformer.setOutputProperty(OutputKeys.VERSION, "1.0");
			transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
			transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

			// formatage
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty(
					"{http://xml.apache.org/xslt}indent-amount", "2");

			// sortie
			transformer.transform(source, sortie);
		} catch (final ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}
}