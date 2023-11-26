package practice;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindows {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com'][contains(.,'OrangeHRM, Inc')]")).click();
		
		
		//capture id's for windows
		
		driver.getWindowHandles();
		
		Set<String> windowIDS= driver.getWindowHandles();
		
		List<String>windowsList=new ArrayList(windowIDS);
		
		String parentWindow=windowsList.get(0);
		String childWindow=windowsList.get(1);
		
		//Switch to child Window
		
		driver.switchTo().window(childWindow);
		driver.findElement(By.xpath("(//button[@class='btn btn-ohrm btn-free-demo'][contains(.,'Contact Sales')])[2]")).click();
		
		driver.switchTo().window(parentWindow);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		//closing  specific windows browser
		
		for(String winid:windowIDS) {
			
			String title=driver.switchTo().window(winid).getTitle();
			if(title.equals("OrangeHRM")) {
				driver.close();
			}
		}

	}

}
