package fichiers;

public class Test {

	public static void main(String[] args) {
		
		String[] lines = LectureFichier.lire("../carte/test");
		
		for(int i = 0; i < lines.length; i++) {
			System.out.println(lines[i]);
		}

	}

}
