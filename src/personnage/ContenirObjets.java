package personnage;

import items.Objet;

public interface ContenirObjets {

	public Objet getObjet(int index);

	public boolean ajouterObjet(Objet o);

	public boolean retirerObjet(Objet o);

	public int getTaille();
}
