package in.vikasit;

public class DebitCardPayment implements IPayment {

	@Override
	public boolean pay(double amt) {

		System.out.println("Debit Card payment in progress..!");

		// logic

		return true;
	}
}
