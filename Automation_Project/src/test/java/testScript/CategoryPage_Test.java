package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.Category_Page;
import pages.Login_Page;

public class CategoryPage_Test extends LoginPage_Test {
	@Test
	public void verifyUserIsableToSaveCategoryNsme() throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();
		Category_Page categorypage = new Category_Page(driver);
		categorypage.clickCategoryInfo();
		categorypage.clickNewButton();
		String category = Excel_Utilities.getStringData(1, 0, "Category Page");
		String imageUpload = Excel_Utilities.getStringData(1, 1, "Category Page");
		categorypage.enterCategory(category);
		categorypage.itemToBeDragged();
		categorypage.uploadImage(imageUpload);
		categorypage.showOnTopMenu();
		categorypage.showOnLeftMenu();
		categorypage.saveButton();
		boolean isAlertMessageDisplayed = categorypage.isAlertDisplayed();
		assertTrue(isAlertMessageDisplayed, Constants.ERRORMESSAGEFORCATEGORYALERT);
	}
}
