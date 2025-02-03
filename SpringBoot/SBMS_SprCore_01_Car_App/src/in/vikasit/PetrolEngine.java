package in.vikasit;

public class PetrolEngine implements Engine {

	@Override
	public int start() {

		System.out.println("Petrol Engine Starting..!");

		return 1;
	}
}
