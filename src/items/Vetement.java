package items;

import java.util.Random;

abstract public class Vetement extends Objet {
	private int encombrement = 0;
	private int protection = 0;
	private int qualite = 0;
	
	private Random rand = new Random ();

	private final int MAUVAIS = 0;
	private final int COMMUN = 1;
	private final int INHABITUEL = 2;
	private final int RARE = 3;
	private final int EPIQUE = 4;
	private final int LEGENDAIRE = 5;
	
	/**
	 * Constructeur par defaut
	 * 
	 * Donne une qualité a l'objet et lui attribut un encombrement et une protection en consequence
	 */
	public Vetement () {
		int resultRand = rand.nextInt(1001);
		if(resultRand < 200){
			this.setQualite(this.MAUVAIS);
		} else if (resultRand >= 200 && resultRand < 600){
			this.setQualite(this.COMMUN);
		} else if (resultRand >= 600 && resultRand < 850){
			this.setQualite(this.INHABITUEL);
		} else if (resultRand >= 850 && resultRand < 950){
			this.setQualite(this.RARE);
		} else if (resultRand >= 950 && resultRand < 1000){
			this.setQualite(this.EPIQUE);
		} else if (resultRand == 1000){
			this.setQualite(this.LEGENDAIRE);
		}
		
		switch (this.getQualite()){
		case 0 : 
			this.setEncombrement(rand.nextInt(3) + 2);
			this.setProtection(rand.nextInt(3) + 2);
			break;
		case 1 : 
			this.setEncombrement(rand.nextInt(3) + 2);
			this.setProtection(rand.nextInt(3) + 3);
			break;
		case 2 : 
			this.setEncombrement(rand.nextInt(2) + 2);
			this.setProtection(rand.nextInt(3) + 4);
			break;
		case 3 : 
			this.setEncombrement(rand.nextInt(2) + 1);
			this.setProtection(rand.nextInt(3) + 5);
			break;
		case 4 : 
			this.setEncombrement(rand.nextInt(2) + 1);
			this.setProtection(rand.nextInt(3) + 6);
			break;
		case 5 : 
			this.setEncombrement(1);
			this.setProtection(9);
			break;
		default : break;
		}
	}
	/**
	 * Retourne l'encombrement de l'objet
	 * @return encombrement
	 */
	public int getEncombrement () {
		return this.encombrement;
	}
	/**
	 * Retourne la protection de l'objet
	 * @return protection
	 */
	public int getProtection () {
		return this.protection;
	}
	/**
	 * @return the qualite
	 */
	public int getQualite() {
		return qualite;
	}
	/**
	 * 
	 * @param qualite
	 */
	public void setQualite(int qualite) {
		this.qualite = qualite;
	}
	/**
	 * 
	 * @param value
	 */
	public void setEncombrement (int value) {
		this.encombrement = value;
	}
	/**
	 * 
	 * @param value
	 */
	public void setProtection (int value) {
		this.protection = value;
	}
}
