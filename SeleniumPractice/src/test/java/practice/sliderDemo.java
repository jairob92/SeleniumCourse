package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class sliderDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		WebElement firstSlider=driver.findElement(By.xpath("(//span[contains(@tabindex,'0')])[1]"));
		
		Actions action= new Actions(driver);
		
		System.out.println("Current Location"+firstSlider.getLocation()); ///(59,250) x,y
		
		action.dragAndDropBy(firstSlider, 100, 250).perform();
		
		System.out.println("After move Location"+firstSlider.getLocation()); ///(59,250) x,y
		
		WebElement secondtSlider=driver.findElement(By.xpath("(//span[contains(@tabindex,'0')])[2]"));
		
		System.out.println("Current Location second slider"+secondtSlider.getLocation()); ///(59,250) x,y
		
		action.dragAndDropBy(secondtSlider, -66, 250).perform();
		
		
		
	}

}
