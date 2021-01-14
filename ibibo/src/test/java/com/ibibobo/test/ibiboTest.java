package com.ibibobo.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ibiboTest {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\avina\\chromedriver\\chromedriver_v84.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//*[@class='icon-hotels db blue ico28 lh1-2 padT2 padB3'])")).click();
		driver.findElement(By.xpath("(//*[@class='SearchBlockUIstyles__RadioButton-fity7j-7 cbhcaf'])[1]")).click();
		WebElement abc = driver.findElement(By.xpath("(//*[@class='HomePageAutosuggeststyles__SearchInputStyles-sc-1v6s32j-1 hAhUHZ'])"));
		abc.click();
		abc.sendKeys("Mumbai");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("(//span[@class='HomePageAutosuggeststyles__SearchListItemLocationName-sc-1v6s32j-5 dqxIKI'])[1]")).click();
		driver.findElement(By.xpath("//button[@data-testid='searchHotelBtn']")).click();
		
		Thread.sleep(3000);
		
		
		WebElement checkIn = driver.findElement(By.xpath("//input[@id='search-widget-checkin-input']"));
		JavascriptExecutor js = (JavascriptExecutor) driver ;
		js.executeScript("arguments[0].setAttribute('value','Jul 28, 2020')", checkIn);
		driver.findElement(By.xpath("(//*[@class='CheckBoxUncheckedIcon-sc-13ilmpa-0 fsJRQJ'])[5]")).click();
		
		Actions action1 = new Actions(driver);
		Actions action2 = new Actions(driver);
		//List<WebElement> list = new ArrayList<WebElement>();
		int a=0;
		for(int i=0;i<4000;i++)
		{
		 action1.sendKeys(Keys.ARROW_DOWN).perform(); 
		 a += driver.findElements(By.xpath("//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-6 dmXrA']")).size();
		}
		//a += driver.findElements(By.xpath("//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-6 dmXrA']")).size();
//		for(int i =0;i<list.size();i++)
//		{
//			System.out.println(list.get(i).toString());
//		}
		int b =0;
		for(int i =0 ;i<4000 ;i++)
		{
			 action1.sendKeys(Keys.ARROW_UP).perform(); 
			 b += driver.findElements(By.xpath("//h4[@class='dwebCommonstyles__SmallSectionHeader-sc-112ty3f-6 dmXrA']")).size();
		}
		System.out.println(a);
		System.out.println(b);

	}

}
