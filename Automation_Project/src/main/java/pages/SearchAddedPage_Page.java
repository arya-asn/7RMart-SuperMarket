package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchAddedPage_Page {
	WebDriver driver;
	
	public SearchAddedPage_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='click_button(2)']")WebElement clickOnSearchButton;
	@FindBy(xpath="//input[@placeholder='Title']")WebElement titleToBeSearched;
	@FindBy(xpath="//button[@name='Search']")WebElement ClickOnSearchButtonToGetTheResult;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")WebElement resultTable;
	
	
	
	public void clickOnSearchButton() {
		clickOnSearchButton.click();
	}
	public void enterTitle(String title) {
		titleToBeSearched.sendKeys(title);
	}
	public void clickSearchButtonForSearch() {
		ClickOnSearchButtonToGetTheResult.click();
	}
	public boolean isResultTableDisplayed() {
		return resultTable.isDisplayed();
		
	}
	public boolean isTitleNameInResults(String searchedTitleName) {
		List<WebElement> rows = resultTable.findElements(By.tagName("tr"));
		for(WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.tagName("td"));
			for(WebElement cell: cells) {
				if(cell.getText().equals(searchedTitleName)) {
					return true;
				}
			}
		}
		return false;
	}

}
