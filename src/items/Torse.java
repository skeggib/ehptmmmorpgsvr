package items;

public class Torse extends Vetement{

	public Torse () {
		super();
		this.setNom(Nom.getNomTorse());
		super.setEncombrement(super.getEncombrement() + 1);
		super.setProtection(super.getProtection() + 2);
	}
}
