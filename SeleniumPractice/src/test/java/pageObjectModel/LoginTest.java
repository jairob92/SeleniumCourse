package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	
	WebDriver driver;
	LoginPage lp;

	@BeforeClass
	void setUp() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		
	}
	@Test(priority = 1)
	void testLogin() throws InterruptedException {
		
		lp=new LoginPage(driver);
		lp.setUsername("Admin");
		lp.setPassword("admin123");
		lp.ClickOnBtnLogin();
		Thread.sleep(5000);
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		
	}
	@AfterClass
	void tearDown() {
		driver.quit();
	}
}
