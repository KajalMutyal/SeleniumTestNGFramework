package pageObjectsModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObjects {
	
	public WebDriver driver;
	
	
	private By Login = By.xpath("//a[@class='ico-login']");
	private By Email = By.xpath("//input[@id='Email']");
	private By Password = By.xpath("//input[@id='Password']");
	//private By RememberMe = By.xpath("//input[@id='RememberMe']");
	//private By ForgotPassword = By.xpath("//a[contains(text(),'Forgot password?')]");
	private By LogInButton = By.xpath("//input[@value='Log in']");
	private By Logout = By.xpath("//a[@href='/logout']");
	private By InvalidLoginTxt = By.xpath("//div[@class='validation-summary-errors']//span");
	
	public LoginPageObjects(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement clickOnLogin() {
		return driver.findElement(Login);
	}
	
	public WebElement enterEmail() {
		return driver.findElement(Email);
	}
	public WebElement enterPassword() {
		return driver.findElement(Password);
	}
	public WebElement clickonLoginButton() {
		return driver.findElement(LogInButton);
	}
	
	public WebElement readLogout() {
		return driver.findElement(Logout);
	}
	
	public WebElement readInvalidLoginTxt() {
		return driver.findElement(InvalidLoginTxt);
	}
	
	

}
