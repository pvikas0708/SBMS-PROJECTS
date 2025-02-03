package in.vikas;

public class PaymentProcessor {

	private IPayment payment;

	// constructor injection
	public PaymentProcessor(IPayment payment) {
		this.payment = payment;
		System.out.println("PaymentProcessor param Constructor");
	}

	// setter injection
	public void setPayment(IPayment payment) {
		this.payment = payment;

		System.out.println("SetPayment() called::" + this.payment.getClass().getName());
		// this will tell us hich dependent object is injected in payment variable. its
		// loosely coupled because interface
	}

	public void ProcessPayment(double amt) {
		boolean status = payment.pay(amt);
		if (status) {

			System.out.println("Thank You..!");
		} else {
			System.out.println("Payment failed...!");
		}
	}
}
