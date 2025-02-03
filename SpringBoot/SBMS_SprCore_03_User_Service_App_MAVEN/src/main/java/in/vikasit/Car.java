package in.vikasit;

public class Car {

	public Car()
	{
		System.out.println("Car:: Constructor..!");
	}
	
	private IEngine eng;
	
	public void setEng(IEngine eng)
	{
		this.eng=eng;
		System.out.println("SetEngine Method Called..!");
		System.out.println("Injected::"+eng.getClass().getName() );
	}

	
	public void drive()
	{
		boolean status= eng.start();
		if(status)
		{
			System.out.println("Journey Started..!");
		}
		else
		{
			System.out.println("Engine fault..!");
		}
	}
}
