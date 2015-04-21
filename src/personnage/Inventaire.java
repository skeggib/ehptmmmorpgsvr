package personnage;

import items.*;

import java.util.LinkedList;
import java.util.List;


@SuppressWarnings("unchecked")
/**
 * Inventaire d'une entite
 * 
 * @author armya
 *
 */

public class Inventaire {
	@SuppressWarnings("rawtypes")
	private List objetInInventaire = new LinkedList ();
	@SuppressWarnings("rawtypes")
	private List objetEquipe = new LinkedList ();


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
		if(!this.objetInInventaire.contains(obj)){
			this.objetInInventaire.add(obj);
		}
	}
	/**
	 * Equipe le joueur de l'objet passe en parametre
	 * @param obj Objet a equiper
	 */
	public void equiperObjet (Object obj) {
		if(this.objetInInventaire.contains(obj) && !this.objetEquipe.contains(obj)){
			if(obj instanceof Arme){
				int nombreArmeEquipe = 0;
				for(int i = 0; i < this.objetEquipe.size(); i++){
					if(this.objetEquipe.get(i) instanceof Arme){
						nombreArmeEquipe++;
					}
				}
				if(nombreArmeEquipe < 2){
					this.objetEquipe.add(obj);
					this.objetInInventaire.remove(obj);
				}
			} else {
				boolean dejaEquipe = false;
				for(int i = 0; i < this.objetEquipe.size(); i++){
					if(this.objetEquipe.get(i).getClass() == obj.getClass()){
						dejaEquipe = true;
					}
				}
				if(!dejaEquipe){
					this.objetEquipe.add(obj);
					this.objetInInventaire.remove(obj);
				}
			} 
		} else {

		}
	}

	/**
	 * Desequipe le joueur de l'objet passe en parametre s'il en est equipe
	 * @param obj
	 */
	public void desequiperObjet (Object obj) {
		if(this.objetEquipe.contains(obj) && !this.objetInInventaire.contains(obj)){
			this.objetEquipe.remove(this.objetEquipe.indexOf(obj));
			this.objetInInventaire.add(obj);
		}
	}
	/**
	 * Retourne une chaine de caractere contenant la description de l'objet passé en parametre
	 * @param obj Objet dont un veut obtenir les caracteritiques
	 * @return Descrition de l'objet
	 */
	public String consulterCaracteristique (Objet obj) {
		return obj.getNom();
	}
	/**
	 * Utilise une potion
	 */
	public void utiliserPotion () {
	}
	/**
	 * Retire un objet de l'inventaire et le deposer sur le sol a coter du joueur
	 */
	public void deposerObjet (Objet obj) {
		if(this.objetInInventaire.contains(obj)){
			this.objetInInventaire.remove(this.objetInInventaire.indexOf(obj));
		}
	}
	public String inventaireToString () {
		String result = "";
		for(int i = 0; i < this.objetInInventaire.size(); i++){
			result += (((Objet) this.objetInInventaire.get(i)).getNom() + "\n");
		}
		return result;
	}
	public String equipeToString () {
		String result = "";
		for(int i = 0; i < this.objetEquipe.size(); i++){
			result += (((Objet) this.objetEquipe.get(i)).getNom() + "\n");
		}
		return result;
	}
	public int getEncombrement () {
		int result = 0;
		for(int i = 0; i < this.objetEquipe.size(); i++){
			if(this.objetEquipe.get(i) instanceof Vetement){
				result += ((Vetement) this.objetEquipe.get(i)).getEncombrement();
			}
		}
		return (result + this.objetInInventaire.size());
	}
	public int getProtection () {
		int result = 0;
		for(int i = 0; i < this.objetEquipe.size(); i++){
			if(this.objetEquipe.get(i) instanceof Vetement){
				result += ((Vetement) this.objetEquipe.get(i)).getProtection();
			}
		}
		return (result);
	}
	public int getImpact () {
		int result = 0;
		for(int i = 0; i < this.objetEquipe.size(); i++){
			if(this.objetEquipe.get(i) instanceof Arme){
				result += ((Arme) this.objetEquipe.get(i)).getImpact();
			}
		}
		return (result);
	}
	public int getManiabilite () {
		int result = 0;
		for(int i = 0; i < this.objetEquipe.size(); i++){
			if(this.objetEquipe.get(i) instanceof Arme){
				result += ((Arme) this.objetEquipe.get(i)).getManiabilite();
			}
		}
		return (result);
	}
	public int getParade () {
		int result = 0;
		for(int i = 0; i < this.objetEquipe.size(); i++){
			if(this.objetEquipe.get(i) instanceof Arme){
				result += ((Arme) this.objetEquipe.get(i)).getParade();
			}
		}
		return (result);
	}
	/**
	 * Retourne un tableau d'Arme, taille 1 si une arme equipe, taille 2 si deux armes equipes
	 * @return Arme[] tab
	 */
	public Arme[] getArme () {
		Arme[] tab;
		int nombreArmeEquipe = 0;
		for(int i = 0; i < this.objetEquipe.size(); i++){
			if(this.objetEquipe.get(i) instanceof Arme){
				nombreArmeEquipe++;
			}
		}

		if(nombreArmeEquipe < 2){
			tab = new Arme[1]; 
			for(int i = 0; i < this.objetEquipe.size(); i++){
				if(this.objetEquipe.get(i) instanceof Arme){
					tab[0] = ((Arme) this.objetEquipe.get(i));
					return tab;
				}
			}
		} else {
			tab = new Arme[2]; 
			for(int i = 0; i < this.objetEquipe.size(); i++){
				if(this.objetEquipe.get(i) instanceof Arme){
					if(tab[0] == null){
						tab[0] = (Arme) this.objetEquipe.get(i);
					} else {
						tab[1] = ((Arme) this.objetEquipe.get(i));
					}
				}
			}
			return tab;
		}
		return null;
	}
}







