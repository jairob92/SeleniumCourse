package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		
		WebElement desktop=driver.findElement(By.xpath("(//a[contains(.,'Desktops')])[1]"));
		WebElement mac=driver.findElement(By.xpath("//a[contains(@href,'27')]"));
		
		Actions act= new Actions(driver);
		
		//Mouse Hover
		
		act.moveToElement(desktop).moveToElement(mac).click().build().perform();

	}

}
