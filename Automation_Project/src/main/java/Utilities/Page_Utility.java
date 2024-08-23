package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Page_Utility {
	WebDriver driver;
	
	//Reusable code
	public void selectionMethod(WebElement element,String elementText) {
		Select clickUserType = new Select(element);
		clickUserType.selectByVisibleText(elementText);
	}
	public void selectionMethodsByIndex(WebElement element,int elementText) {
		Select selectuser=new Select(element);
		selectuser.selectByIndex(elementText);;
		}
	public void selectionMethodsByValue(WebElement element,String elementText) {
		Select selectuser=new Select(element);
		selectuser.selectByValue(elementText);
	}
	public void dragAndDropMethod(WebElement element1,WebElement element2) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element1,element2).perform();
		}
	public void javaScriptExecutorMethod(WebElement element,String elementValue) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		js.executeScript("arguments[0].click();",elementValue);
		element.click();
	}
	
	

}
