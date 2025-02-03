package in.vikasit;

public class Test {

	public static void main(String[] args) {

		// constructor injection.
		Car c = new Car(new DieselEngine());

		// setter injection.
		c.setEng(new PetrolEngine());

		//Field injection
		c.eng=new DieselEngine();
		c.drive();

		// first construction engine will started and then setter enjection will
		// overcome it last initialisation will be final value.
	}
}
