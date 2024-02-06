package pageObjectsModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AddToCartTestCasePageObject {

	public WebDriver driver;

	By SearchStore = By.xpath("//input[@id='small-searchterms']");//input[@id='small-searchterms']
	By Search = By.xpath("//input[@value='Search']");
	By Product = By.xpath("//h2[@class='product-title']/a");
	By Price = By.xpath("//span[@class='price actual-price']");
	By AddToCart = By.xpath("//input[@value='Add to cart']");
	By Processor = By.xpath("(//input[@type='radio'])[1]");
	By BeforeAddToCart = By.xpath("//input[@id='add-to-cart-button-75']");
	
	By Content = By.xpath("//p[@class='content']");
	By Close = By.xpath("//span[@class='close']");
	By ShoppingCart = By.xpath("(//span[@class='cart-label'])[1]");
	By Productpriceordertotal = By.xpath("//span[@class='product-price order-total']/Strong");
	By SearchHeader = By.xpath("//div[@class='page-title']/h1");
	

	public AddToCartTestCasePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement enterInSearchStore() {

		return driver.findElement(SearchStore);
	}

	
	public WebElement clickOnSearch() {

		return driver.findElement(Search);
	}
	
	public List<WebElement> ChooseProduct() {

		return driver.findElements(Product);
	}
	

	public List<WebElement> readPrice() {

		return driver.findElements(Price);
	}

	public List<WebElement> clickonAddToCart() {

		return driver.findElements(AddToCart);
	}

	public WebElement clickProcessor() {

		return driver.findElement(Processor);
	}

	public WebElement clickBeforeAddToCart() {

		return driver.findElement(BeforeAddToCart);
	}

	public WebElement readContent() {

		return driver.findElement(Content);
	}

	public WebElement clickonClose() {

		return driver.findElement(Close);
	}

	public WebElement clickShippingCart() {

		return driver.findElement(ShoppingCart);
	}

	public WebElement readProductpriceordertotal() {

		return driver.findElement(Productpriceordertotal);
	}
	
	public WebElement readSearchHeader() {

		return driver.findElement(SearchHeader);
	}

}
