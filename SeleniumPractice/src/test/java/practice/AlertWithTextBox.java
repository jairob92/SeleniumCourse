package practice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertWithTextBox {

	public static void main(String[] args) throws InterruptedException {
WebDriverManager.chromedriver().setup();
		
		WebDriver driver =new ChromeDriver();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		
		Alert alertWindow=driver.switchTo().alert();
		alertWindow.sendKeys("Bienvenido a Selenium");
		alertWindow.accept();
		String resultado=driver.findElement(By.id("result")).getText();
		System.out.println(resultado);
		if(resultado.contains("Bienvenido a Selenium")) {
			System.out.println("Prueba exitosa");
		}
		else
		{
			System.out.println("Prueba Fallida");
		}
		
		
		//Alert alertWindow=wait.until(ExpectedConditions.alertIsPresent());

	}

}
