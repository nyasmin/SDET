package com.fanniemae.steps;

import com.fanniemae.base.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_stepDefination extends TestBase{

	String loginHomeButton = "id_LOGIN_BUTTON_HOME";
	String loginButton = "xpath_LOGIN_BUTTON";
	String username = "id_LOGIN_USERNAME";
	String password = "id_LOGIN_PASSWORD";
	
	
	
	@Given("^user is on sdettraining homepage$")
	public void user_is_on_sdettraining_homepage() throws Throwable {
		
		setUp();
		isElementPresent(loginHomeButton);
		System.out.println("********HOME PAGE***************");
	}

	@When("^user clicks on Signin link$")
	public void a_user_click_on_Signin_link() throws Throwable {
		setUp();
		click(loginHomeButton);
		System.out.println("********Sign In LINK***************");
	}

	@When("^user enters \"([^\"]*)\" as username or email address$")
	public void user_enters_username_or_email_address(String username) throws Throwable {
		type(username,"sdet@sdettraining.com");
		System.out.println("********Username***************");
	}

	@When("^user enters \"([^\"]*)\" as password$")
	public void user_enters_password(String password) throws Throwable {
		type(password,"Password");
		System.out.println("********password***************");
		Thread.sleep(2000);
	}

	@When("^user click on signin button$")
	public void user_click_on_signin_button() throws Throwable {
		click(loginButton);
		System.out.println("********Sign In***************");
	}
	

	@Then("^user should see Welcome back message$")
	public void user_should_see_welcome_back_message() throws Throwable{
		System.out.println("********Welcome***************");
		
	}


}
