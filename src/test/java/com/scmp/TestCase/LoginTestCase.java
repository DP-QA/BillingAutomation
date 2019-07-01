package com.scmp.TestCase;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.scmp.Core.OpenAndCloseBrowser;
import com.scmp.Core.ScreenShotLib;
import com.scmp.PageObject.LoginPage;

public class LoginTestCase extends OpenAndCloseBrowser
{

@Test(priority=0)
public void VerifyValidLogin()
{
	LoginPage lpo= new LoginPage(driver);
	lpo.typeusername("scmptester1@gmail.com");
	lpo.typepassword("qwerpoiu123");
	lpo.clicksubmit();
	Assert.assertEquals(driver.getTitle(), "Hong Kong Edition | South China Morning Post");
}
@Test(priority=1)
public void VerifyInvalidLogin()
{
	LoginPage lpo= new LoginPage(driver);
	lpo.typeusername("scmptester1@gmail.com");
	lpo.typepassword("ttt");
	lpo.clicksubmit();	
	Assert.assertEquals(driver.getTitle(), "Hong Kong Edition | South China Morning Post");
}
@AfterMethod
public void tearDown(ITestResult result)
{
	  if(result.FAILURE==result.getStatus())
	  {
		  ScreenShotLib.CaptureScreenshot(driver, result.getName());
		 
	  }

		 driver.quit();
}
}
