package org.automation.testrunner;

import java.io.IOException;
import java.time.Duration;

import org.automation.helpers.Helpers;
import org.automation.pagefactory.HomePage;
import org.automation.pagefactory.LoginPage;
import org.automation.pagefactory.SignupPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




public class Runner {

	private WebDriver driver;

	private HomePage homePage;
	private LoginPage loginPage;
	private SignupPage signupPage;
	public static String baseURL = "https://www.facebook.com";
	/**
	 * Setup the driver and load the driver file
	 
	 * Initialize page factory classes
	 */
	@BeforeTest
	public void setup(){

		System.setProperty("webdriver.chrome.driver", "src/chromedriver.exe");
	
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		homePage=new HomePage(driver);
		loginPage=new LoginPage(driver);
		signupPage=new SignupPage(driver);
		
	}
	
	@DataProvider (name = "UserLogin")
	public Object [][] getLoginData ()
	{	Object[][] data=null;
		try {
			data = Helpers.readExcel("data.xls", "login");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	
	}
	
	
	
	
	
	@DataProvider (name = "UserRegistration")
	public Object [][] getRegData (){
		
		Object[][] data=null;
		try {
			data = Helpers.readExcel("data.xls", "signup");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
		
		
	}
	
	@Test (dataProvider = "UserLogin") 
	public void userLogsIn(String testCase[]) {
		   
		driver.manage().deleteAllCookies();
		driver.navigate().to(baseURL);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		loginPage.typeEmail(testCase[1]);
		loginPage.typePassword(testCase[2]);
		loginPage.clickLogin();
		if(testCase[3].equals("") || testCase[3].equals("valid")){
			
			homePage.clickOnAccountTab();
			
			homePage.clickOnLogout();
			
		
		}else{
		
			loginPage.checkIfErrorBoxContains(testCase[3]);
		
		}
	}

	
		

	@Test (dataProvider = "UserRegistration") 
	public void userRegistration(String testCase[]) {
      
		driver.manage().deleteAllCookies();
		driver.navigate().to(baseURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		String generatedEmail = "";
		 
		loginPage.clickCreateNewAccount();
		signupPage.typeFirstName(testCase[1]);
		signupPage.typeLastName(testCase[2]);
		if(testCase[3].equals("randomstring"))
		{	generatedEmail=Helpers.randomAlpha(15)+"@gmail.com";
			signupPage.typeMobileEmail(generatedEmail);
		
		}
		
		if(testCase[4].equals("same"))
		{	signupPage.typeEmailConfirmation(generatedEmail);
		}else if(testCase[4].equals("randomstring")){
			signupPage.typeEmailConfirmation(Helpers.randomAlpha(15)+"@gmail.com");
		}
	
		signupPage.typePassword(testCase[5]);
		signupPage.selectDate(testCase[6]);
		signupPage.clickGenderButton(testCase[7]);
		signupPage.clickSignUpButton();
	
		if(!testCase[8].equals(""))
		{	signupPage.checkIfFieldErrorNotifcationExist(testCase[8]);
		}	
		
	
		if(!testCase[9].equals(""))
		{	
			signupPage.checkIfErrorMessageContains(testCase[9]);
		}
		
		
	}
	
	@AfterTest
	public void tearDown() throws Exception{

	driver.quit();

	}
	
	
}
