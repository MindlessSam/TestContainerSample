package com.wipro.Pageobjects;

import com.wipro.Resources.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends BaseTest {
		
		public Homepage(WebDriver driver) {
			this.driver=driver;
			}
		
		By title= By.xpath("//h1[text()='Domestic and International Flights']");		
		By Oneway = By.id("oneway");
		By Roundtrip = By.id("roundTrip");	
		By frominput =By.id("gosuggest_inputSrc");
		By destination =By.id("gosuggest_inputDest");
		By departure =By.id("departureCalendar");
		By returncalendar =By.id("returnCalendar");
		By traveller =By.id("pax_link_common");
		By search =By.id("gi_search_btn");
		By navigation =By.xpath("//*[@class='DayPicker-NavButton DayPicker-NavButton--next']");
		By futuredate =By.id("fare_20200815");
		By enddate =By.id("fare_20200829");
		By classselection =By.id("gi_class");
		By dropSrcDownExpanded = By.xpath("//input[@id='gosuggest_inputSrc' and @aria-expanded='true']");
	By dropDestDownExpanded = By.xpath("//input[@id='gosuggest_inputDest' and @aria-expanded='true']");
		
		
		public WebElement getTitle() {
			return driver.findElement(title);
		}
		public boolean isSrcDropDownPresent(){
			return driver.findElement(dropSrcDownExpanded).isDisplayed();
		}
	public boolean isDestDropDownPresent(){
		return driver.findElement(dropDestDownExpanded).isDisplayed();
	}
			public WebElement Oneway() {
				return driver.findElement(Oneway);
			}
			public WebElement frominput() {
			return driver.findElement(frominput);
			}
			public WebElement destination() {
				return driver.findElement(destination);
			}
			public WebElement departure() {
				return driver.findElement(departure);
			}
			public WebElement returncalendar() {
				return driver.findElement(returncalendar);
			}
			public WebElement traveller() {
				return driver.findElement(traveller);
			}
			public WebElement search() {
				return driver.findElement(search);
			}
			public WebElement navigation() {
				return driver.findElement(navigation);
			}
			public WebElement futuredate() {
				return driver.findElement(futuredate);
			}
			public WebElement enddate() {
				return driver.findElement(enddate);
			}
			public WebElement classselection() {
				return driver.findElement(classselection);
			}
		}
		
		

	



