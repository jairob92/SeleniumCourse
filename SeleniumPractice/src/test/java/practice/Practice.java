package practice;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		
		WebElement departureSelect=driver.findElement(By.name("fromPort"));
		WebElement destinationSelect=driver.findElement(By.name("toPort"));
		
		Select departureOptions=new Select(departureSelect);
		Select destinationOptions=new Select(destinationSelect);
		
		//Select options departure=Boston / Destination: Berlin
		
		departureOptions.selectByValue("Boston");
		destinationOptions.selectByValue("Berlin");
		
		driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
		
		int rows=driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		
		System.out.println("Total rows: "+rows);
		
		String priceArray[]=new String[rows];
		
		for(int r=1; r<=rows; r++) {
			
			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			priceArray[r-1]=price;
			
		}
		for(String element:priceArray) {
			System.out.println("Element: "+element);
		}
		Arrays.sort(priceArray);
		
		String lowerPrice=priceArray[0];
		System.out.println("fligh lower prices is: "+lowerPrice);
		
		for(int r=1; r<=rows; r++) {
			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			
			if(price.equals(lowerPrice)) {
				
				driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[1]")).click();
				break;
			}
			
		}
		
		//register passenger
		
		driver.findElement(By.id("inputName")).sendKeys("Jairo");
		driver.findElement(By.id("address")).sendKeys("Street HV-123");
		driver.findElement(By.id("city")).sendKeys("Misissauga");
		driver.findElement(By.id("state")).sendKeys("Ontario");
		driver.findElement(By.id("zipCode")).sendKeys("685214");
		
		WebElement methodPayment=driver.findElement(By.name("cardType"));
		Select payments=new Select(methodPayment);
		payments.selectByValue("amex");
		
		driver.findElement(By.id("creditCardNumber")).sendKeys("45123177891");
		WebElement cardMonth= driver.findElement(By.id("creditCardMonth"));
		cardMonth.clear();
		cardMonth.sendKeys("1");	
		WebElement cardYear= driver.findElement(By.id("creditCardYear"));
		cardYear.clear();
		cardYear.sendKeys("2025");
		
		driver.findElement(By.id("nameOnCard")).sendKeys("Jairo Bermudez");
		driver.findElement(By.xpath("//input[contains(@class,'btn btn-primary')]")).click();
		
		
		
		
		
		
		

	}

}
