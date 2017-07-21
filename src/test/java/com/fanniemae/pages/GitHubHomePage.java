package com.fanniemae.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fanniemae.utilities.Constants;
import com.fanniemae.utilities.WebDriverUtils;
import com.fanniemae.utilities.WebElementUtils;

public class GitHubHomePage {
	
	public static final String SEARCH_TEXT_FIELD_XPATH = "html/body/header/table/tbody/tr/td[3]/form/table/tbody/tr/td[1]/div[1]/div/input";
	public static final String SEARCH_BUTTON_XPATH = "html/body/header/table/tbody/tr/td[3]/form/table/tbody/tr/td[3]/input";
	
	@FindBy(xpath=SEARCH_TEXT_FIELD_XPATH)
	private WebElement searchTextField;
	
	@FindBy(xpath=SEARCH_BUTTON_XPATH)
	private WebElement searchButton;
	
	public void openHomPage(String browser){
		WebDriverUtils.getWebDriver(browser).get(Constants.GITHUB_HOME_URL);
	}
	public void verifyHomPage(String browser){
		WebElementUtils.waitUntilElementIsVisible(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/form/button"),browser);
		String actualText = WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[4]/div[1]/div/div/div[2]/form/button")).getText();
		String expectedText = "Sign up for GitHub";
		System.out.println("actualText"+actualText);
		Assert.assertEquals(expectedText, actualText);
		
	}

	public void searchItem(String browser, String item2search){
		WebDriverUtils.getWebDriver(browser).findElement(By.xpath(SEARCH_TEXT_FIELD_XPATH)).clear();
		WebDriverUtils.getWebDriver(browser).findElement(By.xpath(SEARCH_TEXT_FIELD_XPATH)).sendKeys(item2search);
		WebDriverUtils.getWebDriver(browser).findElement(By.xpath(SEARCH_BUTTON_XPATH)).click();
	}
	
	public void verifyCurrentUrl(String browser){
		String actualUrl = WebDriverUtils.getWebDriver(browser).getCurrentUrl();
		Assert.assertEquals(Constants.GITHUB_HOME_URL, actualUrl);
	}
	
	public void clickOnSignIn(String browser){
		WebDriverUtils.getWebDriver(browser).findElement(By.xpath("html/body/div[1]/header/div/div/div/a[1]")).click();
	}
}
