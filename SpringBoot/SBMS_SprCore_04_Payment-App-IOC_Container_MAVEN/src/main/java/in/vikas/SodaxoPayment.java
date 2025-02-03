package in.vikas;

public class SodaxoPayment implements IPayment {

	public SodaxoPayment() {
		System.out.println("SodaxoCardPayment::Constructor..!");
	}

	@Override
	public boolean pay(double amt) {

		System.out.println("Sodaxo payment in Progress...!");

		return true;
	}
}
