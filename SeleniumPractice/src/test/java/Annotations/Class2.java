package Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Class2 {

	@Test
	void xyz() {
		System.out.println("This is xyz from class 2");
	}
	@AfterTest
	void n() {
	System.out.println("This is after test method...");	
	}
	
}
