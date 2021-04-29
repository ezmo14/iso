package org.automation.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class SignupPage extends BasePage{

	 public SignupPage(WebDriver driver){ 
	    	super(driver);

	    }
	 
	 /*
		 * List of components used in the page
		 * PageFactory concept is followed
		 * 
		 * 
		 */
	 
	  @FindBy(name="firstname")
	  WebElement firstNameField;
	
	  @FindBy(name="lastname")
	  WebElement lastNameField;
	  
	  @FindBy(name="reg_email__")
	  WebElement mobileEmailField;
	  
	  @FindBy(name="reg_email_confirmation__")
	  WebElement emailFieldConfirmation;
	  
	  @FindBy(id="password_step_input")
	  WebElement password;
	  
	  @FindBy(id="day")
	  WebElement birthDay;
	 
	  @FindBy(id="month")
	  WebElement birthMonth;
	  
	  @FindBy(id="year")
	  WebElement birthYear;
	  
	  @FindBy(xpath="//label[text()='Male']")
	  WebElement maleRadioLabel;
	  
	  @FindBy(xpath="//label[text()='Female']")
	  WebElement femaleRadioLabel;
	  
	  @FindBy(xpath="//label[text()='Custom']")
	  WebElement customRadioLabel;
	  
	  
	  @FindBy(name="websubmit")
	  WebElement signUpButton;
	  
	  @FindBy(id="reg_error_inner")
	  WebElement errorMessage;
	
	  @FindBy(xpath="//div[contains(@id,'js')]")
	  WebElement fieldErrorNotifcationMessage;
	 
	   public void typeFirstName(String name){		
		   firstNameField.sendKeys(name);
	    }
	   
	   public void typePassword(String name){
	   		
		   password.sendKeys(name);
	    
	    }
	   public void typeLastName(String name){
   		
		   lastNameField.sendKeys(name);
	    
	    }
	   
	   public void typeMobileEmail(String email){
	   		
		   mobileEmailField.sendKeys(email);
	    
	    }
	   
	  
	   public void typeEmailConfirmation(String email){
			emailFieldConfirmation.sendKeys(email);
	    }
	  
	   //click on gender radio based on recieved gender
	   public void clickGenderButton(String gender){
	   		
		   if(gender.toLowerCase().equals("male"))
			   maleRadioLabel.click();
		   else if(gender.toLowerCase().equals("female"))
			   femaleRadioLabel.click();
		   else if(gender.toLowerCase().equals("custom"))
			   customRadioLabel.click();
		   
	    }

	   public void clickSignUpButton(){
	   		
		   signUpButton.click();
	    
	    }
	   
	   //split date by - to get date
	   //the month is selected by index
	   //which can be 1 to 12
	   public void selectDate(String value){
		   //if value is empty do nothing
	   		if(!value.equals("")) 
	   		{
				String[] dateValues=value.split("-");
			   	Select birthDaySelect = new Select(birthDay);
			   	Select birthMonthSelect = new Select(birthMonth);
			   	Select birthYearSelect = new Select(birthYear);  
			   	birthDaySelect.selectByValue(dateValues[0]);
			   	birthMonthSelect.selectByIndex(Integer.parseInt(dateValues[1]));
			   	birthYearSelect.selectByValue(dateValues[2]);
	   		}
	   	}
	  
	   //verify on error message box
	   public void checkIfErrorMessageContains(String expectedValue) {
		  
		   try {
		   wait.until(ExpectedConditions.visibilityOf(errorMessage));
		   
		   }catch(Exception e) {
			
		   }
		   
		   String elementValue = errorMessage.getText();
		   Assert.assertTrue(elementValue.contains(expectedValue), "Error: can not find "+expectedValue);
		  
	   
	   }
	
	 //verify on error notification for fields
	   public void checkIfFieldErrorNotifcationExist(String expectedValue) {
		 
		   try {
			   wait.until(ExpectedConditions.visibilityOf(fieldErrorNotifcationMessage));
	
		   }catch(Exception e) {
				
		   }
		   
		   String elementValue = fieldErrorNotifcationMessage.getText();
		   	Assert.assertTrue(elementValue.contains(expectedValue), "Error: can not find "+expectedValue);
	   }
	   
	 
	  
}
