package items;

public class Objet {
	private String nom;
	
	/**
	 * Constructeur par defaut
	 */
	public Objet () {
		
	}
	/**
	 * Retourne le nom de l'objet
	 * @return nom
	 */
	public String getNom (){
		return this.nom;
	}
	public void setNom (String value){
		this.nom = value;
	}
}
