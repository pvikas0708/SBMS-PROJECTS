package in.vikas;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertObjToJson {

	public static void main(String[] args) throws Exception {

		Customer c = new Customer(101, "vikas", "vikas@gmail.com");

		// convert object to json format.

		ObjectMapper mapper = new ObjectMapper();

		mapper.writeValue(new File("customer.json"), c); // take file method

		System.out.println("Completed..!");
	}
}
