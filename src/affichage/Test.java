package affichage;

public class Test {

	public static void main(String[] args) {
		
		String str = "";
		str += "argh\n";
		str += "bbbh\n";
		str += "aazh\n";
		str += "----\n";
		
		Image image = new Image();
		image.chargerString(str);
		image.setCouleur("RED");
		
		Matrice matr = new Matrice(50, 20);
		matr.dessinerImage(10, 10, image);
		matr.afficher();
		
	}

}
