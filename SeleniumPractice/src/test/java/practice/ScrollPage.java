package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollPage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
		
		JavascriptExecutor js=driver;
		
		//scroll down
		
		//js.executeScript("window.scrollBy(0,6000)", "");
		
		WebElement canadianFlag=driver.findElement(By.xpath("//img[contains(@alt,'Flag of Canada')]"));
		
		js.executeScript("arguments[0].scrollIntoView()", canadianFlag);
		System.out.println(js.executeScript("return window.pageYOffset"));
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)", "");
		
		Thread.sleep(2000);
		
		js.executeScript("window.scrollBy(0, -document.body.scrollHeight)", "");
	}

}
