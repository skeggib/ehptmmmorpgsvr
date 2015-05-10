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
		
		Pixel[][] tbl = image.getTableau();
		
		for (int i = 0; i < tbl.length; i++) {
			for (int j = 0; j < tbl[i].length; j++) {
				System.out.print(tbl[i][j].getCouleur() + tbl[i][j].getCar());
			}
			System.out.print("\n");
		}
		
	}

}
