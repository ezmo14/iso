package org.automation.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	/*
	 * List of components used in the page
	 * PageFactory concept is followed
	 * 
	 * 
	 */
	
	@FindBy(xpath= "//div[@aria-label='Account']")
    WebElement accountTab;
    
    @FindBy(xpath="//span[text()='Log Out']")
    WebElement logoutBtn;
    
    
    //click on account tab on top using JavascriptExecutor
    public void clickOnAccountTab() {
    	js.executeScript("arguments[0].click()", accountTab);
    }
    
  //click on logout button
    
    public void clickOnLogout() {
    	
    	 try {
    	    wait.until(ExpectedConditions.visibilityOf(logoutBtn));
    	   }catch(Exception e) {}
    	    	 
		js.executeScript("arguments[0].click()", logoutBtn);
    }

}