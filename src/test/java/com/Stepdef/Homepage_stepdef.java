package com.Stepdef;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class Homepage_stepdef  {
	public WebDriver driver;
	public String path = "./Drivers//geckodriver.exe";
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", path);
		driver = new FirefoxDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");
		
	}
	
	@Given("User should be on Homepage")
	public void user_should_be_on_homepage() {
       System.out.println(driver.getTitle());	  
	}
	@When("User enter search items")
	public void user_enter_search_items(DataTable value) {
		    List<String> data =  value.row(0);
		    driver.findElement(By.xpath("//input[contains(@type,'text')]")).sendKeys(data.get(0));
		
	}
	@Then("User click on Search icon And result page")
	public void user_click_on_search_icon_and_result_page() {
	    driver.findElement(By.xpath("//input[contains(@type,'submit')]")).click();
	}

	@Given("User click on Create account button")
	public void user_click_on_create_account_button() {
	   Actions act  = new Actions(driver);
	   WebElement Login = driver.findElement(By.xpath("//span[contains(text(),'Hello, sign in')]"));
	   WebElement Starthere = driver.findElement(By.xpath("//a[contains(text(),'Start here.')]"));
	   act.moveToElement(Login).pause(2000).click(Starthere).build().perform();
	}
	@When("User Enter {string} and {string} and {string} and {string}")
	public void user_enter_and_and_and(String YourName, String mobilenumber, String Password, String ReEnterPassword) {
	    driver.findElement(By.id("ap_customer_name")).sendKeys(YourName);
	    driver.findElement(By.id("ap_email")).sendKeys(mobilenumber);
	    driver.findElement(By.id("ap_password")).sendKeys(Password);
	    driver.findElement(By.id("ap_password_check")).sendKeys(ReEnterPassword);
	}
	@Then("User click on Continue button and User will be on home page")
	public void user_click_on_continue_button_and_user_will_be_on_home_page() {
	    driver.findElement(By.id("continue")).click();
	}
	@After
	public void teardown() {
		driver.quit();
	}

}
