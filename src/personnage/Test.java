package personnage;

public class Test {

	public static void main(String[] args) {
		Caracteristique car = new Caracteristique();
		car.setForce(7);
		car.setAdresse(21);
		car.setResistance(5);
		System.out.println("force : " + car.getForce());
		System.out.println("rand ini: " + Capacite.getRandomInitiative(car.getAdresse(), 10));
	}

}
