package mmorpg.affichage.fenetre;

import mmorpg.affichage.Matrice;
import mmorpg.affichage.Pixel;
import mmorpg.exceptions.affichage.fenetre.CantDrawWindowException;
import mmorpg.jeu.Log;

public class FenetreLog extends Fenetre {
	
	private static final long serialVersionUID = 1L;
	
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
	
	private boolean dessinerLog() throws CantDrawWindowException {
		if (this.log == null)
			throw new CantDrawWindowException("Les logs ne sont pas definis");
		
		String[] messages;
		messages = this.log.getDerniersMessages(this.getMatrice().getHauteur());
		
		Pixel remplissage = new Pixel(' ', "BLACK", "WHITE");
		int matriceH = this.getMatrice().getHauteur();
		int matriceW = this.getMatrice().getLargeur();
		this.getMatrice().dessinerRectangle(0, 0, matriceW, matriceH, remplissage);
		for (int i = 0; i < messages.length; i++) {
			this.getMatrice().dessinerTexte(0, i, messages[i], "BLACK", "WHITE");
		}
		
		return true;
	}
	
	public Matrice getMatriceFen() throws CantDrawWindowException {
		try {
			this.dessinerLog();
			return super.getMatriceFen();
		} catch(CantDrawWindowException e) {
			throw e;
		}
	}
	
	/* --- GETTERS / SETTERS --- */
	
	public void setLog(Log log) {
		this.log = log;
	}
	
}
