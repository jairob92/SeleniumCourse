package testNG;

import org.testng.annotations.Test;

public class grouping {

	@Test(priority = 1, groups = {"sanity",})
	void login() {
		System.out.println("this is login ...");
	}
	@Test(priority = 2, groups = {"sanity","regression"})
	void loginByFacebook() {
		System.out.println("this is login by Facebook ...");
	}
	@Test(priority = 3, groups = {"regression"})
	void loginBySlack() {
		System.out.println("this is login by Slack ...");
	}
	@Test(priority = 4, groups = {"sanity"})
	void loginByGmail() {
		System.out.println("this is login by gmail ...");
	}
	@Test(priority = 5, groups = {"sanity","regression"})
	void loginByTwitter() {
		System.out.println("this is login by Twitter ...");
	}
}
