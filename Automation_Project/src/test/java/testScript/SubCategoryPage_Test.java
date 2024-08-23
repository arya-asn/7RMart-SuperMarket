package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.Login_Page;
import pages.SubCategory_Page;

public class SubCategoryPage_Test extends LoginPage_Test {
	@Test
	public void verifyUserIsAbleToSaveTheSubCategoryData() throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();
		SubCategory_Page subCategorypage = new SubCategory_Page(driver);
		subCategorypage.selectSubCategoryTile();
		subCategorypage.addNewSubCategory();
		String getCategoryName = Excel_Utilities.getStringData(1, 0, "SubCategory Page");
		String getSubCategoryName = Excel_Utilities.getStringData(1, 1, "SubCategory Page");
		String getImagePath = Excel_Utilities.getStringData(1, 2, "SubCategory Page");
		subCategorypage.selectCategoryFromDropDown(getCategoryName);
		subCategorypage.enterSubCategory(getSubCategoryName);
		subCategorypage.uploadImage(getImagePath);
		subCategorypage.saveTheAddPage();
		boolean isAlertMessageDisplayed = subCategorypage.isAlertMessageDisplayed();
		assertTrue(isAlertMessageDisplayed, Constants.ERRORMESSAGEFORSUBCATEGORYALERT);
	}
}
