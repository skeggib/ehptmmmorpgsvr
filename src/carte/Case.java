package carte;

public class Case {

	private ContenuCase contenu;
	
	public Case() {
		contenu = null;
	}
	
	/**
	 * Supprime le contenu de la case
	 */
	public void supprContenu() {
		this.setContenu(null);
	}
	
	/**
	 * Ajoute un contenu a la case, a condition qu'elle soit vide
	 * @param nouvContenu Contenu a ajouter
	 * @return True si le contenu a ete ajoute
	 */
	public boolean ajoutContenu(ContenuCase nouvContenu) {
		// On ne change rien s'il y a déjà quelque chose
		if (this.getContenu() != null)
			return false;
		
		this.setContenu(nouvContenu);
		return true;
	}
	
	/**
	 * Change le contnu de la case
	 * @param nouvContenu Nouveau contenu de la case
	 * @return Le contenu precedent de la case
	 */
	public ContenuCase changerContenu(ContenuCase nouvContenu) {
		ContenuCase rtrn = this.getContenu();
		this.setContenu(nouvContenu);
		return rtrn;
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
