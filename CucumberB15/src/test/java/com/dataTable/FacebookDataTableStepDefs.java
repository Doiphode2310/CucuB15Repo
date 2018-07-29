package com.dataTable;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.io.FileResourceIteratorFactory;

public class FacebookDataTableStepDefs {
	
	WebDriver driver;
	
	@Before
	public void setUp() throws InterruptedException {
		System.out.println("in setup");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Jyoti\\Documents\\JavaClasses\\Selenium\\chromedriver_win32_B39\\chromedriver.exe");
		driver = new ChromeDriver();
//		System.setProperty("webdriver.gecko.driver", "D:\\Training\\TrainingContent\\SeleniumJars_Software\\geckodriver_64\\geckodriver.exe");
//		driver = new FirefoxDriver();
		driver.get("https://www.facebook.com/");
		System.out.println("opned browser");
		Thread.sleep(2000);
	}
	
	
	@Given("^the user is on facebook login Page$")
	public void the_user_is_on_facebook_login_Page() throws InterruptedException{
		System.out.println("actual script started");
		//driver.get("https://www.facebook.com/");
		//Thread.sleep(2000);
	}
	
	
	@When("^he enters following data$")
	public void he_enters_following_data(DataTable table) throws InterruptedException{
		//Initialize data table 
	      List<List<String>> data = table.raw();
	      System.out.println(data.get(0).get(0)); //print the table column Name OR first element
	    
	      driver.findElement(By.id("u_0_j")).sendKeys(data.get(1).get(1)); // First Name
	      driver.findElement(By.id("u_0_l")).sendKeys(data.get(2).get(1)); // Last Name
	      driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(data.get(3).get(1)); // Mobile No
	      driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys(data.get(5).get(1)); // New PWD
	      	      	      
	      Select birthDay = new Select(driver.findElement(By.xpath("//select [@title='Day']")));
	      birthDay.selectByVisibleText((data.get(6).get(1)).substring(0, 2));
	      
	      //convert String value to Integer to pass that value as Index
	      String birthMonStr = (data.get(6).get(1)).substring(3, 5);
	      int birthMonInt = Integer.parseInt(birthMonStr);
	      
	      Select birthMonth = new Select(driver.findElement(By.xpath("//select [@title='Month']")));
	      birthMonth.selectByIndex(birthMonInt);
	      
	      Select birthYear = new Select(driver.findElement(By.xpath("//select [@title='Year']")));
	      birthYear.selectByVisibleText((data.get(6).get(1)).substring(6, 10));
	      
	      if ((data.get(7).get(1)).trim().equals("Female")){
	    	  driver.findElement(By.xpath("//input[@value='1']")).click();
	      }else if ((data.get(7).get(1)).trim().equals("Male")){
	    	  driver.findElement(By.xpath("//input[@value='1']")).click();
	      }  
	      
	      Thread.sleep(2000);
	      
	}
	
	@Then("check signup should failed")
	public void check_signup_should_failed(){
		Assert.assertTrue(true);
		driver.quit();
		driver =null;
	}
	
}
