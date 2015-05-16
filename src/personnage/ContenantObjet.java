package personnage;

import java.util.LinkedList;
import java.util.List;

import items.Objet;

public class ContenantObjet implements ContenirObjets {
	
	private List<Objet> listObjet = new LinkedList<Objet>();
	
	public Objet getObjet(int index){
		return this.listObjet.get(index);
	}

	public boolean ajouterObjet(Objet o) {
		if(!(this.listObjet.contains(o))){
			this.listObjet.add(o);
			if(this.listObjet.contains(o)){
				return true;
			}
		}
		return false;
	}

	public boolean retirerObjet(Objet o) {
		if(this.listObjet.contains(o)){
			this.listObjet.remove(o);
			if(!(this.listObjet.contains(o))){
				return true;
			}
		}
		return false;
	}
	
	public int getTaille () {
		return this.listObjet.size();
	}
}
