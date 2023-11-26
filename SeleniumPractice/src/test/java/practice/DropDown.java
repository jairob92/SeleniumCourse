package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown {
 public static void main (String[]args) {
	 
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver = new ChromeDriver();
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 
	 
	 driver.get("https://phppot.com/demo/country-state-city-example-cascading-jquery-dependent-dropdown/");
	 driver.manage().window().maximize();

	 WebElement dropCountry=driver.findElement(By.id("country-list"));
	 
	 Select dropOption= new Select(dropCountry);
	 
	// dropOption.selectByVisibleText("Brazil");
	 	//dropOption.selectByValue("4");
	 
	 List<WebElement> opciones = dropOption.getOptions();
	 
	 for(WebElement op : opciones)
	 {
		 System.out.println(op.getText());
	 }
	 
	 
	 
	 
	 
	 
 }
}
