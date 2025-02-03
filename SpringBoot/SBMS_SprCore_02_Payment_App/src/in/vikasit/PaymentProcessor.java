package in.vikasit;

// This is Target class
public class PaymentProcessor {

	// declare interfece variable to make it loosely coupled

	// user defined refrence value is always null.

	private IPayment payment = null;

	// constructor injection
	public PaymentProcessor(IPayment payment) {
		this.payment = payment;
	}

	// Setter injection
	public void setPayment(IPayment payment) {
		this.payment = payment;
	}

	public void processPayment(double amt) {

		boolean status = payment.pay(amt);

		if (status) {
			System.out.println("Payment Completed, Thank You ...Visit again....!");
		} else {
			System.out.println("Payment Failed..");
		}
	}
}
