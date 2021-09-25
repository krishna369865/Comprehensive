package bdd;


import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.demo.pageobject.urbammatressess;
import com.demo.pageobject.urbancollection;
import com.demo.pageobject.urbandecor;
import com.demo.pageobject.urbanhelp;
import com.demo.pageobject.urbansale;
import com.demo.pageobject.urbansearch;
import com.demo.pageobject.urbansignup;
import com.demo.pageobject.urbanstorage;
import com.demo.pageobject.urbanstores;
import com.demo.reusablecomponents.ReusableMethods;
import com.demo.reusablecomponents.reusablecomponents;

@RunWith(Cucumber.class)
public class Mystepdefinition extends reusablecomponents {
	public static Logger Log=LogManager.getLogger(reusablecomponents.class.getName());

    @Given("^Initialize chrome browser$")
    public void initialize_chrome_browser() throws Throwable {
    	driver=initializeDriver();
		driver.manage().window().maximize();
    }
    @Given("^Navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
        driver.get(strArg1);
    }

    @When("^Navigate to Login and enter username \"([^\"]*)\"  and password \"([^\"]*)\"$")
    public void navigate_to_login_and_enter_username_something_and_password_something(String strArg1, String strArg2) throws Throwable {
    	Actions a=new Actions(driver);
		WebElement actels=driver.findElement(urbansignup.icon);
		a.moveToElement(actels).build().perform();
		ReusableMethods.click(urbansignup.signupicon, driver);
		Thread.sleep(15000);
		Log.info("Enter the Username and Password");
		ReusableMethods.sendKeys(urbansignup.username,strArg1, driver);
		Thread.sleep(15000);
		ReusableMethods.click(urbansignup.showpass, driver);
		ReusableMethods.sendKeys(urbansignup.password,strArg2,driver);
    }

    @Then("^click on submit$")
    public void click_on_submit() throws Throwable {
    	ReusableMethods.click(urbansignup.signup, driver);
    	System.out.println(driver.findElement(By.xpath("//*[@id=\"ulerrors\"]/ul/li")).getText());
    }
     
   @Then("^close the driver$")
    public void close_the_driver() throws Throwable {
       driver.close();
    }
    
   @When("^Navigate to sale and click studychairs$")
   public void navigate_to_sale_and_click_studychairs() throws Throwable {
	   Thread.sleep(20000);
		ReusableMethods.click(urbancollection.close, driver);
		Thread.sleep(10000);
    	Actions a=new Actions(driver);
		Log.info("Entering into study chairs products");
		WebElement actels=driver.findElement(urbansale.sale);
		a.moveToElement(actels).build().perform();
		Thread.sleep(7000);
		ReusableMethods.click(urbansale.studychairs, driver);
    }
    @Then("^print products$")
    public void print_products() throws Throwable {
    	System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/ul/li[2]/div/div[5]/a")).getText());
    }
    @When("^Navigate to storage and click Tvunits$")
    public void navigate_to_storage_and_click_tvunits() throws Throwable {
    	 Thread.sleep(20000);
 		ReusableMethods.click(urbancollection.close, driver);
 		Thread.sleep(10000);
    	Actions a=new Actions(driver);
		Log.info("Entering into Tv units products");
		WebElement actels=driver.findElement(urbanstorage.storage);
		a.moveToElement(actels).build().perform();
		Thread.sleep(7000);
		ReusableMethods.click(urbanstorage.tvunits, driver);
    }

    @Then("^add to cart$")
    public void add_to_cart() throws Throwable {
    	Actions a=new Actions(driver);
		Log.info("Adding to cart");
		WebElement actels=driver.findElement(urbanstorage.pointcart);
		a.moveToElement(actels).build().perform();
    	ReusableMethods.click(urbanstorage.addcart, driver);
    }
    @When("^Navigate to sale and click weekly deals$")
    public void navigate_to_sale_and_click_weekly_deals() throws Throwable {
    	 Thread.sleep(20000);
  		ReusableMethods.click(urbancollection.close, driver);
  		Thread.sleep(10000);
     	Actions a=new Actions(driver);
 		Log.info("Entering into weekly deals products");
 		WebElement actels=driver.findElement(urbansale.sale);
 		a.moveToElement(actels).build().perform();
 		Thread.sleep(7000);
 		ReusableMethods.click(urbansale.dealofweek, driver);
    }

   
    @Then("^print deals products$")
    public void print_deals_products() throws Throwable {
    	Log.info("printing the product details");
    	System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div/div[1]")).getText());
    }
    @When("^Search for tables in search box$")
    public void search_for_tables_in_search_box() throws Throwable {
    	Thread.sleep(30000);
  		ReusableMethods.click(urbancollection.close, driver);
  		Thread.sleep(10000);
    	Log.info("Searching for Tables");
		ReusableMethods.sendKeys(urbansearch.search,"Tabels", driver);
		Thread.sleep(500);
		ReusableMethods.click(urbansearch.icon, driver);
    }

    
    @Then("^print all tables$")
    public void print_all_tables() throws Throwable {
    	Log.info("printing the availability");
    	System.out.println(driver.findElement(By.xpath("//*[@id=\"search-results\"]/div[3]")).getText());
    }
    @When("^Navigate to decor and select pouffe$")
    public void navigate_to_decor_and_select_pouffe() throws Throwable {
    	 Thread.sleep(20000);
   		ReusableMethods.click(urbancollection.close, driver);
   		Thread.sleep(10000);
      	Actions a=new Actions(driver);
  		Log.info("Entering into pouffe products");
  		WebElement actels=driver.findElement(urbandecor.decors);
  		a.moveToElement(actels).build().perform();
  		Thread.sleep(7000);
  		ReusableMethods.click(urbandecor.pouffe, driver);
        
    }

