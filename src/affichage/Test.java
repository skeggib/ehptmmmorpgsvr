package affichage;

public class Test {

	public static void main(String[] args) {
		
		String str = new String();
		str += " o \n";
		str += "---\n";
		str += " | \n";
		str += "/ \\";
		
		Image img = new Image();
		img.chargerString(str);
		
		Matrice mat = new Matrice(50, 50);
		mat.dessinerImage(10, 10, img);
		mat.afficher();
		
	}

}
