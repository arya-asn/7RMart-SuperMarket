package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.Login_Page;
import pages.ManageProductSearch_Page;

public class ManageProductPage_Test extends LoginPage_Test {
	@Test
	public void verifyIsUserIsAbleToSearchInManageProduct() throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();
		ManageProductSearch_Page manageProductSearchPage = new ManageProductSearch_Page(driver);
		manageProductSearchPage.manageProduct();
		manageProductSearchPage.searchButton();
		String titleName = Excel_Utilities.getStringData(1, 0, "ManageProduct Search");
		String productCode = Excel_Utilities.getIntData(1, 1, "ManageProduct Search");
		String category = Excel_Utilities.getStringData(1, 2, "ManageProduct Search");
		String subCategory = Excel_Utilities.getStringData(1, 3, "ManageProduct Search");
		manageProductSearchPage.enterTitleName(titleName);
		manageProductSearchPage.enterProductCode(productCode);
		manageProductSearchPage.selectCategoryDropDown(category);
		manageProductSearchPage.selectSubCategory(subCategory);
		boolean isListBoxDisplayed = manageProductSearchPage.isListDisplayed();
		assertTrue(isListBoxDisplayed, Constants.ERRORRESULTSNOTFOUND);

	}
}
