package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.EditAdminUser_Page;
import pages.Login_Page;

public class EditAdminUser_Test extends LoginPage_Test {
	@Test
	@Parameters({"EditUserType"})
	public void verifyUserIsableToEditUserType(String edituserType) throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();
		EditAdminUser_Page editAdminUserPage = new EditAdminUser_Page(driver);
		editAdminUserPage.adminUserPage();
		editAdminUserPage.editOption();
		//String userType = Excel_Utilities.getStringData(1, 0, "Edit UserType");
		editAdminUserPage.editUserType(edituserType);
		editAdminUserPage.update();
		boolean isAlertDisplayed = editAdminUserPage.isAlertMessageDisplayed();
		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFOREDITUSERTYPEALERT);
	}
}
