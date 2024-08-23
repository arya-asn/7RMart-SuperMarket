package testScript;

import org.testng.annotations.Test;

import constants.Constants;
import Utilities.ScreenShot_Utility;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;




public class Base {
  WebDriver driver;
  public Properties properties;
  public FileInputStream fis;
  
  @BeforeMethod(alwaysRun=true)
  @Parameters("browser")
  public void initializeBrowser(String browser) throws Exception {
	  
	 // driver = new EdgeDriver();
	  try {
			properties = new Properties();
			fis = new FileInputStream(Constants.CONFIGFILE);
			properties.load(fis);

		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
	  
	  
	  if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("invalid browser");
		}
	  driver.get(properties.getProperty("url"));
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  }

  @AfterMethod()
  
  public void afterMethod(ITestResult itResult) throws IOException {
	  if (itResult.getStatus() == ITestResult.FAILURE) {
		  ScreenShot_Utility sc = new ScreenShot_Utility();
			sc.captureFailureScreenShot(driver, itResult.getName());
		}
	 // driver.close();
  }

}
