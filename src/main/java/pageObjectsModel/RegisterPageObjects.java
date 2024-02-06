package pageObjectsModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPageObjects {

	public WebDriver driver;

	private By Register = By.xpath("//a[@class='ico-register']");
	private By Gender = By.xpath("//input[@value='F']");
	private By FirstName = By.xpath("//input[@id='FirstName']");
	private By LastName = By.xpath("//input[@id='LastName']");
	private By Email = By.xpath("//input[@id='Email']");
	private By Password = By.xpath("//input[@id='Password']");
	private By ConfirmPassword = By.xpath("//input[@id='ConfirmPassword']");
	private By RegisterButton = By.xpath("//input[@id='register-button']");
	
	private By ComfirmationMessage=By.xpath("//div[@class='result']");
	private By InvalidErrorMessage=By.xpath("//span[@for='ConfirmPassword']");

	public RegisterPageObjects(WebDriver driver) {

		this.driver = driver;
	}

	public WebElement clickOnRegister() {

		return driver.findElement(Register);
	}

	public WebElement clickOnGender() {

		return driver.findElement(Gender);
	}

	public WebElement enterFirstName() {

		return driver.findElement(FirstName);
	}

	public WebElement enterLastName() {

		return driver.findElement(LastName);
	}

	public WebElement enterEmail() {

		return driver.findElement(Email);
	}

	public WebElement enterPassword() {

		return driver.findElement(Password);
	}

	public WebElement enterConfirmPassword() {

		return driver.findElement(ConfirmPassword);
	}

	public WebElement clickOnRegisterButton() {

		return driver.findElement(RegisterButton);
	}
	
	public WebElement readConfirmationMessage() {

		return driver.findElement(ComfirmationMessage);
	}

	public WebElement readInvalidErrorMessage() {

		return driver.findElement(InvalidErrorMessage);
	}

}
