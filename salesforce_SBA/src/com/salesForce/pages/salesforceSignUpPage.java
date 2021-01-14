package com.salesForce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class salesforceSignUpPage extends BasePage {
	static WebDriver driver=null;
	WebDriverWait wait=null;

	public By signUpBtn=By.xpath("//a[@class='btn btn-success']"); //weblocator for signup button
	
	public By email = By.xpath("//input[@id='email']"); //weblocator for email field
	
	public By error = By.xpath("(//div[@class='errorContainer'])[1]"); //weblocator for error message
	
	public By country=By.xpath("//select[@id='country']"); //weblocator for country dropdown
	
	public By logInBtn=By.xpath("//a[contains(text(),'Log In')]"); //weblocator for login button
	
	public By rememberMe=By.xpath("//input[@name='rememberUn']"); //weblocator for remember me checkbox
	
	public salesforceSignUpPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void clickonSignInBtn() throws InterruptedException
	{
		driver.findElement(signUpBtn).click();
				
		Thread.sleep(3000);
	}
	
	public void enterEmailaddress(String emailadd) throws InterruptedException 
	{
		Thread.sleep(7000);
		wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(email)));
		driver.findElement(email).sendKeys(emailadd);
		driver.findElement(email).sendKeys(Keys.TAB);
		
	}
	
	public void getErrormsg() throws InterruptedException
	{
		Thread.sleep(3000);
		String msg = driver.findElement(error).getText();
		System.out.println("Error message is: "+msg);
	}
	
	public void clickonLoginBtn()
	{
		wait=new WebDriverWait(driver,40);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(logInBtn)));
		driver.findElement(logInBtn).click();
	}
	
	public void selectRememberMe()
	{
		driver.findElement(rememberMe).click();
	}
	
	public void selectCountry(String place)
	{
		Select select = new Select(driver.findElement(country));
		select.selectByVisibleText(place);
		
	}
	
	
	

}