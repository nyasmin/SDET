package com.fanniemae.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fanniemae.base.TestBase;
import com.fanniemae.utilities.TestUtil;

public class SDETTestCase extends TestBase{
	
	  @Test(enabled=false)
	  public void openURL() throws InterruptedException {
		  
		// driver.get(config.getProperty("testsiteurl"));

	  }
	  @Test
	  public void loginPage() throws InterruptedException, IOException {
		 
		String loginHomeButton = "id_LOGIN_BUTTON_HOME";
		String loginButton = "xpath_LOGIN_BUTTON";
		String username = "id_LOGIN_USERNAME";
		String password = "id_LOGIN_PASSWORD";
		
		Assert.assertTrue(isElementPresent(By.id(OR.getProperty("id_LOGIN_BUTTON_HOME"))));
		click(loginHomeButton);
		TestUtil.captureScreenshot();
		type(username,"sdet@sdettraining.com");
		type(password,"Password");
		click(loginButton);
		TestUtil.captureScreenshot();
		Thread.sleep(3000);
		
	  }
}
