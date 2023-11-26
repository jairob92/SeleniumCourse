package practiceAnnotations;

import org.testng.annotations.*;

public class practiceAnnotantions2 {

	@BeforeSuite
	void bs() {
		System.out.println("This is before suite...");
	}
	@BeforeClass
	void bc() {
		System.out.println("This is before class...");
	}
	@BeforeMethod
	void bm() {
		System.out.println("This is before method...");
	}
	@BeforeTest
	void bt() {
		System.out.println("This is before test...");
	}@Test
	void t1() {
		System.out.println("This is Test1 class 2...");
	}
	@Test
	void t2() {
		System.out.println("This is Test2 class 2...");
	}
	@AfterTest
	void at() {
		System.out.println("This is after test...");
	}@AfterMethod
	void am() {
		System.out.println("This is after method...");
	}
	@AfterClass
	void ac() {
		System.out.println("This is after class...");
	}@AfterSuite
	void as() {
		System.out.println("This is after suite...");
	}
	
	
	
}
