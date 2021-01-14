package com.course.Pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.course.base.TestBase;

public class SecondPage extends TestBase {
	
	@FindBy(xpath="//h1[@class='domain-name']")
	WebElement DomainName;
	@FindBy(xpath="//div[@class='filter-by-label']/following-sibling::button[1]")
	WebElement SkillBtn;
	@FindBy(xpath="//input[@class='filter-search-input']")
	WebElement SearchBar;
	@FindBy(xpath="//input[@value='Web Development']")
	static WebElement type;
	@FindBy(xpath="//div[@class='filter-by-label']/following-sibling::button[3]")
	WebElement LevelBtn;
	@FindBy(xpath="//input[@value='Beginner']")
	static
	WebElement Level;
	@FindBy(xpath="//input[@class='_htmk7zm' and @value='English']")
	static
	WebElement English;
	@FindBy(xpath="//div[@class='filter-by-label']/following-sibling::button[4]")
	WebElement Language;
	@FindBy(xpath="//button[@class='_1hx9z6hg']")
	WebElement Apply;
	@FindBy(xpath="//div[@class='_11890zw']/span")
	static
	WebElement noOfCourses;
	@FindBy(xpath="//div[@class='CheckList']/div/div/div")
	static
	WebElement checkList;
	@FindBy(xpath="/html/body/div[3]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/div/div[1]/h4")
	public WebElement CourseName1;
	@FindBy(xpath="/html/body/div[3]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/section/span[1]/div/span")
	public WebElement Rating1;
	@FindBy(xpath="/html/body/div[3]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[1]/div/div/div[2]/section/span[3]/span")
	public WebElement Hours1;
	@FindBy(xpath="/html/body/div[3]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/div/div[1]/h4")
	public WebElement CourseName2;
	@FindBy(xpath="/html/body/div[3]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/section/span[1]/div/span[1]")
	public WebElement Rating2;
	@FindBy(xpath="/html/body/div[3]/div/div/div[1]/section/div[3]/section/div[2]/div[1]/div[2]/div[1]/div/div/div[2]/div/div/div[2]/section/span[3]/span")
	public WebElement Hours2;
	public SecondPage()
	{
		PageFactory.initElements(driver, this);
	}
	public boolean validateDomainName()
	{
		String actual = DomainName.getText();
		String expected = "Computer Science";
		if(actual.equals(expected))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public boolean validateSkillFilter()
	{
		return SkillBtn.isDisplayed();
	}
	public void setSkillsFilter(String skill)
	 {
	  WebDriverWait wait1 = new WebDriverWait(driver,20);
	  wait1.until(ExpectedConditions.visibilityOf(SkillBtn));
	  SkillBtn.click(); //skill button locator
	  WebDriverWait wait2 = new WebDriverWait(driver,10);
	  wait2.until(ExpectedConditions.elementToBeClickable(SearchBar));
	  SearchBar.clear();   // Clear the searchbar
	  SearchBar.sendKeys(skill); // search bar inside skill filter locator
	  if(skill.equals("web development"))
	   {
		  JavascriptExecutor js =(JavascriptExecutor) driver;
		  // Web Development Course locator
		  js.executeScript("arguments[0].click();",type);
	   }
	}
	public boolean validateLevelFilter()
	{
		return LevelBtn.isDisplayed();
	}
	 // Set Level Filter
	 public void setLevelFilter()
	 {
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  // level button locator
	  LevelBtn.click();
	  Level.click(); // Beginner level locator
	 }
	 public boolean validateLanguageFilter()
	 {
		 return Language.isDisplayed();
	 }
	 // Set Language Filter
	 public void setLanguageFilter(String language)
	 {
	 Language.click(); // Language button Locator
	 WebDriverWait wait2 = new WebDriverWait(driver,10);
	 wait2.until(ExpectedConditions.elementToBeClickable(SearchBar));
	 SearchBar.clear();
	 SearchBar.sendKeys(language);
	   if(language.equals("English"))
	     {
		    JavascriptExecutor js =(JavascriptExecutor) driver;
		  // English Language Locator
		    js.executeScript("arguments[0].click();",English);  
	      }
	 }
	 public boolean validateApplyButton()
	 {
		 return Apply.isDisplayed();
	 }
	 // Apply Filters
	 public void applyFilters()
	 {
		WebDriverWait wait2 = new WebDriverWait(driver,10);
	    wait2.until(ExpectedConditions.visibilityOf(Apply));
	    Apply.click(); //Apply Button Locator
	 }
	 // Check skills Filter
	 public boolean checkSkillsFilter()
	 {
		 return (type.isSelected());
	 }
	// Check Level Filter
	 public boolean checkLevelFilter()
	 {
		 return (Level.isSelected());
	 }
	// Check Language Filter
	 public boolean checkLanguageFilter()
	 {
		 return (English.isSelected());
	 }
	// Check on search results
	 public boolean checkApply()
	 {
		 driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		 String courses = noOfCourses.getText();
		 String[] course = courses.split(" ");
		 int number = Integer.parseInt(course[0]);
		 if(number > 0)
		  {
			 return true;
		  }
		 else
		 	{
			 	return false;
			}
	 }
	 // Check on Invalid Skills filter
	 public boolean checkinputSkill()
	 {
		 String actual = checkList.getText();
		 String expected = "No such courses available";
		 if(actual.equals(expected))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 // Check on Invalid Language Filter
	 public  boolean checkinputLanguage()
	 {
		 String actual = checkList.getText();
		 String expected = "No such languages available";
		 if(actual.equals(expected))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	 // Check The navigation to second Page
	 public  boolean checkSecondPage()
		{
			 String actualTitle = driver.getTitle();
			 String secondTitle = "Computer Science Online Courses | Coursera";
			 if(actualTitle.contains(secondTitle))
			 {
				 return true;
			 }
			 else
			 {
				 return false;
			 }
		}



}
