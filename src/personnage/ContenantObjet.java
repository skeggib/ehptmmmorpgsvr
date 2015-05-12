package personnage;

import java.util.List;

import items.Objet;

public class ContenantObjet {
	
	private List<Objet> listObjet;

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
