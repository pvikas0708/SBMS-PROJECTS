package in.vikasit;

public class Car {

	 Engine eng = null; // Its Engine Interface obj creation

	//Constructor injection
	public Car(Engine eng) {
		this.eng = eng;
	}
	
	//setter injection
	public void setEng(Engine eng)
	{
		this.eng=eng;
	}

	public void drive() {

		int status = eng.start();

		if (status >= 1) {
			System.out.println("Congrats,Journey Started..!");
		} else {
			System.out.println("Sorry, Engine Problem...!");
		}
	}

}
