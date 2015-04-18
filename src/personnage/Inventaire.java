package personnage;

import items.Objet;

import java.util.LinkedList;
import java.util.List;


@SuppressWarnings("unchecked")
public class Inventaire {
	@SuppressWarnings("rawtypes")
	private List objetInInventaire = new LinkedList ();
	 

	/**
	 * Constructeur par defaut
	 */
	public Inventaire () {
		
	}
	/**
	 * Ajoute un objet dans l'intentaire
	 * @param obj Objet a ajouter
	 */
	public void ajouterObjet (Objet obj) {
		this.objetInInventaire.add(obj);
	}
	/**
	 * Equipe le joueur de l'objet passe en parametre
	 * @param obj Objet a equiper
	 */
	public void equiperObjet (Object obj) {
		
	}
	/**
	 * Desequipe le joueur de l'objet passe en parametre s'il en est equipe
	 * @param obj
	 */
	public void desequiperObjet (Object obj) {
		
	}
	/**
	 * Retourne une chaine de caractere contenant la description de l'objet passé en parametre
	 * @param obj Objet dont un veut obtenir les caracteritiques
	 * @return Descrition de l'objet
	 */
	public String consulterCaracteristique (Object obj) {
		return "";
	}
	/**
	 * Utilise une potion
	 */
	public void utiliserPotion () {
		
	}
	/**
	 * Retire un objet de l'inventaire et le deposer sur le sol a coter du joueur
	 */
	public void deposerObjet () {
		
	}
}
