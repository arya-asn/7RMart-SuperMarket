package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Page_Utility;

public class EditAdminUser_Page {
	WebDriver driver;


	public EditAdminUser_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement openAdminUserPage;
	@FindBy(xpath="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/user/edit?edit=9977&page_ad=1\"]")WebElement clickOnEditOption;
	@FindBy(xpath="//select[@id='user_type']")WebElement clickUserTypetoEdit;
	@FindBy(xpath="//button[@name='Update']")WebElement clickOnUpdate;	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
	
	
	public void adminUserPage() {
		openAdminUserPage.click();;
	}
	public void editOption() {
		clickOnEditOption.click();
	}
	public void editUserType(String userType) {
		Page_Utility pageUtility = new Page_Utility();
		pageUtility.selectionMethod(clickUserTypetoEdit,userType);
		
	}
	public void update() {
		clickOnUpdate.click();
	}
	public boolean isAlertMessageDisplayed() {
		return alertMessage.isDisplayed();
	}
}
