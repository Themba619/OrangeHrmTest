package practice.TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GroupDemo {

	// Sanity
	@Test(groups = {"login", "sanity"})
	public void login_1() {
		Assert.assertEquals(true, true);
		System.out.println("Login 1");
	}
	
	@Test(groups = "login")
	public void login_2() {
		System.out.println("Login 2");
	}
	
	@Test(groups = "reset")
	public void resetPassword_1() {
		System.out.println("reset password 1");
	}
	
	// Sanity
	@Test(groups = {"reset", "sanity"}, dependsOnMethods = "login_1")
	public void resetPassword_2() {
		System.out.println("reset password 2");
	}
}
