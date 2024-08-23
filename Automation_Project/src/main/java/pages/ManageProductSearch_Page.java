package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.FileUpload_Utility;
import Utilities.Page_Utility;

public class ManageProductSearch_Page {
WebDriver driver;
	
	public ManageProductSearch_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	Page_Utility pageUtility =new Page_Utility();
	FileUpload_Utility fileUploadUtility = new FileUpload_Utility();
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product'][@class='small-box-footer']")WebElement clickOnManageProductTile;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement clickOnSearchButton;
	@FindBy(xpath="//input[@name='un']")WebElement clickOnTitleName;
	@FindBy(xpath="//input[@name='cd']")WebElement clickOnProductCode;
	@FindBy(xpath="//select[@id='cat_id']")WebElement clickOnCategoryDropDown;
	@FindBy(xpath="//select[@id='sb']")WebElement clickOnSubCategoryDropDown;
	@FindBy(xpath="//button[@name='Search']")WebElement searchButton;
	@FindBy(xpath="//h4[text()='List Products']']")WebElement listProducts;
	
	public void manageProduct() {
		clickOnManageProductTile.click();
	}
	public void searchButton() {
		clickOnSearchButton.click();
	}
	public void enterTitleName(String titlename) {
		fileUploadUtility.usingSendKeys(clickOnTitleName, titlename);
	}
	public void enterProductCode(String productCode) {
		fileUploadUtility.usingSendKeys(clickOnProductCode, productCode);
	}
	public void selectCategoryDropDown(String category) {
		pageUtility.selectionMethodsByValue(clickOnCategoryDropDown, category);
	}
	public void selectSubCategory(String subCategory) {
		pageUtility.selectionMethod(clickOnSubCategoryDropDown, subCategory);
	}
	public void searchButtonToSearch() {
		searchButton.click();
	}
	public boolean isListDisplayed() {
		return listProducts.isDisplayed();
	}
}
