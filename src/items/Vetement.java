package items;

import java.util.Random;

abstract public class Vetement extends Objet {
	private int encombrement = 0;
	private int protection = 0;
	private int qualite = 0;

	private Random rand = new Random ();

	private final static int MAUVAIS = 0;
	private final static int COMMUN = 1;
	private final static int INHABITUEL = 2;
	private final static int RARE = 3;
	private final static int EPIQUE = 4;
	private final static int LEGENDAIRE = 5;

	/**
	 * Constructeur par defaut
	 * 
	 * Donne une qualite a l'objet et lui attribut un encombrement et une protection en consequence
	 */
	public Vetement () {
		int resultRand = rand.nextInt(1001);
		if(resultRand < 200){
			this.setQualite(Vetement.MAUVAIS);
		} else if (resultRand >= 200 && resultRand < 600){
			this.setQualite(Vetement.COMMUN);
		} else if (resultRand >= 600 && resultRand < 850){
			this.setQualite(Vetement.INHABITUEL);
		} else if (resultRand >= 850 && resultRand < 950){
			this.setQualite(Vetement.RARE);
		} else if (resultRand >= 950 && resultRand < 1000){
			this.setQualite(Vetement.EPIQUE);
		} else if (resultRand == 1000){
			this.setQualite(Vetement.LEGENDAIRE);
		}

		switch (this.getQualite()){
		case Vetement.MAUVAIS : 
			this.setEncombrement(rand.nextInt(3) + 2);
			this.setProtection(rand.nextInt(3) + 2);
			break;
		case Vetement.COMMUN : 
			this.setEncombrement(rand.nextInt(3) + 2);
			this.setProtection(rand.nextInt(3) + 3);
			break;
		case Vetement.INHABITUEL : 
			this.setEncombrement(rand.nextInt(2) + 2);
			this.setProtection(rand.nextInt(3) + 4);
			break;
		case Vetement.RARE : 
			this.setEncombrement(rand.nextInt(2) + 1);
			this.setProtection(rand.nextInt(3) + 5);
			break;
		case Vetement.EPIQUE : 
			this.setEncombrement(rand.nextInt(2) + 1);
			this.setProtection(rand.nextInt(3) + 6);
			break;
		case Vetement.LEGENDAIRE : 
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
	
	private String qualiteToString () {
		switch (this.qualite) {
		case Vetement.MAUVAIS:
			return "Ce vetement est de mauvaise qualite";	
		case Vetement.COMMUN:
			return "Ce vetement est commun";
		case Vetement.INHABITUEL:
			return "Ce vetement est inhabituel";
		case Vetement.RARE:
			return "Ce vetement est rare";
		case Vetement.EPIQUE:
			return "Ce vetement est epique!";
		case Vetement.LEGENDAIRE:
			return "Ce vetement est legendaire!";
		default: return "";
		}
	}

	public String toString () {
		String result = "";
		result += this.getNom() + "\n";
		result += this.qualiteToString() + "\n";
		result += "encombrement : " + this.getEncombrement() + "\n";
		result += "protection : " + this.getProtection();
		return result;
	}
}
