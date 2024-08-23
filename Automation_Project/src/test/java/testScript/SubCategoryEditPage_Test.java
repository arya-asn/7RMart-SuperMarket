package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.Login_Page;
import pages.SubCategoryedit_Page;

public class SubCategoryEditPage_Test extends LoginPage_Test {
	@Test
	public void verifyIsUserIsAbleToEditSubCategory() throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();
		SubCategoryedit_Page subCategoryEditPage = new SubCategoryedit_Page(driver);
		subCategoryEditPage.selectSubCategoryIcon();
		subCategoryEditPage.editSubCategory();
		String category = Excel_Utilities.getStringData(1, 0, "Edit SubCategory Page");
		subCategoryEditPage.selectCategoryFromDropDown(category);
		subCategoryEditPage.selectUpdate();
		boolean isAlertDisplayed = subCategoryEditPage.isAlertMessageDisplayed();
		assertTrue(isAlertDisplayed, Constants.ERRORMESSAGEFORSUBCATEGORYEDITALERT);
	}
}
