package items;

public class Gant extends Vetement{

	public Gant () {
		super();
		this.setNom(Nom.getNomGant());
		super.setEncombrement(super.getEncombrement() + 1);
		super.setProtection(super.getProtection() + 2);
	}
}
