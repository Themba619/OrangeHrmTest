package practice.TestNG;

import org.testng.annotations.Test;

public class SignUpDemo {

	// Sanity
	@Test(groups = "sanity")
	public void createAccount() {
		System.out.println("Account created.");
	}
	
	@Test
	public void createAccount_2() {
		System.out.println("Account 2 created.");
	}
}
