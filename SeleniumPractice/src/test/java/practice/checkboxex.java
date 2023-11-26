package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkboxex {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://artoftesting.com/samplesiteforselenium");
		
		List<WebElement>checkboxs= driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		for(WebElement checks: checkboxs) {
			checks.click();
		}
		

	}

}
