package carte;

public class Case {

	private ContenuCase contenu;
	
	public Case() {
		contenu = null;
	}

	public ContenuCase getContenu() {
		return contenu;
	}

	public void setContenu(ContenuCase contenu) {
		this.contenu = contenu;
	}
	
	public String toString() {
		return "Contient : " + ((Object) this.contenu).getClass().getName();
	}
	
}
