package affichage;

import personnage.Joueur;
import carte.Carte;
import carte.Position;

public class InterfaceTerm {
	
	private Matrice matrice;
	
	public InterfaceTerm() {
		
	}

	public boolean afficher(Joueur joueur) {
		if (!this.dessinerInterface(joueur))
			return false;
		
		this.matrice.afficher();
		
		return true;
	}
	
	private boolean dessinerInterface(Joueur joueur) {
		
		
		return true;
	}
	
	public String toString() {
		String rtrn = new String();
		rtrn += "Matrice : " + this.matrice.getLargeur() + "x" + this.matrice.getHauteur();
		
		return rtrn;
	}
}
