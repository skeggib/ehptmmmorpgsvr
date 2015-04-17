package personnage;

public class Test {

	public static void main(String[] args) {
		Caracteristique car = new Caracteristique();
		Capacite cap = new Capacite();
		car.setForce(7);
		car.setAdresse(21);
		car.setResistance(5);
		System.out.println("force : " + car.getForce());
		System.out.println("rand ini: " + cap.getRandomInitiative(car));
		System.out.println("rand deg: " + cap.getRandomDegat(car));
		System.out.println("rand def: " + cap.getRandomDefense(car));
	}

}
