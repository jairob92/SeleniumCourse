package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class staticTable {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		//find total number of rows
		
		int rows=driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		
		//System.out.println("Number of rows: "+rows);
		//int rows2=driver.findElements(By.tagName("tr")).size();
		//System.out.println("Number of rows: "+rows2);
		
		//find total of columns title
		
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("Number of rows: "+columns);
		
		//read an specific row and column data 
		
		String dataTable=driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]//td[2]")).getText();
		//System.out.println("Author is :"+dataTable);
		
		//read data from all rows and columns
		
		/*for(int i=2; i<=rows; i++) {
			
			for(int j=1; j<=columns; j++) {
				 
				String values= driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
				System.out.print(values+"\t");
			}
			System.out.println();
		}*/
		
		//Print book names where author is "Amit"
		
		/*for(int i=2; i<=rows; i++) {
			
			String author=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[2]")).getText();
			
			//System.out.println("Author is: "+author);
			
			if(author.equals("Amit")) {
				
				String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[1]")).getText();	
				System.out.println("Author: "+author+" Books by Amit: "+bookName);
			}
		}*/
		
		//Find sum of prices for all the books
		
		int sum =0;

		for(int i=2; i<=rows; i++) {
			
			String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td[4]")).getText();
			
			int value = Integer.parseInt(price);
			sum=sum+value;
			
		}
		System.out.println("Total Price: "+sum);
		
	}

}
