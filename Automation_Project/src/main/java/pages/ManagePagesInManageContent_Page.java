package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUpload_Utility;
import Utilities.Wait_Utility;

public class ManagePagesInManageContent_Page {
	
	WebDriver driver;


public ManagePagesInManageContent_Page(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	
}

@FindBy(xpath="//a[@data-widget='pushmenu']")WebElement navigationBar;
@FindBy(xpath="//i[@class='fas fa-angle-left right']")WebElement clickOnManageContent;
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']")WebElement clickOnManagePages;
@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement clickOnNewButton;
@FindBy(xpath="//input[@id='title']")WebElement clickOnTitle;
@FindBy(xpath="//div[@role='textbox']")WebElement clickOnDescription;
@FindBy(xpath="//input[@id='page']")WebElement clickOnPageName;
@FindBy(xpath="//input[@id='main_img']")WebElement clickOnChooseFile;
@FindBy(xpath="//button[@class='btn btn-danger']")WebElement clickOnSaveButton;
FileUpload_Utility fileUploadUtility=new FileUpload_Utility();
public void selectManageContent() {
	clickOnManageContent.click();
}
public void selectManagePages() {
	clickOnManagePages.click();
}
public void createNewPage() {
	clickOnNewButton.click();
}
public void enterTitleName(String titleName) {
	fileUploadUtility.usingSendKeys(clickOnTitle, titleName);
}
public void enterDescription(String description) {
	fileUploadUtility.usingSendKeys(clickOnDescription, description);
}
public void enterPageName(String pageName) {
	fileUploadUtility.usingSendKeys(clickOnPageName, pageName);
}
public void uploadImage(String filePath) {
	fileUploadUtility.usingSendKeys(clickOnChooseFile, filePath);
}
public void saveTheAddPage() {
	Wait_Utility waitutility = new Wait_Utility();
	waitutility.waitForElementClick(driver, clickOnSaveButton);
	clickOnSaveButton.click();
}

}
