package testScript;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import Utilities.Excel_Utilities;
import pages.Login_Page;
import pages.ManagePagesInManageContent_Page;

public class ManagePagesInManageContent_Test extends LoginPage_Test {
	@Test
	public void verifyIsUserIsAbleToAddPage() throws IOException {
		Login_Page loginPage = new Login_Page(driver);
		String userNameValue = Excel_Utilities.getStringData(1, 0, "Login Page");
		String passWordValue = Excel_Utilities.getStringData(1, 1, "Login Page");
		loginPage.enterUserName(userNameValue);
		loginPage.enterPassWord(passWordValue);
		loginPage.clicksignIn();
		ManagePagesInManageContent_Page managePage = new ManagePagesInManageContent_Page(driver);
		managePage.selectManageContent();
		managePage.selectManagePages();
		managePage.createNewPage();

		String getTitleName = Excel_Utilities.getStringData(2, 0, "Add Page");
		String getDescription = Excel_Utilities.getStringData(2, 1, "Add Page");
		String getPageName = Excel_Utilities.getStringData(2, 2, "Add Page");
		String getFilePath = Excel_Utilities.getStringData(2, 3, "Add Page");

		managePage.enterTitleName(getTitleName);
		managePage.enterDescription(getDescription);
		managePage.enterPageName(getPageName);
		managePage.uploadImage(getFilePath);
		managePage.saveTheAddPage();
	}
}
