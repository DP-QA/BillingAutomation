package com.scmp.Core;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotLib 
{
public static void CaptureScreenshot(WebDriver driver, String ScreenshotName)
{
	try {
		TakesScreenshot ts= (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String Dest= "./screenshot/"+ScreenshotName+".png";
		File Destination= new File(Dest);
		FileUtils.copyFile(src, Destination);
		
	} 
	catch (IOException e) {
		String message= e.getMessage();
		
	}   


}
}

