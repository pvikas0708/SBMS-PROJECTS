package in.vikasit;

public class CreditCardPayment implements IPayment {

	@Override
	public boolean pay(double amt) {

		System.out.println("Credit payment in progress...!");

		// logic

		return true;

	}
}
