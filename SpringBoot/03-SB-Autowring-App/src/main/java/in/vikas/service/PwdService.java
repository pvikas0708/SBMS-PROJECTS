package in.vikas.service;

import org.springframework.stereotype.Component;

@Component
public class PwdService {

	public String encryptPwd(String pwd) {
		// encryption logic(MD,SHA,AES,BCrypto)

		System.out.println("Password Increption Completed..!");

		return pwd;
	}
}
