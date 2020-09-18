package com.wipro.witaas.Goibibo;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.Allure;

import com.wipro.Pageobjects.Bookingpage;
import com.wipro.Pageobjects.Homepage;
import com.wipro.Pageobjects.Reviewpage;
import com.wipro.Resources.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Goibibo_workflow extends BaseTest {
	private String startplace;
	private String Destinationplace;
	private String date;
	private String[] datesplit;

	Reviewpage rp = new Reviewpage(driver);
	Homepage hp = new Homepage(driver);
	Bookingpage bp = new Bookingpage(driver);

	@Before
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		log.info("Driver is initialized");
		Allure.description("");
	}

	@Given("End user is in the home page of Goibibo")
	public void end_user_is_in_the_home_page_of_goibibo()  {
		driver.get("https://www.Goibibo.com");
		hp.Oneway().click();
		hp.frominput().sendKeys("Chennai");
		if(hp.isSrcDropDownPresent()){
			hp.frominput().sendKeys(Keys.ARROW_DOWN);
			hp.frominput().sendKeys(Keys.ENTER);
		}else{
			hp.frominput().click();
			hp.frominput().sendKeys(Keys.ARROW_DOWN);
			hp.frominput().sendKeys(Keys.ENTER);
		}


		hp.destination().sendKeys("Delhi");
		if(hp.isDestDropDownPresent()){
			hp.destination().sendKeys(Keys.ARROW_DOWN);
			hp.destination().sendKeys(Keys.ENTER);
		}else{
			hp.destination().click();
			hp.destination().sendKeys(Keys.ARROW_DOWN);
			hp.destination().sendKeys(Keys.ENTER);
		}
		hp.departure().click();
		hp.navigation().click();
		hp.futuredate().click();


		hp.traveller().click();
		Select name2 = new Select(hp.classselection());
		name2.selectByValue("B");

		startplace = hp.frominput().getAttribute("value");
		startplace = startplace.substring(0, 7);
		Destinationplace = hp.destination().getAttribute("value");
		Destinationplace = Destinationplace.substring(0, 5);
		date = hp.departure().getAttribute("value");
		datesplit = date.split(",");

		hp.search().click();
		
		System.out.println("Homepage Validated successfully");
		log.info("Homepage validation successful.");

	}

	@When("End user fill all the data")
	public void  end_user_fill_all_the_data()  {
		Assert.assertTrue(bp.Title().isDisplayed());
		if(!bp.sortup().isDisplayed()) {
			bp.sortup().click();
		}

				bp.book().click();

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,100)");
				
				System.out.println("Bookingpage Validated successfully");
				log.info("Reviewpage validation successful.");
	}

	@Then("End user should fill all the details")
	public void end_user_should_fill_all_the_details() {
		rp.switchDriver();

		Assert.assertTrue(rp.Title1().isDisplayed());
		
		String Total = rp.review().getText();


		Assert.assertTrue(Total.contains(startplace));
		Assert.assertTrue(Total.contains(Destinationplace));

		for (int i = 0; i < datesplit.length; i++) {
			Assert.assertTrue(Total.contains(datesplit[i]));
		}
		
		System.out.println("Reviewpage Validated successfully");
		log.info("Reviewpage validation successful.");
	}

	@After
	public void teardown() {

		driver.close();
		driver.quit();

	}


}
