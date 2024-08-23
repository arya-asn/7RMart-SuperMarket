package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchAdminUser_Page {
	
	WebDriver driver;


	public SearchAdminUser_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//input[@placeholder='Username']")WebElement userNameField;
	@FindBy(xpath="//input[@placeholder='Password']")WebElement passWordField;
	@FindBy(xpath="//button[@type='submit']")WebElement signInButton;
	@FindBy(xpath="//p[text()='Admin Users']")WebElement adminUserTile;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")WebElement openAdminUserPage;
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement clickOnSearchAdminUserButton;
	@FindBy(xpath="//input[@id='un']")WebElement userNameFieldOfAdminUser;
	@FindBy(xpath="//select[@id='ut']")WebElement userTypeDropDown;
	@FindBy(xpath="//button[@name='Search']")WebElement clickOnSearchButton;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")WebElement resultTable;

	
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
	public void clickSearchbutton() {
		clickOnSearchAdminUserButton.click();
	}
	public void enterUserNameToBeSearched(String userNameOfAdminUser) {
		 userNameFieldOfAdminUser.sendKeys(userNameOfAdminUser);
	}
	public void selectUserType(String userTypeofAdminUser) {
		Select adminUserType= new Select(userTypeDropDown);
		adminUserType.selectByVisibleText(userTypeofAdminUser);
		
	}
	public void searchadminUserButton() {
		clickOnSearchButton.click();
	}
	public boolean isResultDisplayed() {
		return resultTable.isDisplayed();
	}
	public boolean isUserNameInResults(String searchedUserName) {
		List<WebElement> rows = resultTable.findElements(By.tagName("tr"));
		for(WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(WebElement cell: cells) {
				if(cell.getText().equals(searchedUserName)) {
					return true;
				}
			}
		}
		return false;
	}
	
}

