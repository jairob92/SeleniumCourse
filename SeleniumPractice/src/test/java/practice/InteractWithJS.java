package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractWithJS {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		WebElement inputbox=driver.findElement(By.id("name"));
		
		js.executeScript("arguments[0].setAttribute('value','Jairo')", inputbox);
		
		//radiobutton
		
		WebElement maleRadioButton=driver.findElement(By.id("male"));
		//maleRadioButton.click();
		
		js.executeScript("arguments[0].click()", maleRadioButton);

	}

}
