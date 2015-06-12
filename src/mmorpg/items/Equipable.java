package mmorpg.items;

import java.util.Random;

public abstract class Equipable extends Item{
	//TODO skeggib : UML suppression d'un setter
	/*
	 * Constantes
	 */
	
	private static final long serialVersionUID = 975119552156210907L;
	
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
			this.qualite = Equipable.MAUVAIS;
		} else if (resultRand >= 200 && resultRand < 600){
			this.qualite = Equipable.COMMUN;
		} else if (resultRand >= 600 && resultRand < 850){
			this.qualite = Equipable.INHABITUEL;
		} else if (resultRand >= 850 && resultRand < 950){
			this.qualite = Equipable.RARE;
		} else if (resultRand >= 950 && resultRand < 1000){
			this.qualite = Equipable.EPIQUE;
		} else if (resultRand == 1000){
			this.qualite = Equipable.LEGENDAIRE;
		}
	}
	public Equipable (int qualite) {
		this.qualite = qualite;
	}

	public Equipable(Equipable eq){
		this.qualite = eq.getQualite();
	}
	
	/*
	 * Methode d'acces
	 */

	public int getQualite() {
		return this.qualite; //
	}

}
