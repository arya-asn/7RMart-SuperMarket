package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.AddNewAdminUser_Page;
import pages.Login_Page;

public class AddNewAdminUser_Test extends LoginPage_Test {

	@Test(description="verify user is able to add new User in the Admin Page")
	
	public void verifyUserIsAbleToAddNewUser_Test() throws IOException {

		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();

		AddNewAdminUser_Page addNewAdminUserPage = new AddNewAdminUser_Page(driver);
		addNewAdminUserPage.clickAdminUserTile();
		addNewAdminUserPage.clickonNewButton();

		String adminUsernameValue = Excel_Utilities.getStringData(1, 0, "New Admin User");
		String adminPasswordValue = Excel_Utilities.getStringData(1, 1, "New Admin User");
		String userType = Excel_Utilities.getStringData(1, 2, "New Admin User");
		addNewAdminUserPage.enterUserNameOfAdminUser(adminUsernameValue);
		addNewAdminUserPage.enterPasswordOfAdminUser(adminPasswordValue);
		addNewAdminUserPage.clickUserType(userType);
		addNewAdminUserPage.saveCreatedUser();
		boolean isAlertMessageDisplayed = addNewAdminUserPage.isAlertDisplayed();
		assertTrue(isAlertMessageDisplayed, Constants.ERRORMESSAGEFORADMINUSERALERT);
	}
}
