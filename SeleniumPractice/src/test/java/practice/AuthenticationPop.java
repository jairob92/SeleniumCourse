package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticationPop {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		//https://the-internet.herokuapp.com/basic_auth
		//https://admin:admin@the-internet.herokuapp.com/basic_auth
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		driver.manage().window().maximize();
		
		String text= driver.findElement(By.xpath("//p[contains(.,'Congratulations! You must have the proper credentials.')]")).getText();
		
		if(text.contains("Congratulations"))
		{
			System.out.println("Login exitoso");
		}
		else
		{
			System.out.println("Login Fallido");
		}
		
		
		
		
		
		
	}

}
