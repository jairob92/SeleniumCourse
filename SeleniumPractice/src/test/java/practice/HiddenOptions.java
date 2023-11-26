package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HiddenOptions {

	public static void main(String[] args) {
		
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		driver.findElement(By.xpath("//button[@type='submit'][contains(.,'Login')]")).click();
		
		driver.findElement(By.xpath("//span[contains(.,'PIM')]")).click();
		
		//PIM module
		
		driver.findElement(By.xpath("//form/div[1]/div/div[3]/div/div[2]/div/div/div[2]/i")).click();
		
		List<WebElement>opciones=driver.findElements(By.xpath("//div[@role='option']//span"));
		
		for(WebElement op:opciones) {
			
			if(op.getText().equals("Full-Time Permanent")) {
				
				op.click();
				break;
			}
		}

	}

}
