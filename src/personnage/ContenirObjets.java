package personnage;

import items.Objet;

public interface ContenirObjets {

	public String consulterCaracteristique(Objet o);

	public String ajouterObjet(Objet o);

	public String retirerObjet(Objet o);
}
