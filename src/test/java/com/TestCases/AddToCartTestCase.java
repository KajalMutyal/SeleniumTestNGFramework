package com.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Resources.BaseClass;
import com.Resources.CommonMethods;
import com.Resources.Constants;

import pageObjectsModel.AddToCartTestCasePageObject;

public class AddToCartTestCase extends BaseClass {

	@Test
	public void verifyAmountOfProdInCart() throws IOException, InterruptedException {

		AddToCartTestCasePageObject act = new AddToCartTestCasePageObject(driver);

		act.enterInSearchStore().sendKeys(Constants.SearchStore);
		act.clickOnSearch().click();

		List<WebElement> product = act.ChooseProduct();
		List<WebElement> price = act.readPrice();
		List<WebElement> addtocart = act.clickonAddToCart();
		
		CommonMethods.handleExplicitWait(driver, 2, act.readSearchHeader());

		String pricebeforecart = "";

		for (int i = 0; i < product.size(); i++) {

			if (product.get(i).getText().equalsIgnoreCase("Simple Computer")) {

				pricebeforecart = price.get(i).getText();
				addtocart.get(i).click();
				break;
			}

		}

		CommonMethods.handleExplicitWait(driver, 2, act.clickProcessor());

		act.clickProcessor().click();

		act.clickBeforeAddToCart().click();
		// System.out.println(act.readContent().getText());
		// act.clickonClose().click();
		act.clickShippingCart().click();

		String expected = "800.00";
		//String actual = act.readProductpriceordertotal().getText();

		CommonMethods.handleAssertion(pricebeforecart, expected);

	}

}
