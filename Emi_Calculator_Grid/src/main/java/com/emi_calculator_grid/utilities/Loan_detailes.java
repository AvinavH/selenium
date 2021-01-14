package com.emi_calculator_grid.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Loan_detailes extends Page_factory {
	
	static WebDriver driver;

	public Loan_detailes(WebDriver driver) {
		this.driver=driver;
		driver_init(driver);
		
	}
	
	
	public void select_carloan() {
		
		
		Car_loan.click();
	}
	
	public void select_homeloan() {
		
		
		Home_loan.click();
	}

	public void select_personalloan() {
	
	
	Personal_loan.click();
}
	
	
	public void send_amount(String amount) {
		//WebElement Amnt=driver.findElement(By.id("loanamount"));
		Amnt.sendKeys(Keys.CONTROL,"a");
		Amnt.sendKeys(Keys.DELETE);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Amnt.sendKeys(amount);
		WebDriverWait wait = new WebDriverWait(driver,30);
	}
	
	public void send_interest(String interest) {
		//WebElement Intrst=driver.findElement(By.id("loaninterest"));
		Intrst.sendKeys(Keys.CONTROL,"a");
		Intrst.sendKeys(Keys.DELETE);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Intrst.sendKeys(interest);
		WebDriverWait wait = new WebDriverWait(driver,30);
	}
	
	public void send_tennure(String tennure ) {
		//WebElement Tennure=driver.findElement(By.id("loanterm"));
		Tennure.sendKeys(Keys.CONTROL,"a");
		Tennure.sendKeys(Keys.DELETE);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		Tennure.sendKeys(tennure);
		//driver.findElement(By.xpath("//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div/div/label[1]")).click();
		cla.click();
		WebDriverWait wait = new WebDriverWait(driver,30);
	}
	
	public void scroll() {
		//WebElement scrollElement=driver.findElement(By.xpath("//td[@id='year2020']"));
		//Actions actions = new Actions(driver);
		//actions.moveToElement(scrollElement);
		//actions.perform();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollElement);
	}
	
	public void expand_list() {
		//WebElement listElement=driver.findElement(By.xpath("//td[@id='year2020']"));
		listElement.click();
		
		
	}
	
	
	public String select_interest() {
		//WebElement interestOfFirstMonth=driver.findElement(By.xpath("//*[@id='monthyear2020']/td/div/table/tbody/tr[1]/td[3]"));
		String interest=interestOfFirstMonth.getText();
		return interest;
	}
	
	public String select_Principle() {
		//WebElement principleOfFirstMonth=driver.findElement(By.xpath("//*[@id='monthyear2020']/td/div/table/tbody/tr[1]/td[2]"));
		String principle1=principle.getText();
		return principle1;
	}
	
	public boolean carloan_isSelected() {
		
	return	CarLoan_Lebel.isDisplayed();
		
	}
	
	

}
