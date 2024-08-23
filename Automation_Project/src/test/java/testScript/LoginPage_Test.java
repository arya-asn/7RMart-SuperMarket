package testScript;




import static org.testng.Assert.assertEquals; 
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.Login_Page;


public class LoginPage_Test extends Base{
	
	@Test(retryAnalyzer = retry.Retry.class)
  //@Parameters({"Username","Password"})
  public void verifyUserNameAndPasswordUsingValidCredentials() throws IOException {
	  
	  //String userNameValue="admin";
	  //String passWordValue="admin";
	  String userNameValue=Excel_Utilities.getStringData(1, 0, "Login Page");
	  String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
	  Login_Page loginPage = new Login_Page(driver);
	  loginPage.enterUserName(userNameValue);
	  loginPage.enterPassWord(passWordValue);
	  loginPage.clicksignIn();
	  boolean isHomePageLoaded = loginPage.isDashboardLoaded();
	  assertTrue(isHomePageLoaded,Constants.ERRORMESSAGEFORLOGIN);
	  //String username,String password
	  
  }
  @Test(groups = {"smoke testing"})
  @Parameters({"invalidUser","invalidPass"})
  public void verifyUserNameAndPasswordUsingInValidCredentials(String username,String password) throws IOException {
	  
	 // String userNameValue="AAdmin";
	 // String passWordValue="12345";
	 // String userNameValue=Excel_Utilities.getStringData(2, 0, "Login Page");
	 // String passWordValue = Excel_Utilities.getStringData(2, 1, "Login Page");
	  Login_Page loginPage = new Login_Page(driver);
	  loginPage.enterUserName(username);
	  loginPage.enterPassWord(password);
	  loginPage.clicksignIn();
	  boolean isAlertDisplayed = loginPage.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,"Alert is not Displayed");
  }
  @Test
  public void verifyValidUserNameAndInvalidPassword() throws IOException {
	  //String userNameValue="admin";
	  //String passWordValue="12345";
	  String userNameValue=Excel_Utilities.getStringData(3, 0, "Login Page");
	  String passWordValue = Excel_Utilities.getStringData(3, 1, "Login Page");
	  Login_Page loginPage = new Login_Page(driver);
	  loginPage.enterUserName(userNameValue);
	  loginPage.enterPassWord(passWordValue);
	  loginPage.clicksignIn();
	  boolean isAlertDisplayed = loginPage.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,"Alert is not Displayed");
  }
  @Test
 // @Parameters({"Username","Password"})
  public void verifyInvalidUserNameAndValidPassword() throws IOException {
	  //String userNameValue="AAdmin";
	  //String passWordValue="admin";
	  String userNameValue=Excel_Utilities.getStringData(4, 0, "Login Page");
	  String passWordValue = Excel_Utilities.getStringData(4, 1, "Login Page");
	  Login_Page loginPage = new Login_Page(driver);
	  loginPage.enterUserName(userNameValue);
	  loginPage.enterPassWord(passWordValue);
	  loginPage.clicksignIn();
	  boolean isAlertDisplayed = loginPage.isAlertDisplayed();
	  assertTrue(isAlertDisplayed,"Alert is not Displayed");
  }
  
}
