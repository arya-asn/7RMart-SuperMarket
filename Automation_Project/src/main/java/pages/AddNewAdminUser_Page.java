package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utilities.FileUpload_Utility;
import Utilities.Page_Utility;

public class AddNewAdminUser_Page {
	WebDriver driver;


	public AddNewAdminUser_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@placeholder='Username']")WebElement userNameField;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement passWordField;
	@FindBy(xpath="//button[@type='submit']")WebElement signInButton;
	@FindBy(xpath="//p[text()='Admin Users']")WebElement adminUserTile;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement openAdminUserPage;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement clickOnNewAdminUserButton;
	@FindBy(xpath="//input[@id='username']")WebElement userNameFieldOfAdminUser;
	@FindBy(xpath="//input[@id='password']")WebElement passwordFieldOfAdminUser;
	@FindBy(xpath="//select[@id='user_type']")WebElement userTypeField;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
	@FindBy(xpath="//button[@name='Create']")WebElement clickSaveUserButton;
	
	FileUpload_Utility fileUploadUtility=new FileUpload_Utility();

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}
	public void enterPassWord(String passWord) {
		passWordField.sendKeys(passWord);
	}
	public void clicksignIn() {
		signInButton.click();
	}
	public void clickAdminUserTile() {
		openAdminUserPage.click();
	}
	public void clickonNewButton() {
		clickOnNewAdminUserButton.click();
	}
	public void enterUserNameOfAdminUser(String userNameofAdminUser) {
		fileUploadUtility.usingSendKeys(userNameFieldOfAdminUser, userNameofAdminUser);
	}
	public void enterPasswordOfAdminUser(String passwordOfAdminUser) {
		fileUploadUtility.usingSendKeys(passwordFieldOfAdminUser, passwordOfAdminUser);
	}
	public void clickUserType(String userType) {
		Page_Utility pageUtility = new Page_Utility();
		pageUtility.selectionMethod(userTypeField,userType);
		
	}
	public void saveCreatedUser() {
		clickSaveUserButton.click();
		
	}
	public boolean isAlertDisplayed() {
		return alertMessage.isDisplayed();
	}
	
}
