package in.vikas.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // Global Exception Handler
public class AppExceptionHandler {

	@ExceptionHandler(value = Exception.class) // it should execute for any type of exception occured in application
	public String handleExceptionn(Exception e) {
		System.out.println(e.getMessage());
		return "errorView";
	}

}
