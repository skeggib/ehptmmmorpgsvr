package items;

import java.util.Random;

public abstract class Equipable extends Objet{
	
	/*
	 * Constantes
	 */
	
	public final static int MAUVAIS = 0;
	public final static int COMMUN = 1;
	public final static int INHABITUEL = 2;
	public final static int RARE = 3;
	public final static int EPIQUE = 4;
	public final static int LEGENDAIRE = 5;
	
	/*
	 * Variables
	 */
	
	private int qualite;
	
	/*
	 * Constructeurs
	 */

	public Equipable () {
		int resultRand = new Random().nextInt(1001);
		if(resultRand < 200){
			this.setQualite(Equipable.MAUVAIS);
		} else if (resultRand >= 200 && resultRand < 600){
			this.setQualite(Equipable.COMMUN);
		} else if (resultRand >= 600 && resultRand < 850){
			this.setQualite(Equipable.INHABITUEL);
		} else if (resultRand >= 850 && resultRand < 950){
			this.setQualite(Equipable.RARE);
		} else if (resultRand >= 950 && resultRand < 1000){
			this.setQualite(Equipable.EPIQUE);
		} else if (resultRand == 1000){
			this.setQualite(Equipable.LEGENDAIRE);
		}
	}
	public Equipable (int qualite) {
		this.setQualite(qualite);
	}

	/*
	 * Methode d'acces
	 */

	public int getQualite() {
		return qualite;
	}


	public void setQualite(int qualite) {
		this.qualite = qualite;
	}
}
