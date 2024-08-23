package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUpload_Utility;
import Utilities.Page_Utility;
import Utilities.Wait_Utility;

public class SubCategory_Page {
	WebDriver driver;
	
	public SubCategory_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	FileUpload_Utility fileUploadUtility = new FileUpload_Utility();
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement clickOnSubCategoryTile;
	@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement clickOnNewButton;
	@FindBy(xpath="//select[@id='cat_id']")WebElement clickOnSelectCategory;
	@FindBy(xpath="//input[@id='subcategory']")WebElement clickOnSubCategoryTextBox;
	@FindBy(xpath="//input[@id='main_img']")WebElement clickOnChooseFile;
	@FindBy(xpath="//button[@type='submit']")WebElement clickOnSaveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
	
	
	public void selectSubCategoryTile() {
		clickOnSubCategoryTile.click();
	}
	public void addNewSubCategory() {
		clickOnNewButton.click();
	}
	public void selectCategoryFromDropDown(String category) {
		Page_Utility pageUtility = new Page_Utility();
		pageUtility.selectionMethod(clickOnSelectCategory,category);
	}
	public void enterSubCategory(String subCategory) {
		clickOnSubCategoryTextBox.sendKeys(subCategory);
	}
	public void uploadImage(String filePath) {
		//clickOnChooseFile.sendKeys(filePath);
		fileUploadUtility.robotClass(clickOnChooseFile, filePath);
	}
	public void saveTheAddPage() {
		//Wait_Utility waitutility = new Wait_Utility();
		//waitutility.waitForElementClick(driver, clickOnSaveButton);
		clickOnSaveButton.click();
	}
	public boolean isAlertMessageDisplayed() {
		return alertMessage.isDisplayed();
	}

}
