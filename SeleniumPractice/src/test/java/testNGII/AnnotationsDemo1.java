package testNGII;

import org.testng.annotations.*;

public class AnnotationsDemo1 {

	@BeforeMethod
	void login() {
		System.out.println("Login...");
	}
	@Test(priority = 1)
	void search() {
		System.out.println("Search...");
	}
	@Test (priority = 2)
	void advancedSearch() {
		System.out.println("AdvancedSearch...");
	}@AfterMethod
	void logout() {
		System.out.println("Logout...");
	}
}
