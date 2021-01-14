package com.tripadvisor.PageObjectFactory;

import org.openqa.selenium.By;

public class tripAdvisorPOF {
	
	public static final By Logo = By.xpath("//img[@class='_1AlVlFFs']");
	public static final By HotelBtn = By.xpath("//div[@class='_1ZteHrEy']//div[1]//a[1]");
	public static final By searchDestination = By.xpath("(//input[@class='_3qLQ-U8m' and @title='Search'])[2]");
	public static final By SearchBtn = By.xpath("//div[@class='i3bZ_gBa _2RTs3_Ee _3TPJs5_m']//button[@class='_3mLX8jwB _2a_Ua4Qv']");
	public static final By SearchField = By.xpath("//div[@class='i3bZ_gBa _2RTs3_Ee _3TPJs5_m _3awdcWrG']//input[@placeholder='Where to?']");
	public static final By city = By.xpath("//a[@title='Mumbai']");
	public static final By destination = By.xpath("//h1[@class='HLvj7Lh5 jObdbvmD']");    // Explore Mumbai text locator
	public static final By Hotels = By.cssSelector("#lithium-root > main > div._1brQmsfe > div > div > div:nth-child(1) > a");
	public static final By Hotelheader1 = By.xpath("//h1[@class='page_h1_line1']");
	public static final By Hotelheader2 = By.xpath("//span[@class='page_h1_line2']");
	public static final By checkInBtn = By.xpath("//button[@class='_1-dEgTFQ _3Z2f9tu1']//div[@class='_1fwLpEHv']");
	public static final By checkOutBtn = By.xpath("//button[2]//div[1]");
	public static final By GuestBtn = By.xpath("//div//div//div//div//div//div//div//div//div[2]//button[1]//div[1]");
	public static final By HotelRadioBtn = By.xpath("//div//div//div//div//div//div//div//div[5]//div[2]//div[1]//div[1]//label[1]");
	public static final By navigationPrev = By.xpath("//button[@class='ui_icon single-chevron-left _2PvL_zPQ _3QXSl3nP' and @data-testid='nav_prev']");
	public static final By monthName1= By.xpath("(//div[@class='_1JMy14it']/div)[1]");
	public static final By monthName2= By.xpath("(//div[@class='_1JMy14it']/div)[2]");
	public static final By dateGrid1 = By.xpath("(//div[@class='_3d8K7K3- notranslate'])[1]");
	public static final By dateGrid2 = By.xpath("(//div[@class='_3d8K7K3- notranslate'])[2]");
	public static final By checkin = By.xpath("(//span[@class='T7p4oWH8'])[1]");
	public static final By checkout = By.xpath("(//span[@class='T7p4oWH8'])[2]");
	public static final By update = By.xpath("//button[@class='ui_button primary fullwidth']");
	public static final By leftSlider = By.xpath("(//div[@class='_18B1YU3u _3Hwhseze'])[1]");
	public static final By rightSlider = By.xpath("//*[@id=\"component_10\"]/div/div[2]/div[3]/div[2]/div/div[1]/div[2]/div[3]");
	public static final By sliderValues = By.xpath("//div[@class='_1TEILUva']");
	public static final By searchResults = By.xpath("//span[@class='_3nOjB60a']");

}
