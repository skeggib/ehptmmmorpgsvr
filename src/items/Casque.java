package items;

public class Casque extends Vetement{

	public Casque () {
		super();
		this.setNom(Nom.getNomCasque());
		super.setEncombrement(super.getEncombrement() + 1);
		super.setProtection(super.getProtection() + 2);
	}
}
