package controles;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		Clavier clavier = new Clavier();
		
		clavier.start();
		
		while (true) {
			Thread.sleep(500);
			System.out.println("test");
		}

	}

}
