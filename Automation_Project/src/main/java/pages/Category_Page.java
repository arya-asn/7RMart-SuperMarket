package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUpload_Utility;

public class Category_Page {
	
	WebDriver driver;
	
	public Category_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category'][@class='small-box-footer']")WebElement clickOnCategoryTile;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement clickOnNewButton;
	@FindBy(xpath="//input[@id='category']")WebElement clickOnCategoryTextBox;
	@FindBy(xpath="//li[@id='134-selectable']")WebElement clickOnItemToBeDragged;
	@FindBy(xpath="//input[@id='main_img']")WebElement clickOnChooseFile;
	@FindBy(xpath="//input[@value='yes']")WebElement clickShowOnTopMenu;
	@FindBy(xpath="//input[@value='yes']")WebElement clickShowOnLeftMenu;
	@FindBy(xpath="//button[@name='create']")WebElement clickOnSaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
	FileUpload_Utility fileUploadUtility=new FileUpload_Utility();
	public void clickCategoryInfo() {
		clickOnCategoryTile.click();
	}
	public void clickNewButton() {
		clickOnNewButton.click();
	}
	public void enterCategory(String category) {
		fileUploadUtility.usingSendKeys(clickOnCategoryTextBox, category);
		
	}
	public void itemToBeDragged() {
		clickOnItemToBeDragged.click();
	}
	public void uploadImage(String filePath) {
		clickOnChooseFile.sendKeys(filePath);
		
	}
	public void showOnTopMenu() {
		clickShowOnTopMenu.isSelected();
	}
	public void showOnLeftMenu() {
		clickShowOnLeftMenu.isSelected();
	}
	public void saveButton() {
		clickOnSaveButton.click();
	}
	public boolean isAlertDisplayed() {
		return alertMessage.isDisplayed();
	}
	
}
