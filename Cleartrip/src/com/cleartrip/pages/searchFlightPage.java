package com.cleartrip.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.base.BasePage;
import com.cleartrip.util.ReadXlsx;

public class searchFlightPage extends BasePage {
	static WebDriver driver;
	
	public By roundtrip= By.xpath("//*[@id='RoundTrip']");           // web locator for round trip option 
	public By source = By.xpath("(//*[@title='Any worldwide city or airport'])[1]"); // web locator for from/source input field
	public By dest = By.xpath("(//*[@title='Any worldwide city or airport'])[2]");   // web locator for to/destination input field
	public By deprtdt = By.xpath("//input[@title=\"Depart date\"]");				// web locator for departure date
	public By strdate = By.xpath("//div[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[4]/td[2]"); // web locator for a date from calendar 
	public By rtndate = By.xpath("//input[@title=\"Return date\"]");							// web locator for return date
	public By enddate = By.xpath("//div[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[4]/td[4]"); // web locator for a date from calendar
	public By adult = By.xpath("//*[@id='Adults']"); 											// web locator for adult drop down
	public By searchbtn = By.xpath("//*[@id='SearchBtn']");									// web locator for search button
	
	public searchFlightPage(WebDriver driver)       // Constructor
	{
		this.driver = driver;
	}
	
	public void select_roundtrip() {                // to click on the round trip option
		driver.findElement(roundtrip).click();
	}
	
	public void select_Source() {					// to enter source city 
		WebElement we = driver.findElement(source);
		try {
			we.sendKeys(ReadXlsx.input_source());     // to read the data from excel file
		} catch (IOException e) {
			e.printStackTrace();
		}
		we.sendKeys(Keys.ENTER);
	}
	
	public void select_Dest() {						// to enter destination city
		WebElement we = driver.findElement(dest);
		try {
			we.sendKeys(ReadXlsx.input_dest());		// to read data from the excel file
		} catch (IOException e) {
			e.printStackTrace();
		}
		we.sendKeys(Keys.ENTER);
	}
	
	public void deprtDate() {						// to select departure date
		driver.findElement(deprtdt).click();
		driver.findElement(strdate).click();
	}
	
	public void returnDate() {						// to select return date
		driver.findElement(rtndate).click();
		driver.findElement(enddate).click();
	}
	
	public void select_Adult() {						// to select no. of adults from the drop down
		Select sc = new Select(driver.findElement(adult));
		sc.selectByIndex(1);
	}
	
	public void clickOnSearch() {						// To click on Search button
		driver.findElement(searchbtn).click();
	}

}
