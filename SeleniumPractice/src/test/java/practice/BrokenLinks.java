package practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("Total links: "+links.size());
		int brokenLinks=0;
		
		for(WebElement link:links) {
			
			String hrefAttValue=link.getAttribute("href");			
			if(hrefAttValue==null || hrefAttValue.isEmpty()) {
				System.out.println("href attribute is empty");
				continue;
			}
			//Checking link is broken or not
			URL linkUrl=new URL(hrefAttValue);
			
		HttpURLConnection conn=(HttpURLConnection)linkUrl.openConnection();
		conn.connect();
		if(conn.getResponseCode()>=400) {
			System.out.println(hrefAttValue+"    "+" ===> Broken Link.. ");
			brokenLinks++;
			
		}
		else 
		{
			System.out.println(hrefAttValue+"    "+" ===> Not Broken Link.. ");
		}
		
		}
		System.out.println("Total number of link: "+brokenLinks);

	}

}
