package in.vikas.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = NoUserFoundException.class)
	public ResponseEntity<AppExceptionInfo> handleUserException(NoUserFoundException e) {

		AppExceptionInfo info = new AppExceptionInfo();
		info.setExCode("SBIX008"); // in real project code will be provided
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDateTime.now());

		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST); // client site problem
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<AppExceptionInfo> handleAppException(Exception e) {

		AppExceptionInfo info = new AppExceptionInfo();
		info.setExCode("SBIX007"); // in real project code will be provided
		info.setExMsg(e.getMessage());
		info.setExDate(LocalDateTime.now());

		return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
