package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class doubleClickEvent {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick");
		
		driver.switchTo().frame("iframeResult");
		
		WebElement button =driver.findElement(By.xpath("//button[contains(@ondblclick,'myFunction()')]"));
		
		Actions action= new Actions(driver);
		
		action.doubleClick(button).perform();
		
		String message=driver.findElement(By.xpath("//p[contains(@id,'demo')]")).getText();
		
		if(message.equals("Hello World")) {
			
			System.out.println("succesfull test");
			Thread.sleep(2000);
			driver.quit();
		}
	}

}
