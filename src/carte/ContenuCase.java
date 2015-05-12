package carte;

public interface ContenuCase {
	
	public static final int NB_TYPES = 7;
	
	public static final int INCONNU = 0;
	public static final int VIDE = 1;
	public static final int MUR = 2;
	public static final int OBJET = 3;
	public static final int JOUEUR = 4;
	public static final int PNJ = 5;
	public static final int MONSTRE = 6;
	
	public int getNumero();

}
