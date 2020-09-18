//package com.wipro.witaas.Goibibo;
//import static org.junit.Assert.assertTrue;
//
//import java.io.IOException;
//
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//import com.wipro.Pageobjects.Bookingpage;
//
//import com.wipro.Resources.Base;
//
//public class Goibibo_Bookingtest extends Base{
//	
//	@BeforeTest
//	public void initialize() throws IOException {
//		
//		driver = initializeDriver();
//		
//		driver.get(prop.getProperty("url"));
//		log.info("Driver is initialized");
//	}
//	
//	@Test
//	public void Bookingpage() throws IOException{
//		
//		Bookingpage bp=new Bookingpage(driver);
//		bp.sortup().click();
//		
//		bp.tripselection().click();
//		
//		bp.book().click();
//		/*Need to scrooll down ask abt this to Glad***********/
//		
////		JavascriptExecutor js = (JavascriptExecutor) driver;
////		js.executeScript("window.scrollBy(0,100)");
//		
//		/*Need to compare ask Glad*/
//		
//	}
//	
//
//}
