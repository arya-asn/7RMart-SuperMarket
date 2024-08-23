package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUpload_Utility;
import Utilities.Page_Utility;

public class SubCategorySearch_Page {
WebDriver driver;
	
	public SubCategorySearch_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );
	}
	FileUpload_Utility fileUploadUtility = new FileUpload_Utility();
	Page_Utility pageUtility = new Page_Utility();
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-sub-category'][@class='small-box-footer']")WebElement clickOnSubCategoryTile;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement clickOnSearch;
	@FindBy(xpath="//select[@id='un']")WebElement clickOnCategoryDropdown;
	@FindBy(xpath="//input[@name='ut']")WebElement clickOnsubCategory;
	@FindBy(xpath="//button[@value='sr']")WebElement clickOnSearchForResults;
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']/table/thead/tr")WebElement resultsDisplayed;
	public void selectSubCategory() {
		clickOnSubCategoryTile.click();
	}
	public void selectSearch() {
		clickOnSearch.click();
	}
	public void selectCategory(String category) {
		pageUtility.selectionMethod(clickOnCategoryDropdown, category);
	}
	public void enterSubCategory(String subCategory) {
		fileUploadUtility.usingSendKeys(clickOnsubCategory, subCategory);
	}
	public void searchResults() {
		clickOnSearchForResults.click();
	}
	public boolean isResultDisplayed() {
		return resultsDisplayed.isDisplayed();
	}

}
