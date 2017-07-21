package com.fanniemae.pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.fanniemae.utilities.WebDriverUtils;
import com.fanniemae.utilities.WebElementUtils;

public class GitHubLoginPage {

	public void validateRecordCount(String browser){
		String recordCount = WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[5]/div[2]/div[1]/div[1]/div/div[2]/div/div[1]/div/div[3]/h1/span[1]")).getText();
		recordCount = recordCount.replaceAll(",", "");
		Assert.assertTrue(Integer.parseInt(recordCount)>0);
	}
	
	public void setUserLogin(String browser,String username, String password){
		WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[3]/div[1]/div/form/div[4]/input[1]")).clear();
		WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[3]/div[1]/div/form/div[4]/input[1]")).sendKeys(username);
		WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[3]/div[1]/div/form/div[4]/input[2]")).clear();
		WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[3]/div[1]/div/form/div[4]/input[2]")).sendKeys(password);
				
	}
	
	public void clickSignInButton(String browser){
		WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[3]/div[1]/div/form/div[4]/input[3]")).click();
		
	}
	
	public void verifyInvalidLoginMsg(String browser, String errorMsgExpected){
		WebElementUtils.waitUntilElementIsVisible(By.xpath("html/body/div[3]/div[1]/div/form/div[3]/div/div"),browser);
		if(WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[3]/div[1]/div/form/div[3]/div/div")).isDisplayed()){
		String actualText = WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[3]/div[1]/div/form/div[3]/div/div")).getText();
		Assert.assertEquals(errorMsgExpected, actualText);
		}
		
	}
	
}
