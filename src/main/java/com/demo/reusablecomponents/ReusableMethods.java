package com.demo.reusablecomponents;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class ReusableMethods {

	
		// TODO Auto-generated method stub
		public static void  loadingURL(WebDriver driver) throws FileNotFoundException
		{
			driver.get(com.properties.reader.PropertyFileReader.loadfile().getProperty("url"));
			timelaps(driver);
		}
		public static void timelaps(WebDriver driver) throws NumberFormatException, FileNotFoundException
		{
			int time=Integer.parseInt(com.properties.reader.PropertyFileReader.loadfile().getProperty("implicitwait1"));
			driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
		}
		public static boolean sendKeys(By selector,String name,WebDriver driver) throws Exception
		{
			try
			{
				driver.findElement(selector).sendKeys(name);
				return true;
			}
			catch(Exception e)
			{
				throw new Exception(String.format("Error in spending [%s] to the followed element:[%s]",name,selector.toString()));
			}
			
		}
		public static boolean getElement(By selector,WebDriver driver)
		{
			try
			{
				driver.findElement(selector);
				return true;
			}
			catch(Exception e)
			{
				System.out.println(String.format("Element %s doesnot found-proceeding",selector));
				return false;
			}
		}
		
		

	
		public static boolean click(By selector,WebDriver driver) throws Exception
		{
			WebElement element=driver.findElement(selector);
			try
			{
				element.click();
				return true;
			}
			catch (Exception e)
			{
				throw new Exception(String.format("The following element is not clickable:[%s]", selector));
			}
		}
		public static boolean sendKeys(By selector,Keys Enter ,WebDriver driver) throws Exception
		{
			try
			{
				driver.findElement(selector).sendKeys(Keys.ENTER);
				return true;
			}
			catch(Exception e)
			{
				throw new Exception(String.format("Error in spending [%s] to the followed element:[%s]",Enter,selector.toString()));
			}
		
		
		

		}
}

