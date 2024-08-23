package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Page_Utility;

public class SubCategoryedit_Page {
WebDriver driver;
	
	public SubCategoryedit_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement clickOnSubCategoryTile;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/Subcategory/edit?edit=462&page_ad=1']")WebElement clickEdit;
	@FindBy(xpath="//select[@id=cat_id]")WebElement selectCategoryDropdown;
	@FindBy(xpath="//button[@name='update']")WebElement clickUpdate;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertMessage;
	
	public void selectSubCategoryIcon() {
		clickOnSubCategoryTile.click();
	}
	public void editSubCategory() {
		clickEdit.click();
	}
	public void selectCategoryFromDropDown(String category) {
		Page_Utility pageUtility = new Page_Utility();
		pageUtility.selectionMethod(selectCategoryDropdown,category);
	}
	public void selectUpdate() {
		clickUpdate.click();
	}
	public boolean isAlertMessageDisplayed() {
		return alertMessage.isDisplayed();
	}
	}
	


