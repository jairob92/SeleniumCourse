package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleFrames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//frame 1
		WebElement fr1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(fr1);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Test Jairo");
		driver.switchTo().defaultContent();
		
		//frame 2
		WebElement fr2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(fr2);
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Test Daniel");
		driver.switchTo().defaultContent();
		
		//frame 3
		WebElement fr3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(fr3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Test Bermudez");
		
		driver.switchTo().frame(0);
		
		driver.findElement(By.cssSelector("div.AB7Lab")).click();
		
		
		
		driver.switchTo().defaultContent();
		
		//frame 4
		WebElement fr4=driver.findElement(By.xpath("//frame[@src='frame_4.html']"));
		driver.switchTo().frame(fr4);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Test Luengas");
		driver.switchTo().defaultContent();
		
		//frame 5
		WebElement fr5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(fr5);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Test Luengas");
		driver.switchTo().defaultContent();
		
		
	
		
		
		
		
		
		
		
	}

}
