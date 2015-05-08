package items;

import java.util.Random;

public class Arme extends Objet {

	private int qualite = 0;
	
	private Random rand = new Random ();

	// TODO: Tu devrai mettre un static pour les attributs en dessous
	private final int MAUVAIS = 0;
	private final int COMMUN = 1;
	private final int INHABITUEL = 2;
	private final int RARE = 3;
	private final int EPIQUE = 4;
	private final int LEGENDAIRE = 5;

	private int maniabilite = 0;
	private int impact = 0;		
	private int parade = 0;		
	
	public Arme () {
		this.setNom(Nom.getNomArme());
		
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
