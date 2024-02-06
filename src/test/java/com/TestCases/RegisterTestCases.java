package com.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Resources.BaseClass;
import com.Resources.CommonMethods;
import com.Resources.Constants;

import pageObjectsModel.RegisterPageObjects;

public class RegisterTestCases extends BaseClass {

	@Test
	public void verifyValidRegistration() throws IOException {

		RegisterPageObjects rpo = new RegisterPageObjects(driver);

		rpo.clickOnRegister().click();
		rpo.clickOnGender().click();
		rpo.enterFirstName().sendKeys(Constants.FirstName);
		rpo.enterLastName().sendKeys(Constants.LastName);
		rpo.enterEmail().sendKeys(email);
		rpo.enterPassword().sendKeys(Constants.Password);
		rpo.enterConfirmPassword().sendKeys(Constants.ConfirmPassword);
		rpo.clickOnRegisterButton().click();

		CommonMethods.handleAssertion(rpo.readConfirmationMessage().getText(), Constants.RegisterValidExpectedResult);

	}

	@Test
	public void verifyInvalidRegistration() throws IOException {

		RegisterPageObjects rpo = new RegisterPageObjects(driver);

		rpo.clickOnRegister().click();
		rpo.clickOnGender().click();
		rpo.enterFirstName().sendKeys(Constants.FirstName);
		rpo.enterLastName().sendKeys(Constants.LastName);
		rpo.enterEmail().sendKeys(email);
		rpo.enterPassword().sendKeys(Constants.InvalidConfirmPassword);
		rpo.enterConfirmPassword().sendKeys(Constants.ConfirmPassword);
		rpo.clickOnRegisterButton().click();

		CommonMethods.handleAssertion(rpo.readInvalidErrorMessage().getText(), Constants.RegisterInvalidExpectedResult);

	}

}
