package items;

import java.util.Random;

public class Arme extends Objet {

	private int qualite = 0;
	
	private Random rand = new Random ();

	private final static int MAUVAIS = 0;
	private final static int COMMUN = 1;
	private final static int INHABITUEL = 2;
	private final static int RARE = 3;
	private final static int EPIQUE = 4;
	private final static int LEGENDAIRE = 5;

	private int maniabilite = 0;
	private int impact = 0;		
	private int parade = 0;		
	
	public Arme () {
		this.setNom(Nom.getNomArme());
		
		int resultRand = rand.nextInt(1001);
		if(resultRand < 200){
			this.setQualite(Arme.MAUVAIS);
		} else if (resultRand >= 200 && resultRand < 600){
			this.setQualite(Arme.COMMUN);
		} else if (resultRand >= 600 && resultRand < 850){
			this.setQualite(Arme.INHABITUEL);
		} else if (resultRand >= 850 && resultRand < 950){
			this.setQualite(Arme.RARE);
		} else if (resultRand >= 950 && resultRand < 1000){
			this.setQualite(Arme.EPIQUE);
		} else if (resultRand == 1000){
			this.setQualite(Arme.LEGENDAIRE);
		}
		
		switch (this.getQualite()){
		case 0 : 
			this.setManiabilite(rand.nextInt(2) + 2);
			this.setImpact(rand.nextInt(2) + 2);
			this.setParade(rand.nextInt(2) + 5);
			break;
		case 1 : 
			this.setManiabilite(rand.nextInt(2) + 3);
			this.setImpact(rand.nextInt(2) + 3);
			this.setParade(rand.nextInt(2) + 6);
			break;
		case 2 : 
			this.setManiabilite(rand.nextInt(3) + 4);
			this.setImpact(rand.nextInt(3) + 4);
			this.setParade(rand.nextInt(3) + 7);
			break;
		case 3 : 
			this.setManiabilite(rand.nextInt(3) + 5);
			this.setImpact(rand.nextInt(3) + 5);
			this.setParade(rand.nextInt(3) + 8);
			break;
		case 4 : 
			this.setManiabilite(rand.nextInt(3) + 6);
			this.setImpact(rand.nextInt(3) + 6);
			this.setParade(rand.nextInt(3) + 9);
			break;
		case 5 : 
			this.setManiabilite(9);
			this.setImpact(9);
			this.setParade(12);
			break;
		default : break;
		}
	}
	
	private String qualiteToString () {
		switch (this.qualite) {
		case Arme.MAUVAIS:
			return "Ce vetement est de mauvaise qualite";	
		case Arme.COMMUN:
			return "Ce vetement est commun";
		case Arme.INHABITUEL:
			return "Ce vetement est inhabituel";
		case Arme.RARE:
			return "Ce vetement est rare";
		case Arme.EPIQUE:
			return "Ce vetement est epique!";
		case Arme.LEGENDAIRE:
			return "Ce vetement est legendaire!";
		default: return "";
		}
	}
	
	public String toString () {
		String result = "";
		result += this.getNom() + "\n";
		result += this.qualiteToString() + "\n";
		result += "maniabilite : " + this.getManiabilite() + "\n";
		result += "impact : " + this.getImpact();
		return result;
	}

	/**
	 * @return the qualite
	 */
	public int getQualite() {
		return qualite;
	}


	/**
	 * @param qualite the qualite to set
	 */
	public void setQualite(int qualite) {
		this.qualite = qualite;
	}


	/**
	 * @return the maniabilite
	 */
	public int getManiabilite() {
		return maniabilite;
	}


	/**
	 * @param maniabilite the maniabilite to set
	 */
	private void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}


	/**
	 * @return the impact
	 */
	public int getImpact() {
		return impact;
	}


	/**
	 * @param impact the impact to set
	 */
	private void setImpact(int impact) {
		this.impact = impact;
	}


	/**
	 * @return the parade
	 */
	public int getParade() {
		return parade;
	}


	/**
	 * @param parade the parade to set
	 */
	public void setParade(int parade) {
		this.parade = parade;
	}
}
