package testScript;

import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.AddNewAdminUser_Page;
import pages.Login_Page;
import pages.SearchAdminUser_Page;

public class SearchAdminUserPage_Test extends LoginPage_Test {

	@Test
	public void verifyUserIsAbleToSearchTheUserName() throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();

		SearchAdminUser_Page searchAdminUserPage = new SearchAdminUser_Page(driver);
		searchAdminUserPage.clickAdminUserTile();
		searchAdminUserPage.clickSearchbutton();

		String adminUsernameValue = Excel_Utilities.getStringData(1, 0, "Search Page");
		String adminUserType = Excel_Utilities.getStringData(1, 1, "Search Page");
		searchAdminUserPage.enterUserNameToBeSearched(adminUsernameValue);
		searchAdminUserPage.selectUserType(adminUserType);
		searchAdminUserPage.searchadminUserButton();

		boolean isResultDisplayed = searchAdminUserPage.isResultDisplayed();
		assertTrue(isResultDisplayed, Constants.ERRORRESULTSNOTFOUND);
		boolean isUserNameInResults = searchAdminUserPage.isUserNameInResults(adminUsernameValue);
		assertTrue(isUserNameInResults, Constants.ERRORUSERNOTFOUND);

	}
}
