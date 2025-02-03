package in.vikas.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {

	
	public String getName()
	{
		int i=10/0;
		
		
		return "Laptop";
	}
}
