package org.automation.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){ 
    	super(driver);

    }   

	/*
	 * List of components used in the page
	 * PageFactory concept is followed
	 * 
	 * 
	 */
    
    @FindBy(id="email")
    WebElement emailField;
    
    @FindBy(id="pass")
    WebElement passwordField;
    
    @FindBy(css = "button[data-testid='royal_login_button']")
    WebElement loginBtn;
    
    @FindBy(id="error_box")
    WebElement errorBox;
    
    @FindBy(xpath="//a[@data-testid='open-registration-form-button']")
    WebElement createNewAccount;
    
    
   

 
   public void typeEmail(String email){
    		
	 emailField.sendKeys(email);
    
    }
   
   public void typePassword(String password){
		
		 passwordField.sendKeys(password);  
   }
   
   public void clickLogin() {
	   
	   loginBtn.click();
   }
 
   public void clickCreateNewAccount() {
	  
	  createNewAccount.click();
  }

 //check if the error box ois visible and afer that check on text.
public void checkIfErrorBoxContains(String expectedValue) {
	 try {
	 wait.until(ExpectedConditions.visibilityOf(errorBox));
	 }catch(Exception e) {
		 
	 }
	String elementValue = errorBox.getText();
	
	Assert.assertTrue(elementValue.contains(expectedValue), "Error: can not find "+expectedValue);
 }
 
}