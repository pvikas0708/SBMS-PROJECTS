package in.vikasit;

public class Test {

	public static void main(String[] args) {

		CreditCardPayment ccd = new CreditCardPayment();
		DebitCardPayment debit = new DebitCardPayment();
		SodaxoCardPayment spay = new SodaxoCardPayment();

		// constructor injection
		PaymentProcessor processor = new PaymentProcessor(ccd);

		// Setter injection
		processor.setPayment(debit);

		processor.processPayment(1200.50);
	}
}
