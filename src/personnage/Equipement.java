package personnage;

import java.util.List;

import items.Arme;
import items.Equipable;
import items.Objet;

public class Equipement implements ContenirObjets {

	private List<Equipable> listObjet;

	public Objet getObjet(int index) {
		return this.listObjet.get(index);
	}

	public boolean ajouterObjet(Objet obj) {
		if (obj instanceof Equipable) {
			Equipable eq = (Equipable) obj;
			if (!this.listObjet.contains(eq)) {
				if (eq instanceof Arme) {
					int nombreArmeEquipe = 0;
					for (int i = 0; i < this.listObjet.size(); i++) {
						if (this.listObjet.get(i) instanceof Arme) {
							nombreArmeEquipe++;
						}
					}
					if (nombreArmeEquipe < 2) {
						this.listObjet.add(eq);
						return true;
					}
				} else {
					boolean dejaEquipe = false;
					for (int i = 0; i < this.listObjet.size(); i++) {
						if (this.listObjet.get(i).getClass() == eq.getClass()) {
							dejaEquipe = true;
						}
					}
					if (!dejaEquipe) {
						this.listObjet.add(eq);
						return true;
					}
				}
			}
			return false;
		}
		return false;
	}

	public boolean retirerObjet(Objet o) {
		if (this.listObjet.contains(o)) {
			this.listObjet.remove(o);
			if (!(this.listObjet.contains(o))) {
				return true;
			}
		}
		return false;
	}

	public int getTaille() {
		return this.listObjet.size();
	}
}
