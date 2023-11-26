package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	public WebDriver driver;
	
	LoginPage(WebDriver driver){
		
		this.driver=driver;
		
	}
	//locators
	By logo_img=By.xpath("//img[@alt='company-branding']");
	By usernameInput=By.name("username");
	By passwordInput=By.name("password");
	By loginBtn=By.xpath("//button[@type='submit']");
	
	
	//Action Methods
	
	public void setUsername(String username) {
		
		driver.findElement(usernameInput).sendKeys(username);
	}
	public void setPassword(String password) {
		
		driver.findElement(passwordInput).sendKeys(password);
	}
	public void ClickOnBtnLogin() {
		driver.findElement(loginBtn).click();
	}
	public boolean checkLogoPresence() {
		boolean status=driver.findElement(logo_img).isDisplayed();
		return status;
	}
	
	
	
	
	
}
