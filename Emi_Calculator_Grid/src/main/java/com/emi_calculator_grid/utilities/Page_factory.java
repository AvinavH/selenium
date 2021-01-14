package com.emi_calculator_grid.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page_factory {
	WebDriver driver;
	@FindBy(xpath="//li[@id='car-loan']/a")
	WebElement Car_loan; 
	
	@FindBy(xpath="//li[@id='home-loan']/a")
	WebElement Home_loan; 
	
	@FindBy(xpath="//li[@id='personal-loan']/a")
	WebElement Personal_loan; 
	
	@FindBy(id="loanamount")
	WebElement Amnt;
	
	@FindBy(id="loaninterest")
	WebElement Intrst;
	
	@FindBy(id="loanterm")
	WebElement Tennure;
	
	@FindBy(xpath="//td[@id='year2020']")
	WebElement scrollElement;
	
	@FindBy(xpath="//td[@id='year2020']")
	WebElement listElement;
	
	@FindBy(xpath="//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div/div/label[1]")
	WebElement cla;
	
	@FindBy(xpath="//*[@id='monthyear2020']/td/div/table/tbody/tr[1]/td[3]")
	WebElement interestOfFirstMonth;
	
	@FindBy(xpath="//*[@id='monthyear2020']/td/div/table/tbody/tr[1]/td[2]")
	WebElement principle;
	
	@FindBy(xpath="//div[@id='emicalculatorinnerform']/div[1]/label")
	WebElement CarLoan_Lebel;
	
	public void driver_init(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
	

}
