package items;

public class Pantalon extends Vetement{

	public Pantalon () {
		super();
		this.setNom(Nom.getNomJambe());
		super.setEncombrement(super.getEncombrement() + 2);
		super.setProtection(super.getProtection() + 1);
	}
}
