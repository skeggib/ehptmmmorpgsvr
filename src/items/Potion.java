package items;

public class Potion extends Objet {
	private int degat;
	private int soin;
	
	/**
	 * Effet de la potion
	 */
	public void effet () {
		
	}

	/**
	 * @return degat
	 */
	public int getDegat() {
		return degat;
	}

	/**
	 * @param degat Defini les degat infliger par la potion
	 */
	public void setDegat(int degat) {
		this.degat = degat;
	}

	/**
	 * @return soin
	 */
	public int getSoin() {
		return soin;
	}

	/**
	 * @param soin Soin a apporter a l'utilisateur
	 */
	public void setSoin(int soin) {
		this.soin = soin;
	}
}
