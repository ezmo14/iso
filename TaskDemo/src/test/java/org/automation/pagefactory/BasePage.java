package org.automation.pagefactory;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public JavascriptExecutor js;

	public WebDriverWait wait;
    
	/**
	 * Constructor for basepage 
	 * with wait and JavascriptExecutor
	 */
	 public BasePage(WebDriver driver){ 
		  wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	      js= (JavascriptExecutor)driver;
	    	
	        PageFactory.initElements(driver, this);

	}   
}
