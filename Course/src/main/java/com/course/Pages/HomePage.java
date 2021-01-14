package com.course.Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.course.base.TestBase;

public class HomePage extends TestBase {
	@FindBy(xpath="//img[@class='rc-CourseraLogo _1j095b7']")
	static WebElement logo;
	
	@FindBy(xpath="//button[@class='rc-ExploreButton']")
	static WebElement ExploreBtn;
	
	@FindBy(xpath="//input[@class='react-autosuggest__input']")
	static WebElement searchField;
	
	@FindBy(xpath="//button[@class='nostyle search-button']//div[@class='magnifier-wrapper']")
	static WebElement searchButton;
	
	By dropdown = By.xpath("//div[@class='mega-menu-overlay']/nav/div/div[2]/ul/li/div/button/span");

	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public SecondPage navigateToSecondPage()

	 {

	  WebDriverWait wait = new WebDriverWait(driver,40);

	  wait.until(ExpectedConditions.visibilityOf(ExploreBtn));

	  ExploreBtn.click(); // "Explore" button Locator
	
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
	  List<WebElement> list = driver.findElements(dropdown); // boot-strap drop down locator

	  for(int i=0;i<list.size();i++)

	   {

	      if(list.get(i).getText().contains("Computer Science"))

	        {

	          list.get(i).click();

	           break;

	        }

	     }
	  
	 return new SecondPage();

	  }
	
	public boolean checkHomePage()
	{
		 String Actual = driver.getTitle();
		 String expected = "Coursera | Build Skills with Online Courses from Top Institutions";
		 if(Actual.equals(expected))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public boolean checkExploreButton()
	{
		
		boolean flag = ExploreBtn.isDisplayed();
		return flag;
	}
	public boolean checkSearchField()
	{
		boolean flag = searchField.isDisplayed();
//		searchField.sendKeys(Keys.CONTROL+"a");
//		searchField.sendKeys(Keys.BACK_SPACE);
		return flag;
	}
	public boolean checkSearchButton()
	{
		return searchButton.isDisplayed();
	}



}
