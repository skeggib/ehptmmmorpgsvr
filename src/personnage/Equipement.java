package personnage;

import java.util.List;

import items.Equipable;
import items.Objet;

public class Equipement implements ContenirObjets{
	
	private List<Equipable> listObjet;
	
	public Objet getObjet(int index){
		return this.listObjet.get(index);
	}

	public boolean ajouterObjet(Objet o) {
		if(o instanceof Equipable){
			Equipable eq = (Equipable) o;
			
			for(int i = 0; i < this.getTaille(); i++){
				if(this.listObjet.get(i) == eq){
					
				}
			}
			
			
			
			if (!(this.listObjet.contains(eq))) {
				this.listObjet.add(eq);
				if (this.listObjet.contains(eq)) {
					return true;
				}
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
