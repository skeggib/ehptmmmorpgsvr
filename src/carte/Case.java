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
		
		// Si la case ne contient rien
		if (this.getContenu() == null)
			// Ajouter le nouveau contenu
			this.setContenu(nouvContenu);
		// Si la case contient quelque chose
		else {
			// Si c'est du vide
			if (this.getContenu().getNumero() == ContenuCase.VIDE)
				// Ajouter le nouveau contenu
				this.setContenu(nouvContenu);
		}
		
		// Si non ne rien ajouter
		return false;
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
