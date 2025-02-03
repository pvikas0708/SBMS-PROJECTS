package in.vikas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.vikas.dao.UserDAO;

@Component
public class IUserService {

	@Autowired
	private PwdService pwdservice; // for passward incryption
	@Autowired
	private UserDAO userDao;
	@Autowired
	private EmailService emailservice;

	/*
	 * //to avoid nullpointer exception dependency injection is required.
	 * 
	 * @Autowired public void setPwdservice(PwdService pwdservice) { this.pwdservice
	 * = pwdservice; }
	 * 
	 * @Autowired public void setUserDao(UserDAO userDao) { this.userDao = userDao;
	 * }
	 * 
	 * @Autowired public void setEmailservice(EmailService emailservice) {
	 * this.emailservice = emailservice; }
	 */

	// constructor constructor..

	/*
	 * @Autowired public IUserService(PwdService pwdservice, UserDAO userDao,
	 * EmailService emailservice) { this.pwdservice = pwdservice; this.userDao =
	 * userDao; this.emailservice = emailservice;
	 * 
	 * System.out.println("Three Args Constructor..!"); }
	 */

	public void registerUser(String name, String email, String pwd) {
		// encrypt pwd
		String encryptPwd = pwdservice.encryptPwd(pwd);

		// save user in DB
		boolean isSaved = userDao.saveUser(name, email, encryptPwd);

		// send email
		if (isSaved) {
			boolean isSent = emailservice.sendEmail(email, "Test Subject", "Test Body");

			if (isSent) {
				System.out.println("Great,User Registration Completed..!");
			}

		}
	}

}
