package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownwithoutselect {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://practice-automation.com/form-fields/");
		
		
		List<WebElement> elementos =driver.findElements(By.xpath("//ul"));
		
		for(WebElement el : elementos) {
			System.out.println("elementos "+el.getSize());
		}
		
		
		
	}

}
