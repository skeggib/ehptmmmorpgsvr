package mmorpg.carte;

import java.io.Serializable;

import mmorpg.items.Objet;
import mmorpg.personnage.Coffre;
import mmorpg.personnage.EntiteVivante;
import mmorpg.personnage.Joueur;

public class Case implements Serializable {

	private static final long serialVersionUID = -7401683263475747998L;
	
	private ContenuCase contenu;
	
	public Case() { // TODO:skeggib Enlever le systeme de numeros
		contenu = null;
	}
	
	/**
	 * Supprime le contenu de la case
	 */
	public void supprContenu() {
		this.setContenu(new Vide());
	}
	
	/**
	 * Ajoute un contenu a la case, a condition qu'elle soit vide
	 * @param nouvContenu Contenu a ajouter
	 * @return True si le contenu a ete ajoute
	 */
	public boolean ajoutContenu(ContenuCase nouvContenu) {
		
		// Si la case ne contient rien
		if (this.getContenu() == null) {
			// Ajouter le nouveau contenu
			this.setContenu(nouvContenu);
			return true;
		}

		// Si la case contient quelque chose
		else {
			// Si c'est du vide
			if (this.getContenu().getNumero() == ContenuCase.VIDE) {
				// Ajouter le nouveau contenu
				this.setContenu(nouvContenu);
				return true;
			}
		}
		
		// Si non ne rien ajouter
		return false;
	}
	
	/**
	 * Change le contenu de la case
	 * @param nouvContenu Nouveau contenu de la case
	 * @return Le contenu precedent de la case
	 */
	public ContenuCase changerContenu(ContenuCase nouvContenu) {
		ContenuCase rtrn = this.getContenu();
		this.setContenu(nouvContenu);
		return rtrn;
	}
	
	/**
	 * 	
	 * @return True si la case contient du Vide ou rien
	 */
	public boolean estVide() {
		if (this.getContenu() == null)
			return true;
		if (this.getContenu() instanceof Vide) //TODO skeggib : Pourquoi ne pas faire "if(this.getContenu().getNumero() == ContenuCase.VIDE)"
			return true;
		
		return false;
	}
	
	public boolean contientObjet() { //TODO skebbig : Idem que le TO DO ci dessus, valable pour les methode en dessous aussi
		if (this.getContenu() instanceof Objet) {
			return true;
		}
		
		return false;
	}
	
	public boolean contientEntite() {
		if (this.getContenu() instanceof EntiteVivante) {
			return true;
		}
		
		return false;
	}
	
	public boolean contientEnvironnement() {
		if (this.getContenu() instanceof Environnement) {
			return true;
		}
		
		return false;
	}
	
	public boolean contientCoffre() {
		if (this.getContenu() instanceof Coffre) {
			return true;
		}
		
		return false;
	}
	
	public boolean contientJoueur() {
		if (this.getContenu() instanceof Joueur) {
			return true;
		}
		
		return false;
	}

	public ContenuCase getContenu() {
		return contenu;
	}

	private void setContenu(ContenuCase contenu) {
		this.contenu = contenu;
	}
	
	public String toString() {
		return "Contient : " + ((Object) this.contenu).getClass().getName();
	}
	
}
