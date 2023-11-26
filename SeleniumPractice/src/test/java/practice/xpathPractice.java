package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class xpathPractice {

	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://magento.softwaretestingboard.com/");
		String texto = driver.findElement(By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[1]/span")).getText();
		System.out.println("El texto es :"+texto);
		
		String titulo =driver.getTitle();
		String currentUrl= driver.getCurrentUrl();
		String pageSource= driver.getPageSource();
		
		System.out.println("el titulo es:" + titulo);
		System.out.println("Current URL es :" + currentUrl);
		//System.out.println("Page Source :" + pageSource);
		System.out.println("mensaje "+ driver.getWindowHandle());
		
		boolean logo = driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/a/img")).isEnabled();
		
		if(logo==true) {
			System.out.println("El logo esta disponible");
		}
		else
		{
			System.out.println("El logo no esta disponible");
		}
		
		driver.close();
	}

}
