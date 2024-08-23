package pages;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUpload_Utility;

public class Login_Page {
	WebDriver driver;


public Login_Page(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}


@FindBy(xpath="//input[@placeholder='Username']")WebElement userNameField;
@FindBy(xpath="//input[@placeholder='Password']")WebElement passWordField;
@FindBy(xpath="//button[@type='submit']")WebElement signInButton;
@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement alertMessage;
FileUpload_Utility fileUploadUtility=new FileUpload_Utility();
public void enterUserName(String userName) {
	fileUploadUtility.usingSendKeys(userNameField, userName);
}
public void enterPassWord(String passWord) {
	fileUploadUtility.usingSendKeys(passWordField, passWord);
}
public void clicksignIn() {
	signInButton.click();
}
public boolean isDashboardLoaded() {
	return dashboard.isDisplayed();
}
public boolean isAlertDisplayed() {
	return alertMessage.isDisplayed();
}
}
