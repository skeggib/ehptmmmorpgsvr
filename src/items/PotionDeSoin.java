package items;

import java.util.Random;

public class PotionDeSoin extends Potion{

	private Random rand = new Random ();
	
	private int soin;
	
	public PotionDeSoin () {
		this.setSoin((rand.nextInt(3) + 1));
		this.setNom(Nom.getNomPotionSoin(this.getSoin() - 1));
	}
	public int getSoin(){
		return this.soin;
	}
	public void setSoin(int value){
		this.soin = value;
	}
}
