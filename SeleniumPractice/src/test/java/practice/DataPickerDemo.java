package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataPickerDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/datepicker/");
		
		driver.manage().window();
		
		driver.switchTo().frame(0);
		
		//driver.findElement(By.id("datepicker")).sendKeys("10/10/2023");
		
		//Approach 2
		
		
		String year="2024";
		String month="March";
		String day="31";
		
		driver.findElement(By.id("datepicker")).click();
		
		while(true) {
			
			String mes=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String anho=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(mes.equals(month) && anho.equals(year)) {
				
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click(); //Next Button
		}
			List<WebElement>dias=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
			
			for(WebElement d:dias) {
				
				if(d.getText().equals(day)) {
					d.click();
					break;
				}
			}
			
		}
		
	

}
