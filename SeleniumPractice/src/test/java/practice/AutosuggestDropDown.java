package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("Selenium");
		Thread.sleep(3000);
		
		List<WebElement> results=driver.findElements(By.xpath("//div[@class='wM6W7d']//span"));
		
		for(WebElement rs : results) {
			String text=rs.getText();
			if(text.equals("selenium ide")) {
				rs.click();
				break;
			}
		}
		driver.findElement(By.xpath("(//h3[contains(.,'Selenium IDE')])[1]")).click();
		Thread.sleep(3000);
		driver.quit();
		
		

	}

}
