package practice;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//Capture full page screenshot
		
		/*TakesScreenshot ts=(TakesScreenshot) driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\Jairo\\eclipse-workspace\\SeleniumPractice\\screenshots\\fullpage.png");
		
		FileUtils.copyFile(src, trg);
		*/
		//capture screenshot of specific are from page
		
		WebElement featuredProducts=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
		File src=featuredProducts.getScreenshotAs(OutputType.FILE);
		File trg=new File("C:\\Users\\Jairo\\eclipse-workspace\\SeleniumPractice\\screenshots\\featuredProducts.png");
		FileUtils.copyFile(src, trg);
		

	}

}
