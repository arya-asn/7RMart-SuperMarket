package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.Login_Page;
import pages.SubCategorySearch_Page;

public class SubCategorySearchPage_Test extends LoginPage_Test {
	@Test
	public void verifyIsUserAbleToSearchSubCategory() throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();
		SubCategorySearch_Page subCategoryPage = new SubCategorySearch_Page(driver);
		subCategoryPage.selectSubCategory();
		subCategoryPage.selectSearch();
		String category = Excel_Utilities.getStringData(1, 0, "Search Sub Category");
		String subCategory = Excel_Utilities.getStringData(1, 1, "Search Sub Category");
		subCategoryPage.selectCategory(category);
		subCategoryPage.enterSubCategory(subCategory);
		subCategoryPage.searchResults();
		boolean isResultsDisplayed = subCategoryPage.isResultDisplayed();
		assertTrue(isResultsDisplayed, Constants.ERRORRESULTSNOTFOUND);

	}
}
