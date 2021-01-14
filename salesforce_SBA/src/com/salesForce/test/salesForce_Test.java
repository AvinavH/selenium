package com.salesForce.test;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.salesForce.pages.BasePage;
import com.salesForce.pages.salesforceSignUpPage;
import com.salesForce.util.Read_xlsx;
import com.salesForce.util.Screenshots;

public class salesForce_Test{
	static WebDriver driver;
	
	
	@BeforeTest
	@Parameters({"Browser" ,"url"}) //for passing the parameters from testng.xml file
	public void setup(String Browser, String url) {
		driver=BasePage.launchUrl(Browser, url); //launching the url
		
	}
	
	
	@Test
	public void checkSignup() throws InterruptedException, IOException {
		salesforceSignUpPage obj = new salesforceSignUpPage(driver);
		
		obj.clickonSignInBtn(); //clicking on sign-in button of the initial page
		
		Row r= Read_xlsx.input_file(); 
		String Emailid= Read_xlsx.input_emailid(r); //reading the email address from the excel file
		obj.enterEmailaddress(Emailid); //entering the email address in the email field
		
		obj.getErrormsg(); //verification of the error message for entering the wrong email
		
		String plc = Read_xlsx.input_Country(r); //reading the country name from the excel file
		obj.selectCountry(plc); //selecting the country from the dropdown
		
		obj.clickonLoginBtn(); //clicking on the login button
		
		obj.selectRememberMe(); //selecting the 'remember me' check box in the login page 
		
		Screenshots.Screenshot(driver); //taking the screenshot of the login page
		
		
	}
	
	@AfterTest
	public void teardown() {
		BasePage.closeBrowser(); //closing the browser
	}
	
	

}