    @Then("^select low to high from recommended$")
    public void select_low_to_high_from_recommended() throws Throwable {
    	Log.info("selecting low to high price from recommended");
    	ReusableMethods.click(urbandecor.recommended, driver);
    	Thread.sleep(10000);
    	ReusableMethods.click(urbandecor.lowtohigh, driver);
    }
    @When("^navigate to matresses and select Queen matresses$")
    public void navigate_to_matresses_and_select_queen_matresses() throws Throwable {
    	 Thread.sleep(20000);
    		ReusableMethods.click(urbancollection.close, driver);
    		Thread.sleep(10000);
       	Actions a=new Actions(driver);
   		Log.info("Entering into Queen matresses");
   		WebElement actels=driver.findElement(urbammatressess.matress);
   		a.moveToElement(actels).build().perform();
   		Thread.sleep(7000);
   		Log.info("Viewing the paticular matresses");
   		ReusableMethods.click(urbammatressess.Queenmatress,driver);
    }

    
    @Then("^print name and details of matresses$")
    public void print_name_and_details_of_matresses() throws Throwable {
    	Log.info("Printing the quality of mattresses");
    	System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/ul/li[2]/div[1]/div[5]/a/div[1]/h2")).getText());
    	System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div[4]/div/ul/li[2]/div[1]/div[5]/a/div[1]/div[1]")).getText());
    }
    @When("^navigate to matresses$")
    public void navigate_to_matresses() throws Throwable {
    	Thread.sleep(20000);
		ReusableMethods.click(urbancollection.close, driver);
		Thread.sleep(10000);
   	Actions a=new Actions(driver);
		Log.info("Entering into Queen matresses");
		WebElement actels=driver.findElement(urbammatressess.matress);
		a.moveToElement(actels).build().perform();
		Thread.sleep(7000);
    }

    @Then("^print productes$")
    public void print_products1() throws Throwable {
    	Log.info("printing the products of mattresses");
    	System.out.println(driver.findElement(By.xpath("//*[@id=\"topnav_wrapper\"]/ul/li[8]/div/div/ul/li/ul")).getText());
    }
    @When("^navigate to help and click faqs$")
    public void navigate_to_help_and_click_faqs() throws Throwable {
    	Thread.sleep(20000);
		ReusableMethods.click(urbancollection.close, driver);
		Thread.sleep(10000);
    	Log.info("Seeking for help");
		ReusableMethods.click(urbanhelp.helps, driver);
		Log.info("Viewing the FAQS");
		ReusableMethods.click(urbanhelp.faqques, driver);
		
    }

    @Then("^select cancellation and print ans$")
    public void select_cancellation_and_print_ans() throws Throwable {
    	ReusableMethods.click(urbanhelp.question1, driver);
		Log.info("Printing the ans for question");
		System.out.println("Answer:");
		System.out.println(driver.findElement(By.xpath("//*[@id=\"9331\"]/div[3]/p")).getText());
		boolean answers=driver.findElement(By.xpath("//*[@id=\"9331\"]/div[3]/p")).getText().isEmpty();
		Assert.assertEquals(answers, false);
		
    }
    @When("^navigate to store and click first store$")
    public void navigate_to_store_and_click_first_store() throws Throwable {
    	Thread.sleep(20000);
		ReusableMethods.click(urbancollection.close, driver);
		Thread.sleep(10000);
    	Log.info("Viewing the store");
		ReusableMethods.click(urbanstores.store1, driver);
		ReusableMethods.click(urbanstores.pic, driver);
    }

    @Then("^print address$")
    public void print_address() throws Throwable {
    	Log.info("Printing the address");
    	System.out.println("Address:");	
    	System.out.println(driver.findElement(By.xpath("//*[@id=\"store-details\"]/div[4]/div[1]/address")).getText());
    	
        
    }




   


    

}
