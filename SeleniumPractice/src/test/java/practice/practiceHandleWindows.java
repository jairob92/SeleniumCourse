package practice;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceHandleWindows {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.className("wikipedia-search-input")).sendKeys("selenium");
		driver.findElement(By.className("wikipedia-search-button")).click();
		
		driver.findElement(By.xpath("//a[@href='https://en.wikipedia.org/wiki/Selenium']")).click();
		driver.findElement(By.xpath("//a[contains(@href,'biology')]")).click();
		
		Set<String> windowsIDs=driver.getWindowHandles();
		
		for(String winid:windowsIDs) {
			
			String title=driver.switchTo().window(winid).getTitle();
			System.out.println(title);
			
			if(title.equals("Selenium in biology - Wikipedia") || title.equals("Selenium - Wikipedia")) {
				driver.close();
			}
		}
		

	}

}
