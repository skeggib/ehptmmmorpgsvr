package affichage.fenetre;

import affichage.Matrice;
import affichage.Pixel;
import jeu.Log;

public class FenetreLog extends Fenetre {
	
	Log log;
	
	/* --- CONSTRUCTEURS --- */
	
	public FenetreLog() {
		super();
		this.setTitre("Log");
	}
	
	public FenetreLog(int w, int h) {
		super(w, h);
		this.setTitre("Log");
	}
	
	public FenetreLog(Log log) {
		this();
		this.setLog(log);
	}
	
	public FenetreLog(Log log, String titre) {
		this(log);
		this.setTitre(titre);
	}
	
	public FenetreLog(Log log, int w, int h, String titre) {
		this(w, h);
		this.setLog(log);
		this.setTitre(titre);
	}
	
	/* --- METHODES --- */
	
	private boolean dessinerLog() { // TODO:skeggib Bug couleur de fond
		if (this.log == null)
			return false;
		
		String[] messages;
		messages = this.log.getDerniersMessages(this.getMatrice().getHauteur());
		
		Pixel remplissage = new Pixel(' ', "BLACK", "WHITE");
		int matriceH = this.getMatrice().getHauteur();
		int matriceW = this.getMatrice().getLargeur();
		this.getMatrice().dessinerRectangle(0, 0, matriceW - 1, matriceH - 1, remplissage);
		for (int i = 0; i < messages.length; i++) {
			this.getMatrice().dessinerTexte(0, i, messages[i], "BLACK", "WHITE");
		}
		
		return true;
	}
	
	public Matrice getMatriceFen() {
		this.dessinerLog();
		return super.getMatriceFen();
	}
	
	/* --- GETTERS / SETTERS --- */
	
	public void setLog(Log log) {
		this.log = log;
	}
	
}
