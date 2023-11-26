package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class paginationTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("input-username")).sendKeys("demo");
		driver.findElement(By.id("input-password")).sendKeys("demo");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement alert=driver.findElement(By.xpath("//button[@class='btn-close']"));
		
		if(alert.isDisplayed()) {
			alert.click();
		}
		
		driver.findElement(By.xpath("//a[@href='#collapse-5'][contains(.,'Customers')]")).click();
		driver.findElement(By.xpath("(//a[contains(.,'Customers')])[2]")).click();
		
		String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		System.out.println(text);
		String paginas=text.substring(26, 30);
		System.out.println(paginas);
		int total=Integer.parseInt(paginas);
		
		for(int i=1; i<=5;i++) {
			
			if(total>1) {
				WebElement pagina=driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+i+"]"));
				System.out.println("Pagina activa es: "+pagina.getText());
				pagina.click();
				Thread.sleep(2000);
			}
			int numRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			System.out.println("Total num of rows: "+numRows);
			System.out.println("--------------------------------------------------");
			
			for(int r=1; r<=numRows; r++) {
				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				String customerStatus=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
				System.out.println(customerName+"              "+customerStatus);
			}
			
		}
		

	}

}
