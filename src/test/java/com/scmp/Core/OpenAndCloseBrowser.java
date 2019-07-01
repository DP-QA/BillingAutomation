package com.scmp.Core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;



public class OpenAndCloseBrowser
{
	protected static WebDriver driver;
	@Parameters({"Browser","BaseUrl"})
	@BeforeMethod
	public void openBrowser(String Browser,String BaseUrl)
	{
			if (Browser.equalsIgnoreCase("ff"))
			{
				driver= new FirefoxDriver();
			}
			else if(Browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\rahul\\workspace\\com.automate\\Jars\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.get(BaseUrl);
		    driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public static WebDriver getInstance()
	{
		return driver;
	}
}
