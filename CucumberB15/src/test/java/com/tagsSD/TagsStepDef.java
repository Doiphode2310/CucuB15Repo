package com.tagsSD;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.But;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class TagsStepDef {
	
	
	WebDriver driver =null;
	
	@Given("^User need to be on Facebook login page$")
	public void user_need_to_be_on_Facebook_login_page(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jyoti\\Documents\\JavaClasses\\Selenium\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@When("^User enters user \"([^\"]*)\" first name$")
	public void user_enters_user_first_name(String userName) throws InterruptedException{
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(userName);
		Thread.sleep(1000);
	}
	
	@Then("^User checks user \"([^\"]*)\" first name is present$")
	public void user_checks_user_first_name_is_present(String userName) throws InterruptedException{
		String userNameActual =driver.findElement(By.xpath("//input[@name='firstname']")).getAttribute("value");
		Assert.assertEquals(userName, userNameActual);
		Thread.sleep(1000);
	}
	
	
	@And("User enters user \"([^\"]*)\" surname")
	public void user_enters_user_surname(String surName) throws InterruptedException{
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(surName);
		Thread.sleep(1000);
	}
	
	@And("User enters mobile \"([^\"]*)\" mobileNo")
	public void User_enters_mobile_mobileNo(String mobileNo) throws InterruptedException{
		driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(mobileNo);
		Thread.sleep(1000);
	}
	
	@Then("User Mobile field should be blank")
	public void user_Mobile_field_should_be_blank() throws InterruptedException{
		String mobileActual =driver.findElement(By.xpath("//input[@name='reg_email__']")).getAttribute("value");
		Assert.assertEquals("", mobileActual);
		Thread.sleep(1000);
	}
	
	
	@Then("close browser")
	public void close_browser(){
		driver.quit();
		driver =null;
	}
	
	
}