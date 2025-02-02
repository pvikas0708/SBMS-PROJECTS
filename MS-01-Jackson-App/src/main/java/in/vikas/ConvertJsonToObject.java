package in.vikas;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertJsonToObject {

	public static void main(String[] args) throws Exception {

		// json conversion to java object

		File f = new File("customer.json");

		ObjectMapper mapper = new ObjectMapper();

		Customer customer = mapper.readValue(f, Customer.class); // choose file method.

		System.out.println(customer);

	}
}
