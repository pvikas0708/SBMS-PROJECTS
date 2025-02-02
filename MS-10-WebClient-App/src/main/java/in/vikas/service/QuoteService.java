package in.vikas.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Service
public class QuoteService {

	private static final String QUOTE_ENDPOINT = "https://www.facebook.com/login.php/";

	//Asynchronous client =>Don't waits, can not create with Rest Templete
	public void getQuotev2() {
		WebClient client = WebClient.create();

		System.out.println("Rest API call Started....!,");
		
							client.get()// it is used to get response
							.uri(QUOTE_ENDPOINT)
							.header("Accept", "application/json")//setting header is not manditory
							.retrieve()
							.bodyToMono(String.class)
							.subscribe(QuoteService::handleResponse);// takes consumer(java 8 functional Interface) as input
		//after call started the thread gets executed without stopping for response custom()=>handleResponse will take care of respponse
		System.out.println("Rest API call Completed...!");
	}
	public static void handleResponse(String s)
	{//this method will take care of response
		System.out.println(s);
	}
	
	//synchronous=>waits can create with Rest Templete
	public void getQuotev1() {
		WebClient client = WebClient.create();

		System.out.println("Rest API call Started....!,");
		Mono<String> bodyToMono = client.get()// it is used to get response
										.uri(QUOTE_ENDPOINT)
										.retrieve()
										.bodyToMono(String.class);
		System.out.println(bodyToMono.block());//will wait for response form API
		System.out.println("Rest API call Completed...!");
	}
}
