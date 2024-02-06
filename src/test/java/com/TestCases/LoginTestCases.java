package com.TestCases;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Resources.BaseClass;
import com.Resources.CommonMethods;
import com.Resources.Constants;

import pageObjectsModel.LoginPageObjects;

public class LoginTestCases extends BaseClass {

	@Test(dependsOnMethods = "verifyValidRegistration()")

	public void ValidLogin() throws IOException {

		LoginPageObjects lpo = new LoginPageObjects(driver);

		lpo.clickOnLogin().click();
		lpo.enterEmail().sendKeys(email);
		lpo.enterPassword().sendKeys(Constants.LoginPassword);
		lpo.clickonLoginButton().click();

		CommonMethods.handleAssertion(lpo.readLogout().getText(), Constants.LoginValidExpectedResult);
	}

	@Test

	public void InvalidLogin() throws IOException {

		LoginPageObjects lpo = new LoginPageObjects(driver);

		lpo.clickOnLogin().click();
		lpo.enterEmail().sendKeys(email);
		lpo.enterPassword().sendKeys(Constants.LoginInvalidPassword);
		lpo.clickonLoginButton().click();

		CommonMethods.handleAssertion(lpo.readInvalidLoginTxt().getText(), Constants.LoginInvalidExpectedResult);
	}

}
