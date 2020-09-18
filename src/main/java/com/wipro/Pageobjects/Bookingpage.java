package com.wipro.Pageobjects;

import com.wipro.Resources.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Bookingpage extends BaseTest {

	public Bookingpage(WebDriver driver) {			
		this.driver=driver;
		}	
	
	By Title= By.xpath("//*[@src=' https://gos3.ibcdn.com/gosafesrp-1590147458.png']");
	By sortup= By.xpath("(//*[@class='ico13 icon-arrow2-up hpyBlueLt '])[1]");	
	By sortdown= By.xpath("(//*[@class='ico13 icon-arrow2-down hpyBlueLt '])[1]");
	By tripselection= By.xpath("//label[@for='DELMAA20200731BAI:AI553radioBtn']");
	By book= By.xpath("//*[@value='BOOK']");
	
	
	public WebElement Title() {
		return driver.findElement(Title);
	}
	public WebElement sortup() {
		return driver.findElement(sortup);
	}	
		public WebElement sortdown() {
			return driver.findElement(sortdown);
		}
		public WebElement tripselection() {
			return driver.findElement(tripselection);
		}
		public WebElement book() {
			return driver.findElement(book);
		}

}
