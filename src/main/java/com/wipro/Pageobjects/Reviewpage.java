package com.wipro.Pageobjects;

import java.util.Iterator;
import java.util.Set;

import com.wipro.Resources.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Reviewpage extends BaseTest {

	public Reviewpage(WebDriver driver) {			
		this.driver=driver;
		}
	By Title1= By.xpath("//*[@class='bkHeaderMsg mobdn']");
	By review= By.xpath("//*[@class='fl mobdn ico18 padL10']");
	
	
	public WebElement Title1() {
		return driver.findElement(Title1);
	}
	public WebElement review() {
		return driver.findElement(review);
	}
	
public void switchDriver()
{
	String mainWindow=driver.getWindowHandle();
	// It returns no. of windows opened by WebDriver and will return Set of Strings
	Set<String> set =driver.getWindowHandles();
	// Using Iterator to iterate with in windows
	Iterator<String> itr= set.iterator();
	while(itr.hasNext())
	{
	String childWindow=itr.next();
	if(!mainWindow.equals(childWindow)){
		 
	driver.switchTo().window(childWindow);
	System.out.println(driver.switchTo().window(childWindow).getTitle());
	}
	}
	
}

}
