package in.vikas;

public class CreditCardPayment implements IPayment {

	public CreditCardPayment() {
		System.out.println("CreditCardPayment Constructor..!");
	}

	@Override
	public boolean pay(double amt) {

		System.out.println("CreditCard Payment is in progress...!");

		// logic
		return true;
	}
}
