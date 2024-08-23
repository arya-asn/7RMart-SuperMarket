package testScript;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import constants.Constants;
import pages.Login_Page;
import pages.ManagePagesInManageContent_Page;
import pages.SearchAddedPage_Page;

public class SearchAddedPage_Test extends LoginPage_Test {
	@Test
	public void verifySearchingTitleIsInTheResultTable() throws IOException {

		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();

		ManagePagesInManageContent_Page managePage = new ManagePagesInManageContent_Page(driver);
		managePage.selectManageContent();
		managePage.selectManagePages();

		SearchAddedPage_Page searchAddedPage = new SearchAddedPage_Page(driver);
		searchAddedPage.clickOnSearchButton();
		String getTitleToBeSearched = Excel_Utilities.getStringData(1, 0, "Search Page of Add Page");
		searchAddedPage.enterTitle(getTitleToBeSearched);
		searchAddedPage.clickSearchButtonForSearch();
		boolean isResultDisplayed = searchAddedPage.isResultTableDisplayed();
		assertTrue(isResultDisplayed, Constants.ERRORRESULTSNOTFOUND);
		boolean isSearchedTitleDisplayed = searchAddedPage.isTitleNameInResults(getTitleToBeSearched);
		assertTrue(isSearchedTitleDisplayed, Constants.ERRORTITLENOTFOUND);

	}
}
