package com.fanniemae.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;

public class SauceLabs {
	
	@Test
	public void tc_SdetTraining_HomePage() throws MalformedURLException
	{
		
		DesiredCapabilities dc= DesiredCapabilities.firefox();
		dc.setCapability("version", "6");
		dc.setCapability("platform", "XP");

	    WebDriver driver = new RemoteWebDriver(
	                new URL("http://sdettrainer:9e22268c-4475-462c-b44f-6c167341c144@ondemand.saucelabs.com:80/wd/hub"),
	                dc);

	driver.get("http://sdettraining.com");
	System.out.println(driver.getTitle());

	
		
	}   
	
	
	@DataProvider
	public Object[][] testdata_shoppingCart(){
		return new Object[][]{
				new Object[]{"IPhone", "2", "Adam", "MIAMI BEACH", "FL"},
				new Object[]{"TV", "3", "Brett", "MANHATTAN", "NY"},
				new Object[]{"Canon", "4", "Christene", "ALPHARETTA", "GA"},
				new Object[]{"Camera", "5", "David","BOSTON", "MA"}
		};
	}
	
	
	@Test(dataProvider="testdata_shoppingCart")
	public void tc_shoppingCartTesting(String item2Search, String qty, String customerName, String customerCity, String customerState) throws InterruptedException, MalformedURLException{
		String TestCaseName = "tc_shoppingCartTesting";
		String AUT_URL = "http://sdettraining.com/online";
		String runTestInBrowser="FF";
		//WebDriver driver;
		
		DOMConfigurator.configure("log4j.xml");
		//Log.startTestCase(TestCaseName);
		
		//driver = ReUsableFunctions.OpenBrowser(runTestInBrowser, AUT_URL);
		
		//DesiredCapabilities dc= DesiredCapabilities.firefox();
		//DesiredCapabilities dc= DesiredCapabilities.chrome();
		DesiredCapabilities dc= DesiredCapabilities.internetExplorer();
		dc.setCapability("version", "11");
		dc.setCapability("platform", "Windows 10");

	      
	    WebDriver driver = new RemoteWebDriver(
                new URL("http://sdetagile:685f4c82-bc66-47d1-a62e-ccba880c71d6@ondemand.saucelabs.com:80/wd/hub"), dc);

	    driver.get(AUT_URL);
	    System.out.println(driver.getTitle());
			
		//Log.info("Opening Browser: " + runTestInBrowser);
		/*
		System.setProperty("webdriver.firefox.marionette", "C:\\SeleniumJAVATraining\\Softwares\\GeckoDriver\\64bit\\geckodriver.exe");
	    WebDriver driver = new FirefoxDriver();
	    driver.get("http://sdettraining.com/online");
		Thread.sleep(3000);
		*/
		
		
		driver.findElement(By.name("txtSearch")).clear();
	    driver.findElement(By.name("txtSearch")).sendKeys(item2Search);
	   // Log.info("Searching for Item: " + item2Search);
	    driver.findElement(By.id("Go")).click();
	    driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[2]/td[3]/a/img")).click();
	    driver.findElement(By.name("txtItemQty1")).clear();
	    driver.findElement(By.name("txtItemQty1")).sendKeys(qty);
	   // Log.info("Qty added to cart: " + qty);
	    
	    driver.findElement(By.id("Recalc")).click();
	    driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
	    
	    driver.findElement(By.name("txtCustomerName")).clear();
	    driver.findElement(By.name("txtCustomerName")).sendKeys(customerName);
	    //Log.info("customerName: " + customerName);
	    
	    driver.findElement(By.name("txtAddress")).clear();
	    driver.findElement(By.name("txtAddress")).sendKeys("123 Main Street");
	    driver.findElement(By.name("txtCity")).clear();
	    driver.findElement(By.name("txtCity")).sendKeys(customerCity);
	   // Log.info("customerCity: " + customerCity);
	    
	    driver.findElement(By.name("txtState")).clear();
	    driver.findElement(By.name("txtState")).sendKeys(customerState);
	    //Log.info("customerState: " + customerState);
	    
	    driver.findElement(By.name("txtZIP")).clear();
	    driver.findElement(By.name("txtZIP")).sendKeys("20121");
	    driver.findElement(By.name("txtPhone")).clear();
	    driver.findElement(By.name("txtPhone")).sendKeys("7035551414");
	    driver.findElement(By.name("optPaymentType")).click();
	    driver.findElement(By.name("txtAcctNo")).clear();
	    driver.findElement(By.name("txtAcctNo")).sendKeys("412365896541");
	    driver.findElement(By.name("txtCVV2No")).clear();
	    driver.findElement(By.name("txtCVV2No")).sendKeys("123");
	    driver.findElement(By.name("txtExpDate")).clear();
	    driver.findElement(By.name("txtExpDate")).sendKeys("02/2019");
	    driver.findElement(By.name("txtshipCustomerName")).clear();
	    driver.findElement(By.name("txtshipCustomerName")).sendKeys("Trump");
	    driver.findElement(By.name("txtshipAddress")).clear();
	    driver.findElement(By.name("txtshipAddress")).sendKeys("6 Pennsylvania Ave");
	    driver.findElement(By.name("txtshipCity")).clear();
	    driver.findElement(By.name("txtshipCity")).sendKeys("Washington");
	    driver.findElement(By.name("txtshipState")).clear();
	    driver.findElement(By.name("txtshipState")).sendKeys("DC");
	    driver.findElement(By.name("txtshipZIP")).clear();
	    driver.findElement(By.name("txtshipZIP")).sendKeys("20888");
	    driver.findElement(By.name("txtshipPhone")).clear();
	    driver.findElement(By.name("txtshipPhone")).sendKeys("2021114455");
	    driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
	    String orderConfirmation =  driver.findElement(By.cssSelector("h2")).getText();
	    //Log.info("orderConfirmation: " + orderConfirmation);
	 
		 System.out.println("Order Confirmation Message: " + orderConfirmation);
		 
		 driver.quit();
		 //Log.endTestCase(TestCaseName);
	}
		

}
