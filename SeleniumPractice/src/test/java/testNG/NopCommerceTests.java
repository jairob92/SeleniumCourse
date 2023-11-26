package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(testNG.ExtendReportManager.class)
public class NopCommerceTests {
	
	WebDriver driver;
	
	@BeforeClass
	void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		
	}
	@Test (priority = 1)
	void testLogo() {
		
		try {
			boolean logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
			Assert.assertEquals(logo,true);
		}
		catch (Exception e) {
			Assert.fail();
		}
	}
	@Test (priority = 2, dependsOnMethods = {"testLogo"})
	void testLogin() throws InterruptedException {
		try {
			driver.findElement(By.xpath("//a[@class='ico-login']")).click();
			driver.findElement(By.id("Email")).sendKeys("test@qa.com");
			driver.findElement(By.id("Password")).sendKeys("123456");
			driver.findElement(By.xpath("(//button[contains(@type,'submit')])[2]")).click();
			driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/span")).click();
			boolean logout_btn=driver.findElement(By.xpath("//a[@href='/logout']")).isDisplayed();
			Assert.assertEquals(logout_btn, true);
		}catch (Exception e) {
			Assert.fail();
		}
		Thread.sleep(2000);
		
	}@Test(priority = 3, dependsOnMethods = {"testLogin"})
	void testLogout() {
		
			driver.findElement(By.xpath("//a[@href='/logout']")).click();
			try {
				boolean login_btn=driver.findElement(By.xpath("//a[@class='ico-login']")).isDisplayed();
				Assert.assertEquals(login_btn, true);
				
			}catch (Exception e) {
				Assert.fail("Error to logout");
			}	
		}
	@AfterClass
	void tearDown() {
		driver.quit();
		}

	}
