package com.tripadvisor.Filters;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tripadvisor.PageObjectFactory.tripAdvisorPOF;

public class setPriceSliders extends tripAdvisorPOF {
	
	public void setLowerPriceSlider(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,225)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement lslider = driver.findElement(leftSlider);
		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOf(lslider)); 
		wait2.until(ExpectedConditions.elementToBeClickable(lslider));
		Dimension ldim = lslider.getSize();
		int x = ldim.getWidth();
		Actions action = new Actions(driver);
		action.clickAndHold(lslider).moveByOffset(x-6,0).release().perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	public void setUpperPriceSlider(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(4000);
		Actions actions = new Actions(driver);
        WebElement rslider = driver.findElement(rightSlider);
    	WebDriverWait wait1 = new WebDriverWait(driver, 40);
		wait1.until(ExpectedConditions.visibilityOf(rslider)); 
		wait1.until(ExpectedConditions.elementToBeClickable(rslider));
    	actions.click(rslider).build().perform();
    	Thread.sleep(1000);
     	Dimension rdim = rslider.getSize();
    	int y = rdim.getWidth();
    	actions.dragAndDropBy(rslider, -162, 0).click().build().perform();
    	String s1 =driver.findElement(By.xpath("//div[@class='_1TEILUva']")).getText();
	}

}
