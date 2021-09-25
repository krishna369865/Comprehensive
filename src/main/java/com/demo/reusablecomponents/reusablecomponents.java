package com.demo.reusablecomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class reusablecomponents {
	public Properties prop;
	public static WebDriver driver;
	public WebDriver initializeDriver() throws IOException {
	    prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\Kumar\\eclipse-workspace\\demo1\\config.properties");
		prop.load(fis);
		String browser1=prop.getProperty("browser");
		if(browser1.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Kumar\\eclipse-workspace\\demo1\\resorces1\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browser1.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser1.equals("IE")) {
			System.setProperty("webdriver.ie.driver","E:\\IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			
		}
		
		return driver;
	
		
	}
	public  static void takescreenshot(String result) throws IOException{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\Kumar\\eclipse-workspace\\demo1\\screeshots\\screenshot.jpg"));
	}

}

