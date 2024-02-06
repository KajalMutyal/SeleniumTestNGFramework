package com.Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;

	public static String email = generateRandomEmailID();

	public void initializeBrowser() throws IOException {

		// Read the file
		// FileInputStream fis=new
		// FileInputStream("C:\\Users\\admin\\eclipse-workspace\\TestNGSeleniumFrameworks\\src\\main\\java\\com\\Resources\\data.properties");
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\Resources\\data.properties");

		// acccess the content inside the properties file

		prop = new Properties();

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {

			driver = new EdgeDriver();
		} else {

			System.out.println("Please choose valid browser");
		}
	}

	// To take the screenshot and store in one folder-
	public static String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		// 202312120744

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShot\\" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			e.getMessage();
		}
		return destination;
	}

	@BeforeSuite
	public void ExtentReport() {
		extentManager.setup();
	}

	@AfterSuite
	public void endReport() {
		extentManager.endReport();
	}

	public static String generateRandomEmailID() {
		return "abc" + System.currentTimeMillis() + "@gmail.com";

	}

	@BeforeMethod
	public void launchBrowser() throws IOException {

		initializeBrowser();

		driver.manage().window().maximize();

		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void quitBrowser() {
		driver.quit();
	}

}
