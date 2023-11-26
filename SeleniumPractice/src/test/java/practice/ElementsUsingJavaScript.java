package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementsUsingJavaScript {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		//ChromeDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		//driver.switchTo().frame(0);
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		//JavascriptExecutor js= driver;
		
		WebElement inputbox=driver.findElement(By.id("name"));
		js.executeScript("arguments[0].setAttribute('value','Jairo')", inputbox);
		
		

	}

}
