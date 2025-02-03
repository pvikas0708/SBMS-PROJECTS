package in.vikasit;

public class SodaxoCardPayment implements IPayment {

	@Override
	public boolean pay(double amt) {

		System.out.println("Sodaxo Payment in progress...!");
		return true;
	}
}
