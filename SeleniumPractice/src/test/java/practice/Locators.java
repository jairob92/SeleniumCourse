package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Locators {

	public static void main (String[]args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//open application
		
		driver.get("https://magento.softwaretestingboard.com/");
		driver.manage().window().maximize();
		// Selector id
		WebElement searchBox= driver.findElement(By.id("search"));
		searchBox.sendKeys("Tops");
		searchBox.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		//Link Text
		//WebElement product2= driver.findElement(By.linkText("Primo Endurance Tank"));
		//product2.click();

		List <WebElement> busqueda= driver.findElements(By.className("product-item-info"));
		System.out.println("Total products"+busqueda.size());
		
		List <WebElement> imagenes= driver.findElements(By.tagName("img"));
		System.out.println("Total imagenes "+imagenes.size());
		
		
		Thread.sleep(1000);
		driver.close();
		
		
		
		
	
		
	}
}
