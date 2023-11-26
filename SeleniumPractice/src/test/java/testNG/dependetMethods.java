package testNG;

import org.testng.Assert;
import org.testng.annotations.Test;

public class dependetMethods {
	
	@Test(priority = 1)
	void openApp() {
		Assert.assertTrue(true);
	}
	@Test(priority = 2, dependsOnMethods = {"openApp"})
	void login() {
		Assert.assertTrue(true);
	}
	@Test (priority = 3,dependsOnMethods = {"login"})
	void search() {
		Assert.assertTrue(true);
	}
	@Test (priority = 4, dependsOnMethods = {"search"})
	void Andvancedsearch() {
		Assert.assertTrue(false);
	}
	@Test (priority = 5, dependsOnMethods = {"login","Andvancedsearch"})
	void logout() {
		Assert.assertTrue(true);
	}
}
